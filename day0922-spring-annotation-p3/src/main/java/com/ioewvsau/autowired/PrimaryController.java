package com.ioewvsau.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PrimaryController {
    @Autowired
    PrimaryBean primaryBean;

    public PrimaryBean getPrimaryBean() {
        return primaryBean;
    }
}
