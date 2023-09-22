package com.ioewvsau.atImport;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Apple.class, Cat.class, CustomImportSelector.class, CustomImportBeanDefinitionRegistrar.class})
public class ImportConfig {
}
