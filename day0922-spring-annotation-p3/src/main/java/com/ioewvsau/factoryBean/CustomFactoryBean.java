package com.ioewvsau.factoryBean;

import org.springframework.beans.factory.FactoryBean;

public class CustomFactoryBean implements FactoryBean<CustomBean> {
    @Override
    public CustomBean getObject() throws Exception {
        return new CustomBean();
    }

    @Override
    public Class<?> getObjectType() {
        return CustomBean.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
