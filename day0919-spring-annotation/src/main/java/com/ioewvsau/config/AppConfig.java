package com.ioewvsau.config;

import com.ioewvsau.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Person person() {
        return new Person("name", 18);
    }
}
