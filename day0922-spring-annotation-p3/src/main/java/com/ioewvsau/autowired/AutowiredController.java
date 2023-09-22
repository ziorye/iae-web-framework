package com.ioewvsau.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AutowiredController {
    @Autowired
    private AutowiredService autowiredService;

    public AutowiredService getAutowiredService() {
        return autowiredService;
    }
}
