package com.ioewvsau.service;

import com.ioewvsau.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    List<User> getByPage(int rowCount, int offset);

    User getById(long id);

    boolean save(User user);

    int update(User user);

    int deleteById(long id);
}
