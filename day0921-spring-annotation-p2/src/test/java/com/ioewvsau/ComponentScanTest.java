package com.ioewvsau;

import com.ioewvsau.config.DefaultFiltersConfig;
import com.ioewvsau.config.DefaultFiltersConfig2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ComponentScanTest {
    @Test
    @DisplayName("测试 @ComponentScan 注解的默认扫描规则")
    public void testDefaultFilters() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DefaultFiltersConfig.class);
        assertTrue(applicationContext.containsBean("demoController"));
        assertTrue(applicationContext.containsBean("demoService"));
        assertTrue(applicationContext.containsBean("demoDao"));
    }

    @Test
    @DisplayName("测试 @ComponentScan 注解的默认扫描规则 + basePackages设置多个值")
    public void testDefaultFiltersWithMultiBasePackages() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DefaultFiltersConfig2.class);

        assertTrue(applicationContext.containsBean("demoController"));
        assertTrue(applicationContext.containsBean("demoService"));

        assertFalse(applicationContext.containsBean("demoDao"));
    }
}
