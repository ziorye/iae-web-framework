package com.ioewvsau.dao.impl;

import com.ioewvsau.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void create() {
        long startTime = System.currentTimeMillis();
        System.out.println("startTime = " + startTime);

        System.out.println("UserDaoImpl.create");
    }

    @Override
    public void update() {
        System.out.println("UserDaoImpl.update");
    }

    @Override
    public void retrieve() {
        System.out.println("UserDaoImpl.retrieve");
    }

    @Override
    public void delete() {
        System.out.println("UserDaoImpl.delete");
    }
}
