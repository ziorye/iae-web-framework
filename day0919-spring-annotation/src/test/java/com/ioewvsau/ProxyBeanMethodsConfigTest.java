package com.ioewvsau;

import com.ioewvsau.bean.TestBean;
import com.ioewvsau.config.ProxyBeanMethodsFalseConfig;
import com.ioewvsau.config.ProxyBeanMethodsTrueConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProxyBeanMethodsConfigTest {
    @Test
    @DisplayName("测试 @Configuration 配置类中用 @Bean 标注的方法默认是被代理了的方法，重复调用方法不会重复 new 新对象")
    public void testProxyBeanMethodsTrue() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProxyBeanMethodsTrueConfig.class);

        ProxyBeanMethodsTrueConfig proxyBeanMethodsTrueConfig = applicationContext.getBean(ProxyBeanMethodsTrueConfig.class);

        TestBean p1 = proxyBeanMethodsTrueConfig.testBean();
        TestBean p2 = proxyBeanMethodsTrueConfig.testBean();

        Assertions.assertSame(p1, p2);

        Assertions.assertTrue(proxyBeanMethodsTrueConfig.getClass().getName().contains("$$SpringCGLIB$$"));
    }

    @Test
    @DisplayName("测试 @Configuration(proxyBeanMethods = false) 与默认情况相反，配置类中用 @Bean 标注的方法不再是被代理的方法了，重复调用方法会重复 new 出新对象")
    public void testProxyBeanMethodsFalse() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProxyBeanMethodsFalseConfig.class);

        ProxyBeanMethodsFalseConfig proxyBeanMethodsFalseConfig = applicationContext.getBean(ProxyBeanMethodsFalseConfig.class);

        System.out.println(proxyBeanMethodsFalseConfig);
        TestBean p1 = proxyBeanMethodsFalseConfig.testBean();
        TestBean p2 = proxyBeanMethodsFalseConfig.testBean();

        Assertions.assertNotSame(p1, p2);

        Assertions.assertFalse(proxyBeanMethodsFalseConfig.getClass().getName().contains("$$SpringCGLIB$$"));
    }
}
