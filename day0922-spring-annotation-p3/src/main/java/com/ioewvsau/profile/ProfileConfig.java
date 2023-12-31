package com.ioewvsau.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {
    @Profile({"test", "dev"})
    @Bean
    public BeanOne beanOne() {
        return new BeanOne();
    }

    @Profile("test")
    @Bean
    public BeanTwo beanTwo() {
        return new BeanTwo();
    }

    @Profile("prod")
    @Bean
    public BeanThree beanThree() {
        return new BeanThree();
    }
}
