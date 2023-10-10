package com.ioewvsau.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class CustomListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("CustomListener.contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("CustomListener.contextDestroyed");
    }
}
