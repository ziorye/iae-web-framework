package com.ioewvsau.controller;

import com.ioewvsau.pojo.User;
import com.ioewvsau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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

    @RequestMapping("/user/param-pojo")
    @ResponseBody
    String paramPojo(User user) {
        return "UserController@paramPojo---" + user;
    }

    @RequestMapping("/user/body-pojo")
    @ResponseBody
    String bodyPojo(@RequestBody User user) {
        return "UserController@bodyPojo---" + user;
    }

    @RequestMapping("/user/date-time-format")
    @ResponseBody
    String dateTimeFormat(Date date,
                          @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateYmd,
                          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date dateYmdHms
    ) {
        return "UserController@dateTimeFormat---" + date + "," + dateYmd+ "," + dateYmdHms;
    }
}
