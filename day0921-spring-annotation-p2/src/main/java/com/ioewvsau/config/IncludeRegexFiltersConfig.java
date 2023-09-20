package com.ioewvsau.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.ioewvsau",
        includeFilters = {
            // 1. FilterType.ANNOTATION : An annotation to be present or meta-present at the type level in target components.
            //@Filter(type = FilterType.ANNOTATION, classes = {SomeAnnotation.class}),
            // 2. FilterType.ASSIGNABLE_TYPE : A class (or interface) that the target components are assignable to (extend or implement).
            //@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {SomeClass.class}),
            // 3. FilterType.ASPECTJ : An AspectJ type expression to be matched by the target components.
            //@Filter(type = FilterType.ASPECTJ, pattern = "org.example..*Service+"),
            // 4. FilterType.REGEX : A regex expression to be matched by the target components' class names.
            @Filter(type = FilterType.REGEX, pattern = ".*Controller.*"),
        },
        useDefaultFilters = false
)
public class IncludeRegexFiltersConfig {
}
