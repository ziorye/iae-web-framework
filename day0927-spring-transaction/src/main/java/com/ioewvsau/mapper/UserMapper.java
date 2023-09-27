package com.ioewvsau.mapper;

import com.ioewvsau.pojo.User;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    User selectUser(int id);

    List<User> selectUsersByName(String name);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    @Update("TRUNCATE TABLE USER")
    void truncate();
}
