package com.ioewvsau.service.impl;

import com.ioewvsau.mapper.UserMapper;
import com.ioewvsau.pojo.User;
import com.ioewvsau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void saveWithoutTransactional(User user) {
        userMapper.insertUser(user);
        int a = 1/0;
    }

    @Override
    public void saveWithTransactional(User user) {
        userMapper.insertUser(user);
        int a = 1/0;
    }

    @Override
    public List<User> selectUsersByName(String name) {
        return userMapper.selectUsersByName(name);
    }
}
