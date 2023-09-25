package com.ioewvsau.autowired;

import org.springframework.stereotype.Component;

@Component
public class PrimaryBean {
    private String desc = "default";

    public PrimaryBean() {
    }

    public PrimaryBean(String desc) {
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
