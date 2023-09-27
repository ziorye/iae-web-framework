package com.ioewvsau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response")
public class ResponseController {
    @RequestMapping("/page")
    public String responsePage() {
        return "/page.jsp";
    }

    @RequestMapping("/text")
    @ResponseBody
    public String responseText() {
        return "responseText";
    }
}
