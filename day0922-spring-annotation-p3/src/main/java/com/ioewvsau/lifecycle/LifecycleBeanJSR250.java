package com.ioewvsau.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifecycleBeanJSR250 {
    public LifecycleBeanJSR250() {
        System.out.println("...constructor...");
    }

    /**
     * PostConstruct 和 PreDestroy 注解是 JSR-250 规范
     * 需要引入 javax.annotation-api 依赖
     */
    @PostConstruct
    public void init() {
        System.out.println("...PostConstruct...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("...PreDestroy...");
    }
}
