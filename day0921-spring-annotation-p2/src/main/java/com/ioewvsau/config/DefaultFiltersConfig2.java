package com.ioewvsau.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ioewvsau.controller", "com.ioewvsau.service"}, useDefaultFilters = true)
public class DefaultFiltersConfig2 {
}
