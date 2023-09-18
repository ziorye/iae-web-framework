package dao.impl;

import dao.UserDao;
import pojo.User;

public class SimpleUserDao implements UserDao {
    @Override
    public User selectByEmail(String email) {
        System.out.println("SimpleUserDao.selectByEmail --- " + email);
        return User.builder().email(email).build();
    }

    @Override
    public void save(User user) {
        user.setId(666888L);
        System.out.println("SimpleUserDao.save --- " + user);
    }
}
