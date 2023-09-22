package com.ioewvsau.atImport;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class CustomImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        if (registry.containsBeanDefinition("com.ioewvsau.atImport.Apple") && registry.containsBeanDefinition("com.ioewvsau.atImport.Cat")) {
            registry.registerBeanDefinition("dog", new RootBeanDefinition(Dog.class));
        }
    }
}
