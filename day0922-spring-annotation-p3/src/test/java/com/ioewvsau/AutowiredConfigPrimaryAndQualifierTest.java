package com.ioewvsau;

import com.ioewvsau.autowired.AutowiredPrimaryConfig;
import com.ioewvsau.autowired.AutowiredQualifierConfig;
import com.ioewvsau.autowired.PrimaryController;
import com.ioewvsau.autowired.QualifierController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutowiredConfigPrimaryAndQualifierTest {
    @Test
    @DisplayName("测试 @Autowired 与标注了 @Primary 注解的 Bean")
    public void testAutowiredAnnotationWithPrimaryBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredPrimaryConfig.class);
        PrimaryController primaryController = applicationContext.getBean("primaryController", PrimaryController.class);
        assertEquals("other", primaryController.getPrimaryBean().getDesc());
    }

    @Test
    @DisplayName("测试 @Autowired 与 @Qualifier 配合使用")
    public void testAutowiredAnnotationWithQualifier() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredQualifierConfig.class);
        QualifierController qualifierController = applicationContext.getBean("qualifierController", QualifierController.class);
        assertEquals("other", qualifierController.getPrimaryBean().getDesc());
    }
}
