package mapper;

import config.AppConfig;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import pojo.User;

@SpringJUnitConfig(AppConfig.class)
public class UserMapperTest {
    @Autowired
    public UserMapper userMapper;

    private static int initUserId = 0;
    private static final String initUserName = "before-each";
    @BeforeEach
    void init() {
        User user = new User();
        user.setName(initUserName);
        user.setBalance(123);
        userMapper.insertUser(user);

        initUserId = user.getId();
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setName("username");
        user.setBalance(100);

        userMapper.insertUser(user);

        Assertions.assertTrue(user.getId() > 1);
    }

    @Test
    public void testSelectUser(){
        User user = userMapper.selectUser(initUserId);
        Assertions.assertEquals(initUserName, user.getName());
    }

    @Test
    public void testUpdateUser(){
        String updatedUserName = "username-updated";
        User user = new User();
        user.setId(1);
        user.setName(updatedUserName);
        user.setBalance(5);

        userMapper.updateUser(user);

        Assertions.assertEquals(updatedUserName, user.getName());
    }

    @Test
    public void testDeleteUser(){
        userMapper.deleteUser(initUserId);

        User user = userMapper.selectUser(initUserId);

        Assertions.assertNull(user);
    }

    @AfterEach
    void destroy() {
        userMapper.truncate();
    }
}
