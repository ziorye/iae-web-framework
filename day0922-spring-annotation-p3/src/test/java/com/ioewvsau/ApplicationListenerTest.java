package com.ioewvsau;

import com.ioewvsau.listener.ApplicationListenerConfig;
import com.ioewvsau.listener.MyEvent;
import com.ioewvsau.listener.MyEventSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationListenerTest {
    private static final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @BeforeAll
    public static void setOutputStream() {
        System.setOut(new PrintStream(out));
    }

    @BeforeEach
    public void resetOut() {
        out.reset();
    }

    @Test
    @DisplayName("测试 Event 和 Listener")
    public void testApplicationListener() {
        AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationListenerConfig.class);
        assertTrue(out.toString().contains("org.springframework.context.event.ContextRefreshedEvent"));

        MyEventSource myEventSource = new MyEventSource("myEventSource", 88);
        MyEvent myEvent = new MyEvent(myEventSource);
        applicationContext.publishEvent(myEvent);
        assertTrue(out.toString().contains("MyEvent"));

        applicationContext.close();
        assertTrue(out.toString().contains("org.springframework.context.event.ContextClosedEvent"));
    }
}
