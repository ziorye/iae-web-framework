package service;

import dao.impl.NopeUserDao;
import dao.impl.SimpleUserDao;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.UserServiceImpl;

class SpringIoCTest {
    public static AbstractApplicationContext ac;

    @BeforeAll
    static void initApplicationContext() {
        ac = new ClassPathXmlApplicationContext("beans.xml");
    }

    @Test
    void ioc() {
        Assertions.assertTrue(ac.containsBean("userService"));
        Assertions.assertTrue(ac.containsBean("userDao"));

        Assertions.assertFalse(ac.containsBean("otherName"));
    }

    @Test
    void setterBasedDependencyInjection() {
        UserServiceImpl userService = (UserServiceImpl) ac.getBean("userService");

        Assertions.assertInstanceOf(SimpleUserDao.class, userService.getUserDao());
    }

    @Test
    void constructorBasedDependencyInjection() {
        UserServiceImpl userService = ac.getBean("userService2", UserServiceImpl.class);

        Assertions.assertInstanceOf(NopeUserDao.class, userService.getUserDao2());
    }

    @Test
    void initAndDestroyMethod() {
        //ac.close();
        //ac.registerShutdownHook();
        //已由 @AfterAll 标注的方法统一处理
    }

    @Test
    void initializingBeanDemo() {
        Assertions.assertNotNull("控制台能看到 InitializingBeanDemo.afterPropertiesSet");
    }

    @Test
    void disposableBeanDemo() {
        Assertions.assertNotNull("控制台能看到 DisposableBeanDemo.destroy");
    }

    @Test
    void beanLifecycleDemo() {
        Assertions.assertNotNull("控制台能看到 " +
                "BeanLifecycleDemo.BeanLifecycleDemo\n" +
                "BeanLifecycleDemo.afterPropertiesSet\n" +
                "BeanLifecycleDemo.destroy"
        );
    }

    @AfterAll
    static void registerShutdownHook() {
        ac.registerShutdownHook();
    }
}