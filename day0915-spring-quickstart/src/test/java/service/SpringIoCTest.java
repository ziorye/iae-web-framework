package service;

import dao.impl.NopeUserDao;
import dao.impl.SimpleUserDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.UserServiceImpl;

class SpringIoCTest {

    @Test
    void ioc() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        Assertions.assertTrue(ac.containsBean("userService"));
        Assertions.assertTrue(ac.containsBean("userDao"));

        Assertions.assertFalse(ac.containsBean("otherName"));
    }

    @Test
    void setterBasedDependencyInjection() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        UserServiceImpl userService = (UserServiceImpl) ac.getBean("userService");

        Assertions.assertInstanceOf(SimpleUserDao.class, userService.getUserDao());
    }

    @Test
    void constructorBasedDependencyInjection() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        UserServiceImpl userService = ac.getBean("userService2", UserServiceImpl.class);

        Assertions.assertInstanceOf(NopeUserDao.class, userService.getUserDao2());
    }

    @Test
    void initAndDestroyMethod() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        //ac.close();
        ac.registerShutdownHook();
    }
}