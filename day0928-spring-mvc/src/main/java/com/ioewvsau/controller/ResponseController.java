package com.ioewvsau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/response")
public class ResponseController {
    @RequestMapping("/page")
    public String responsePage() {
        return "/page.jsp";
    }
}
