package com.ioewvsau.service.impl;

import com.ioewvsau.dao.UserMapper;
import com.ioewvsau.pojo.User;
import com.ioewvsau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> getByPage(int rowCount, int offset) {
        return userMapper.selectByPage(rowCount, offset);
    }

    @Override
    public User getById(long id) {
        return userMapper.selectById(id);
    }

    @Override
    public boolean save(User user) {
        userMapper.add(user);
        return true;
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int deleteById(long id) {
        return userMapper.deleteById(id);
    }
}
