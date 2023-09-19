package com.ioewvsau;

import com.ioewvsau.config.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(AppConfig.class)
public class PersonTestWithSpringTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    void person() {
        Assertions.assertTrue(applicationContext.containsBean("person"));
    }

    @Test
    void personWithBeanName() {
        Assertions.assertFalse(applicationContext.containsBean("personWithBeanName"));
        Assertions.assertTrue(applicationContext.containsBean("specialBeanName"));
        //Assertions.assertTrue(applicationContext.containsBean("anotherBeanName"));
    }
}
