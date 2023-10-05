package com.ioewvsau.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.ioewvsau.service", "com.ioewvsau.dao"})
@PropertySource({"classpath:db.properties"})
@Import({DataSourceConfig.class, MyBatisConfig.class})
@EnableTransactionManagement
public class MyRootConfig {
}
