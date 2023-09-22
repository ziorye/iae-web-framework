package com.ioewvsau;

import com.ioewvsau.condition.ConditionalConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(ConditionalConfig.class)
public class ConditionalConfigTest {
    static {
        System.setProperty("os.name", "Windows 11");
    }

    @Autowired
    ApplicationContext applicationContext;

    @Test
    @DisplayName("测试 WindowsCondition")
    public void testWindowsCondition() {
        assertTrue(applicationContext.containsBean("windowsPerson"));
    }

    @Test
    @DisplayName("测试 MacCondition")
    public void testMacCondition() {
        assertFalse(applicationContext.containsBean("macPerson"));
    }
}
