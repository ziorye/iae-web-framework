package dao;

import pojo.User;

public interface UserDao {
    User selectByEmail(String email);
    void save(User user);
}
