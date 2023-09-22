package com.ioewvsau.atValue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:valueBean.properties"})
public class ValueBeanConfig {
    @Bean
    public ValueBean valueBean() {
        return new ValueBean();
    }
}
