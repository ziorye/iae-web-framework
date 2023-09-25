package com.ioewvsau.aware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwareConfig {
    @Bean
    public AwareBean awareBean() {
        return new AwareBean();
    }
}
