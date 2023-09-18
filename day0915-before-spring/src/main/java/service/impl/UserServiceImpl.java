package service.impl;

import pojo.User;
import dao.UserDao;
import service.UserService;

public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register() {
        User user = this.userDao.selectByEmail("");
        // your other business logic ...
        this.userDao.save(user);
    }
}
