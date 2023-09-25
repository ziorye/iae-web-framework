package com.ioewvsau;

import com.ioewvsau.profile.ProfileConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(ProfileConfig.class)
public class ProfileConfigTest {
    @Autowired
    ApplicationContext applicationContext;

    static {
        System.setProperty("spring.profiles.active", "test");
    }

    @Test
    @DisplayName("测试 @Profile 注解")
    public void testProfile() {
        Assertions.assertTrue(applicationContext.containsBean("beanOne"));
        Assertions.assertTrue(applicationContext.containsBean("beanTwo"));
        Assertions.assertFalse(applicationContext.containsBean("beanThree"));
    }
}
