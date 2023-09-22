package com.ioewvsau;

import com.ioewvsau.atImportResource.ImportResourceConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(ImportResourceConfig.class)
public class ImportResourceConfigTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    @DisplayName("测试使用 @ImportResource 注解向容器注册组件")
    public void testCustomImportBeanDefinitionRegistrar() {
        assertTrue(applicationContext.containsBean("beanDemo"));
    }
}
