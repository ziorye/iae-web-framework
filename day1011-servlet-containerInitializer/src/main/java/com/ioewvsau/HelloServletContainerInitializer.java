package com.ioewvsau;

import com.ioewvsau.filter.CustomFilter;
import com.ioewvsau.listener.CustomListener;
import com.ioewvsau.service.HelloService;
import com.ioewvsau.servlet.CustomServlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.HandlesTypes;

import java.util.Set;

@HandlesTypes({HelloService.class})
public class HelloServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("HelloServletContainerInitializer.onStartup");
        System.out.println("=== === ===");
        for (Class<?> hs : c) {
            System.out.println(hs);
        }

        // add Servlet
        ServletRegistration.Dynamic cs = ctx.addServlet("cs", new CustomServlet());
        cs.addMapping("/cs");

        // add Filter
        FilterRegistration.Dynamic cf = ctx.addFilter("cf", new CustomFilter());
        cf.addMappingForUrlPatterns(null, true, "/cs");

        // add Listener
        ctx.addListener(CustomListener.class);
    }
}
