package com.ioewvsau.config;

import com.ioewvsau.controller.intercepter.MyInterceptor;
import com.ioewvsau.controller.intercepter.YInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.ioewvsau.controller")
@EnableWebMvc
public class MyServletConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new MyInterceptor());
        //registry.addInterceptor(new MyInterceptor()).addPathPatterns("/demo/i");
        // * 一层；** 多层
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/demo/**").excludePathPatterns("/demo/i");
        registry.addInterceptor(new YInterceptor()).addPathPatterns("/demo/**").excludePathPatterns("/demo/i");
    }
}
