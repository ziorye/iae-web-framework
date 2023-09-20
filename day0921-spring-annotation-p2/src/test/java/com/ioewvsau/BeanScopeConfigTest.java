package com.ioewvsau;

import com.ioewvsau.config.BeanScopeConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(BeanScopeConfig.class)
public class BeanScopeConfigTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    @DisplayName("测试单实例 Bean")
    public void testSingletonScope() {
        assertSame(applicationContext.getBean("singletonPerson"), applicationContext.getBean("singletonPerson"));
    }

    @Test
    @DisplayName("测试多实例 Bean")
    public void testPrototypeScope() {
        assertNotSame(applicationContext.getBean("prototypePerson"), applicationContext.getBean("prototypePerson"));
    }
}
