package com.ioewvsau;

import com.ioewvsau.config.MyWebConfig;
import com.ioewvsau.config.MyRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * ref: <a href="https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-servlet/container-config.html">Servlet Config</a>
 */
public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {MyRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {MyWebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
