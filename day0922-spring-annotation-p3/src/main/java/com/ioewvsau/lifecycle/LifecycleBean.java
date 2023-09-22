package com.ioewvsau.lifecycle;

public class LifecycleBean {
    public LifecycleBean() {
        System.out.println("...constructor...");
    }

    public void init() {
        System.out.println("...initMethod...");
    }

    public void destroy() {
        System.out.println("...destroyMethod...");
    }
}
