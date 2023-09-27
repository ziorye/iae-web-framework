package com.ioewvsau.controller;

import com.ioewvsau.pojo.User;
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

    @RequestMapping("/json")
    @ResponseBody
    public User responseJson() {
        User user = new User();
        user.setName("Alice");
        user.setEmail("alice@example.com");
        return user;
    }
}
