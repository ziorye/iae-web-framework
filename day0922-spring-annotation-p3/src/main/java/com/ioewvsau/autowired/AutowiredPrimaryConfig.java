package com.ioewvsau.autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.ioewvsau.autowired")
public class AutowiredPrimaryConfig {
    /**
     * 此时容器中有两个相同类型的 PrimaryBean
     *     - 一个是在这里通过 @Bean 注入的
     *     - 另一个是在 PrimaryBean 中使用 @Component 注解标注的
     *
     * 而在 PrimaryController 中通过 @Autowired 注解注入了一个 PrimaryBean
     * 默认是按类型查找，如果同类型有多个组件，则默认从容器中获取 ID 为属性名的组件
     *
     * 可以通过 @Primary 注解改变这一个默认规则，@Primary 标注的组件即为 @Autowired 注入的组件
     */
    @Bean
    @Primary
    public PrimaryBean primaryBean2() {
        return new PrimaryBean("other");
    }
}
