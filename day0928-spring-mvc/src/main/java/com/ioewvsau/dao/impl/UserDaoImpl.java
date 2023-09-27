package com.ioewvsau.dao.impl;

import com.ioewvsau.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void insert() {
        System.out.println("UserDaoImpl.insert");
    }
}
