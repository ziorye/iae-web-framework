package com.ioewvsau.config;

import com.ioewvsau.bean.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ProxyBeanMethodsFalseConfig {
    @Bean
    public TestBean testBean() {
        return new TestBean();
    }
}
