package com.ioewvsau.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalConfig {
    @Bean
    @Conditional({WindowsCondition.class})
    public Person windowsPerson() {
        return new Person("windowsPerson", 18);
    }

    @Bean
    @Conditional({MacCondition.class})
    public Person macPerson() {
        return new Person("macPerson", 18);
    }
}
