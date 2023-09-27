package com.ioewvsau.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource({"classpath:db.properties"})
@Import({DataSourceConfig.class, MyBatisConfig.class})
@ComponentScan("com.ioewvsau.service")
@EnableTransactionManagement
public class AppConfig {
}
