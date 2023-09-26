package com.ioewvsau.config;

import com.ioewvsau.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

class StartTimeConfigTest {
    @Test
    void startTime() {
        AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(StartTimeConfig.class);
        UserDao userDao = applicationContext.getBean(UserDao.class);

        userDao.create();
    }
}