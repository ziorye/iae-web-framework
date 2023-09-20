package com.ioewvsau.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(basePackages = "com.ioewvsau",
        includeFilters = {@Filter(Service.class), @Filter(Repository.class), @Filter(Controller.class)},
        useDefaultFilters = false
)
public class IncludeAndExcludeFiltersConfig {
}
