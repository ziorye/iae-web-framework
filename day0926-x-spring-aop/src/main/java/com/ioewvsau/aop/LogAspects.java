package com.ioewvsau.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面类
 * 标注 @Aspect 注解，告诉 Spring 当前类是一个切面类
 *
 */
@Aspect
@Component
public class LogAspects {
    /**
     * 抽取公共的切入点表达式
     * <p>
     * 1、本类引用，直接使用 pointCut()
     * 2、其他的切面类引用，使用全名 com.ioewvsau.config.aop.LogAspects.pointCut()
     */
    @Pointcut("execution(public int com.ioewvsau.aop.MathCalculator.*(..))")
    public void pointCut() {
    }

    /**
     * 用 @Before 注解的方法会在目标方法之前切入，切入点表达式（指定要切入到哪个目标方法）
     *
     * @param joinPoint
     */
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("【" + joinPoint.getSignature().getName() + "】方法开始运行...@Before...参数列表={" + Arrays.asList(args) + "}");
    }

    @After("com.ioewvsau.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("【" + joinPoint.getSignature().getName() + "】方法运行结束...@After");
    }

    /**
     * JoinPoint一定要出现在参数表的第一位
     *
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("【" + joinPoint.getSignature().getName() + "】方法正常返回...@AfterReturning...运行结果={" + result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("【" + joinPoint.getSignature().getName() + "】方法出现异常...@AfterThrowing...异常信息={" + exception + "}");
    }

}
