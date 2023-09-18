package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class SpringIoCTest {

    @Test
    void ioc() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        Assertions.assertTrue(ac.containsBean("userService"));
        Assertions.assertTrue(ac.containsBean("userDao"));

        Assertions.assertFalse(ac.containsBean("otherName"));
    }
}