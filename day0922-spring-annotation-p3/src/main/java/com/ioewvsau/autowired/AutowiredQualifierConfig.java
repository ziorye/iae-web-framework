package com.ioewvsau.autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ioewvsau.autowired")
public class AutowiredQualifierConfig {
    @Bean
    public PrimaryBean primaryBean2() {
        return new PrimaryBean("other");
    }
}
