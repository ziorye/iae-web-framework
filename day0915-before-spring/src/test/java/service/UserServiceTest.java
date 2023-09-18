package service;

import dao.impl.NopeUserDao;
import dao.impl.SimpleUserDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.impl.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void register() {
        UserServiceImpl userService = new UserServiceImpl(new SimpleUserDao());
        assertInstanceOf(SimpleUserDao.class, userService.getUserDao());
    }

    @Test
    void switchUserDaoProviders() {
        UserServiceImpl userService = new UserServiceImpl(new NopeUserDao());
        assertInstanceOf(NopeUserDao.class, userService.getUserDao());
    }
}