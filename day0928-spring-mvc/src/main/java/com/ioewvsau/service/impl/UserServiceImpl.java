package com.ioewvsau.service.impl;

import com.ioewvsau.dao.UserDao;
import com.ioewvsau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void save() {
        userDao.insert();
    }
}
