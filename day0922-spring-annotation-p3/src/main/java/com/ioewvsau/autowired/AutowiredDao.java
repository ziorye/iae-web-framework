package com.ioewvsau.autowired;

import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class AutowiredDao {
    /**
     * Inject 是 JSR-330 规范引入的注解
     * 需要额外导入 javax.inject 依赖
     */
    @Inject
    private AutowiredUtil autowiredUtil;

    public AutowiredUtil getAutowiredUtil() {
        return autowiredUtil;
    }
}
