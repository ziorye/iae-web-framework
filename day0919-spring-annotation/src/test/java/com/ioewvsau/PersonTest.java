package com.ioewvsau;

import com.ioewvsau.config.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonTest {
    @Test
    void person() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Assertions.assertTrue(ac.containsBean("person"));
    }
}
