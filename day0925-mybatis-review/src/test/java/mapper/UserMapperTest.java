package mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;
import pojo.User;

import java.io.InputStream;

public class UserMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeAll
    public static void createSqlSessionFactory() throws Exception {
        // 创建sqlSessionFactory

        // mybatis配置文件
        String resource = "mybatisConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    private static int initUserId = 0;
    private static final String initUserName = "before-each";
    @BeforeEach
    void init() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            UserMapper mapper = session.getMapper(UserMapper.class);

            User user = new User();
            user.setName(initUserName);
            user.setBalance(123);
            mapper.insertUser(user);

            initUserId = user.getId();
        }
    }

    @Test
    public void testInsertUser(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);

            User user = new User();
            user.setName("username");
            user.setBalance(100);

            mapper.insertUser(user);

            Assertions.assertTrue(user.getId() > 1);
        }
    }

    @Test
    public void testSelectUser(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUser(initUserId);
            Assertions.assertEquals(initUserName, user.getName());
        }
    }

    @Test
    public void testUpdateUser(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);

            String updatedUserName = "username-updated";
            User user = new User();
            user.setId(1);
            user.setName(updatedUserName);
            user.setBalance(5);

            mapper.updateUser(user);

            Assertions.assertEquals(updatedUserName, user.getName());
        }
    }

    @Test
    public void testDeleteUser(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);

            mapper.deleteUser(initUserId);

            User user = mapper.selectUser(initUserId);

            Assertions.assertNull(user);
        }
    }

    @AfterAll
    static void destroy() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.truncate();
        }
    }
}
