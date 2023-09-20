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

    @Test
    @DisplayName("测试单实例 Bean 的懒加载功能")
    public void testSingletonLazy() {
        // 真正使用 lazyPerson 之前，控制台看不到 ===lazy=== 输出
        applicationContext.getBean("lazyPerson");
        // 真正使用 lazyPerson 时，控制台才能看到 ===lazy=== 输出
    }
}
