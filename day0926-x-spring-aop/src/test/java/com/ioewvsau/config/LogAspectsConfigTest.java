package com.ioewvsau.config;

import com.ioewvsau.config.LogAspectsConfig;
import com.ioewvsau.aop.MathCalculator;
import org.aspectj.lang.annotation.AfterThrowing;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(LogAspectsConfig.class)
class LogAspectsConfigTest {
    private static final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @BeforeAll
    public static void setOutputStream() {
        System.setOut(new PrintStream(out));
    }

    @BeforeEach
    public void resetOut() {
        out.reset();
    }

    @Autowired
    ApplicationContext applicationContext;

    @Test
    @DisplayName("测试 AOP 方法运行正常的情况")
    public void testAfterReturning() {
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1, 1);
        /*
         * 【div】方法开始运行...@Before...参数列表={[1, 1]}
         * MathCalculator@div...
         * 【div】方法正常返回...@AfterReturning...运行结果={1}
         * 【div】方法运行结束...@After
         */
        String expected = "【.*】方法开始运行...@Before...参数列表=\\{.*}" + System.lineSeparator() +
                ".*@.*" + System.lineSeparator() + // 目标方法
                "【.*】方法正常返回...@AfterReturning...运行结果=\\{.*}" + System.lineSeparator() +
                "【.*】方法运行结束...@After" + System.lineSeparator();

        assertTrue(out.toString().matches(expected));
    }

    @Test
    @DisplayName("测试 AOP 方法执行异常的情况")
    public void testAfterThrowing() {
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);

        Exception exception = assertThrows(ArithmeticException.class, () -> mathCalculator.div(1, 0));
        assertEquals("/ by zero", exception.getMessage());

        /*
         * 【div】方法开始运行...@Before...参数列表={[1, 0]}
         * MathCalculator@div...
         * 【div】方法出现异常...异常信息={java.lang.ArithmeticException: / by zero}
         * 【div】方法运行结束...@After
         *
         * java.lang.ArithmeticException: / by zero
         *
         * ...
         */
        String expected = "【.*】方法开始运行...@Before...参数列表=\\{.*}" + System.lineSeparator() +
                ".*@.*" + System.lineSeparator() + // 目标方法
                "【.*】方法出现异常...@AfterThrowing...异常信息=\\{.*}" + System.lineSeparator() +
                "【.*】方法运行结束...@After" + System.lineSeparator();

        assertTrue(out.toString().matches(expected));
    }
}