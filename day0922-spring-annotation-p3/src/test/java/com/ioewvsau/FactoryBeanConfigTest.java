package com.ioewvsau;

import com.ioewvsau.factoryBean.CustomBean;
import com.ioewvsau.factoryBean.CustomFactoryBean;
import com.ioewvsau.factoryBean.FactoryBeanConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(FactoryBeanConfig.class)
public class FactoryBeanConfigTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    @DisplayName("测试使用 FactoryBean 注入组件")
    public void testFactoryBean() {
        assertTrue(applicationContext.containsBean("customFactoryBean"));

        Object customFactoryBean = applicationContext.getBean("customFactoryBean");
        assertFalse(customFactoryBean instanceof CustomFactoryBean);
        assertInstanceOf(CustomBean.class, customFactoryBean);

        // &
        Object customFactoryBean2 = applicationContext.getBean("&customFactoryBean");
        assertTrue(customFactoryBean2 instanceof CustomFactoryBean);
    }
}
