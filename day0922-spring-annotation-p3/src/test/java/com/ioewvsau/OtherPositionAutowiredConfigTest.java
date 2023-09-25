package com.ioewvsau;

import com.ioewvsau.autowired.otherPosition.Boss;
import com.ioewvsau.autowired.otherPosition.OtherPositionAutowiredConfig;
import com.ioewvsau.autowired.otherPosition.Plane;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertSame;

@SpringJUnitConfig(OtherPositionAutowiredConfig.class)
public class OtherPositionAutowiredConfigTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    @DisplayName("测试 @Autowired 标注在构造方法上")
    public void testAutowiredAtConstructor() {
        assertSame(applicationContext.getBean("car"), applicationContext.getBean("boss", Boss.class).getCar());
    }

    @Test
    @DisplayName("测试 @Autowired 标注在 setter 方法上")
    public void testAutowiredAtSetterMethod() {
        assertSame(applicationContext.getBean("assistant"), applicationContext.getBean("boss", Boss.class).getAssistant());
    }

    @Test
    @DisplayName("测试 @Autowired 标注在方法参数上")
    public void testAutowiredAtMethodParameters() {
        assertSame(applicationContext.getBean("assistant"), applicationContext.getBean("plane", Plane.class).getAssistant());
    }
}
