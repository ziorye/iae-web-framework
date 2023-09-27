package com.ioewvsau.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAdvice {
    @Pointcut("execution(void com.ioewvsau.dao.impl.UserDaoImpl.retrieve())")
    private void pt(){}

    @Pointcut("execution(void com.ioewvsau.dao.impl.UserDaoImpl.update())")
    private void pt2(){}

    @Pointcut("execution(void com.ioewvsau.dao.impl.UserDaoImpl.delete())")
    private void pt3(){}

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

    @Around("pt3()")
    public void elapsedTimeUsingAtAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("startTime = " + startTime);

        pjp.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println("endTime = " + endTime);
        System.out.println("elapsedTime = " + (endTime - startTime));
    }
}
