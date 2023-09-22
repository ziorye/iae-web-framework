package com.ioewvsau;

import com.ioewvsau.lifecycle.LifecycleConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LifecycleConfigTest {
    private static final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @BeforeAll
    public static void setOutputStream() {
        System.setOut(new PrintStream(out));
    }

    @BeforeEach
    public void resetOut() {
        out.reset();
    }

    @Test
    @DisplayName("测试 Lifecycle Callbacks - @Bean 注解实现的 initMethod 和 destroyMethod 配置")
    public void testInitMethodAndDestroyMethodAttributesOfBeanAnnotation() {
        AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifecycleConfig.class);

        assertEquals(
                "...constructor..." + System.lineSeparator() +
                        "...initMethod..." + System.lineSeparator(),
                out.toString()
        );

        applicationContext.close();

        assertEquals(
                "...constructor..." + System.lineSeparator() +
                        "...initMethod..." + System.lineSeparator() +
                        "...destroyMethod..." + System.lineSeparator(),
                out.toString()
        );
    }
}
