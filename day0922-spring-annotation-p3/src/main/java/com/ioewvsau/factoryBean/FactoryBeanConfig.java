package com.ioewvsau.factoryBean;

import com.ioewvsau.factoryBean.CustomFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBeanConfig {

    @Bean
    /*
     * 虽然这里返回的是 CustomFactoryBean，但是，默认通过 getBean("...") 获取到的是 getObject() 方法返回的 CustomBean
     * 如果要获取 CustomFactoryBean 本身，可以在 getBean("&...") 的 bean ID 增加 & 前缀
     */
    public CustomFactoryBean customFactoryBean() {
        return new CustomFactoryBean();
    }
}
