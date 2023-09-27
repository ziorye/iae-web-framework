package com.ioewvsau.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAdvice {
    @Pointcut("execution(void com.ioewvsau.dao.impl.UserDaoImpl.retrieve())")
    private void pt(){}

    @Pointcut("execution(void com.ioewvsau.dao.impl.UserDaoImpl.update())")
    private void pt2(){}

    @Before("pt()")
    public void startTimeUsingAtBefore() {
        long startTime = System.currentTimeMillis();
        System.out.println("startTime = " + startTime);
    }

    @After("pt2()")
    public void endTimeUsingAtAfter() {
        long endTime = System.currentTimeMillis();
        System.out.println("endTime = " + endTime);
    }
}
