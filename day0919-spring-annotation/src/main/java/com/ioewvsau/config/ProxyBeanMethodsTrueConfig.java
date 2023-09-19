package com.ioewvsau.config;

import com.ioewvsau.bean.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = true)
public class ProxyBeanMethodsTrueConfig {
    @Bean
    public TestBean testBean() {
        return new TestBean();
    }
}
