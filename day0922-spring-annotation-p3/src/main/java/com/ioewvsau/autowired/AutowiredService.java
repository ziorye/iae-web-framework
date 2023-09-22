package com.ioewvsau.autowired;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AutowiredService {
    /**
     * Resource 是 JSR-250 规范引入的注解
     * 需要引入 javax.annotation-api 依赖
     */
    @Resource
    private AutowiredDao autowiredDao;

    public AutowiredDao getAutowiredDao() {
        return autowiredDao;
    }
}
