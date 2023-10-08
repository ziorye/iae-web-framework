package com.ioewvsau.dao;

import com.ioewvsau.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    List<User> selectAll();

    List<User> selectByPage(@Param("rowCount") int rowCount, @Param("offset") int offset);

    @Select("select * from user where id = #{id}")
    User selectById(long id);

    List<User> selectByCondition(User user);

    List<User> selectByCondition(Map<String, Object> map);

    void add(User user);

    void update(User user);

    void deleteById(long id);

    void deleteByIds(long[] ids);

    @Update("TRUNCATE TABLE USER")
    void truncate();
}
