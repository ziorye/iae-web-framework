package com.ioewvsau.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

public class AwareBean implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    public ApplicationContext applicationContext;
    public String beanName;
    public String osName;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.osName = resolver.resolveStringValue("${os.name}");
    }
}
