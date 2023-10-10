package com.ioewvsau;

import com.ioewvsau.service.HelloService;
import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
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
    }
}
