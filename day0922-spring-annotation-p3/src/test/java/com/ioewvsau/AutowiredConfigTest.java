package com.ioewvsau;

import com.ioewvsau.autowired.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertSame;

@SpringJUnitConfig(AutowiredConfig.class)
public class AutowiredConfigTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    @DisplayName("测试通过 @Autowired 注解")
    public void testAutowiredAnnotation() {
        AutowiredController controller = applicationContext.getBean("autowiredController", AutowiredController.class);
        AutowiredService service = applicationContext.getBean("autowiredService", AutowiredService.class);
        assertSame(service, controller.getAutowiredService());
    }

    @Test
    @DisplayName("测试通过 @Resource 注解")
    public void testResourceAnnotation() {
        AutowiredService service = applicationContext.getBean("autowiredService", AutowiredService.class);
        AutowiredDao dao = applicationContext.getBean("autowiredDao", AutowiredDao.class);
        assertSame(dao, service.getAutowiredDao());
    }

    @Test
    @DisplayName("测试通过 @Inject 注解")
    public void testInjectAnnotation() {
        AutowiredDao dao = applicationContext.getBean("autowiredDao", AutowiredDao.class);
        AutowiredUtil util = applicationContext.getBean("autowiredUtil", AutowiredUtil.class);
        assertSame(util, dao.getAutowiredUtil());
    }
}
