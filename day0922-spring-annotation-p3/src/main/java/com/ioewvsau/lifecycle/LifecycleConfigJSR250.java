package com.ioewvsau.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifecycleConfigJSR250 {
    @Bean
    public LifecycleBeanJSR250 lifecycleBeanJSR250() {
        return new LifecycleBeanJSR250();
    }
}
