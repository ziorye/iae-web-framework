package com.ioewvsau.config;

import com.ioewvsau.bean.Person;
import com.ioewvsau.bean.PersonWithBeanName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Person person() {
        return new Person("name", 18);
    }

    @Bean("specialBeanName")
    //@Bean({"specialBeanName", "anotherBeanName"})
    public PersonWithBeanName personWithBeanName() {
        return new PersonWithBeanName();
    }
}
