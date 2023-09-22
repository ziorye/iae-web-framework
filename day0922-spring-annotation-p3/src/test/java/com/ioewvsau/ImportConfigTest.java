package com.ioewvsau;

import com.ioewvsau.atImport.ImportConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(ImportConfig.class)
public class ImportConfigTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    @DisplayName("测试使用 @Import 注解根据全类名注入")
    public void testImportRegularClasses() {
        assertTrue(applicationContext.containsBean("com.ioewvsau.atImport.Apple"));
        assertTrue(applicationContext.containsBean("com.ioewvsau.atImport.Cat"));

        assertFalse(applicationContext.containsBean("com.ioewvsau.atImport.Banana"));
    }
}
