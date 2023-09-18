package dao.impl;

import pojo.User;
import dao.UserDao;

public class NopeUserDao implements UserDao {
    @Override
    public User selectByEmail(String email) {
        System.out.println("NopeUserDao.selectByEmail");
        return null;
    }

    @Override
    public void save(User user) {
        System.out.println("NopeUserDao.save");
    }
}
