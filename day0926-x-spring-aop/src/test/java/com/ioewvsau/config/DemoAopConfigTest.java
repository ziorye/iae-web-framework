package com.ioewvsau.config;

import com.ioewvsau.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

class DemoAopConfigTest {
    @Test
    void startTimeUsingAtBefore() {
        AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoAopConfig.class);
        UserDao userDao = applicationContext.getBean(UserDao.class);

        userDao.retrieve();
    }

    @Test
    void endTimeUsingAtAfter() {
        AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoAopConfig.class);
        UserDao userDao = applicationContext.getBean(UserDao.class);

        userDao.update();
    }

    @Test
    void elapsedTimeUsingAtAround() {
        AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoAopConfig.class);
        UserDao userDao = applicationContext.getBean(UserDao.class);

        userDao.delete();
    }
}