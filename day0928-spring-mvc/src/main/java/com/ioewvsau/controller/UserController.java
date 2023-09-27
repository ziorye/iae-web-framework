package com.ioewvsau.controller;

import com.ioewvsau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/user/param")
    @ResponseBody
    String param(String name, String email) {
        return "UserController@param---" + name + ", " + email;
    }

    @RequestMapping("/user/param-not-match")
    @ResponseBody
    String paramNotMatch(@RequestParam("name") String userName, String email) {
        return "UserController@paramNotMatch---" + userName + ", " + email;
    }
}
