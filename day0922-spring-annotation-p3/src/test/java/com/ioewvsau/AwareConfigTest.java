package com.ioewvsau;

import com.ioewvsau.aware.AwareBean;
import com.ioewvsau.aware.AwareConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(AwareConfig.class)
public class AwareConfigTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    @DisplayName("测试 Bean 实现 ApplicationContextAware 之后，会将 ApplicationContext 自动注入给 Bean")
    public void testApplicationContextAware() {
        AwareBean awareBean = applicationContext.getBean("awareBean", AwareBean.class);
        Assertions.assertSame(applicationContext, awareBean.applicationContext);
    }

    @Test
    @DisplayName("测试 Bean 实现 BeanNameAware 之后，会将该 Bean 在容器中的名称自动注入给 Bean")
    public void testBeanNameAware() {
        AwareBean awareBean = applicationContext.getBean("awareBean", AwareBean.class);
        Assertions.assertEquals("awareBean", awareBean.beanName);
    }

    @Test
    @DisplayName("测试 Bean 实现 EmbeddedValueResolverAware 之后，在该 Bean 的 setEmbeddedValueResolver 中可以解析 SpEL 表达式")
    public void testEmbeddedValueResolverAware() {
        AwareBean awareBean = applicationContext.getBean("awareBean", AwareBean.class);
        Assertions.assertEquals(applicationContext.getEnvironment().getProperty("os.name"), awareBean.osName);
    }
}
