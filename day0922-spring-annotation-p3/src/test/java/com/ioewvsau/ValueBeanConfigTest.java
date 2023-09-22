package com.ioewvsau;

import com.ioewvsau.atValue.ValueBean;
import com.ioewvsau.atValue.ValueBeanConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(ValueBeanConfig.class)
public class ValueBeanConfigTest {
    @Autowired
    ValueBean valueBean;

    @Test
    @DisplayName("测试通过 @Value(\"字符串\")")
    public void testValueAnnotation() {
        assertEquals("textFromValueAnnotation", valueBean.getText());
    }

    @Test
    @DisplayName("测试通过 @Value Properties")
    public void testValueAnnotationByProperties() {
        assertEquals("descriptionFromProperties", valueBean.getDescription());
    }

    @Test
    @DisplayName("测试通过 @Value SpEL 表达式")
    public void testValueAnnotationBySpEL() {
        assertEquals(2, valueBean.getOrder());
    }
}
