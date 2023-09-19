package service.impl;

import dao.UserDao;
import pojo.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao2) {
        this.userDao2 = userDao2;
    }

    UserDao userDao;

    UserDao userDao2;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao2() {
        return userDao2;
    }

    @Override
    public void register() {
        User user = this.userDao.selectByEmail("");
        // your other business logic ...
        this.userDao.save(user);
    }
}
