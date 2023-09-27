package com.ioewvsau.controller;

import com.ioewvsau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/user/register")
    @ResponseBody
    String register() {
        userService.save();
        return "UserController@register";
    }
}
