package com.ioewvsau.config;

import com.ioewvsau.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanScopeConfig {

    @Bean
    //@Scope("singleton")
    public Person singletonPerson() {
        return new Person("singletonPerson", 18);
    }

    @Bean
    @Scope("prototype")
    public Person prototypePerson() {
        return new Person("prototypePerson", 18);
    }

    @Bean
    @Scope("singleton")
    @Lazy
    public Person lazyPerson() {
        System.out.println("===lazy===");
        return new Person("lazyPerson", 18);
    }
}
