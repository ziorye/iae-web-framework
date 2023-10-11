package com.ioewvsau.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class CustomFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("CustomFilter.doFilter...");
        chain.doFilter(request, response);
        System.out.println("CustomFilter.doFilter...---after---");
    }
}
