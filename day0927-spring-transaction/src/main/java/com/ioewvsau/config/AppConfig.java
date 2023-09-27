package com.ioewvsau.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:db.properties"})
@Import({DataSourceConfig.class, MyBatisConfig.class})
public class AppConfig {
}
