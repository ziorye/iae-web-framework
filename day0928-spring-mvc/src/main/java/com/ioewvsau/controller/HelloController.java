package com.ioewvsau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/helloSpringWebMvc")
    @ResponseBody
    public String helloSpringWebMvc() {
        return "helloSpringWebMvc";
    }
}
