package com.ioewvsau.mapper;

import com.ioewvsau.config.AppConfig;
import com.ioewvsau.pojo.User;
import com.ioewvsau.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(AppConfig.class)
public class UserServiceTest {
    @Autowired
    public UserService userService;

    @Test
    @DisplayName("测试不加事务的数据库操作")
    public void testSaveWithoutTransactional() {
        String name = "username-WithoutTransactional" + System.currentTimeMillis(); // or @AfterEach
        User user = new User();
        user.setName(name);
        user.setBalance(101);

        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> userService.saveWithoutTransactional(user));
        assertEquals("/ by zero", exception.getMessage());

        assertTrue(userService.selectUsersByName(name).size() > 0);
    }

    @Test
    @DisplayName("测试加了事务的数据库操作")
    public void testSaveWithTransactional() {
        String name = "username-WithTransactional" + System.currentTimeMillis();
        User user = new User();
        user.setName(name);
        user.setBalance(102);

        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> userService.saveWithTransactional(user));
        assertEquals("/ by zero", exception.getMessage());

        assertTrue(userService.selectUsersByName(name).size() == 0);
    }
}
