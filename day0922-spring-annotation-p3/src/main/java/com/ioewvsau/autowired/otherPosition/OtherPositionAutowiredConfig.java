package com.ioewvsau.autowired.otherPosition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ioewvsau.autowired.otherPosition")
public class OtherPositionAutowiredConfig {
    /**
     * @Bean 标注的方法参数中的 @Autowired 也可以省略，参数中的值默认就是从容器中获取
     */
    @Bean
    public Plane plane(@Autowired Assistant assistant) {
        Plane plane = new Plane();
        plane.setAssistant(assistant);
        return plane;
    }
}
