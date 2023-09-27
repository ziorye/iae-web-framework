package com.ioewvsau.controller;

import com.ioewvsau.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/jsonList")
    @ResponseBody
    public List<User> responseJsonList() {
        ArrayList<User> users = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            User user = new User();
            user.setName("Alice" + i);
            user.setEmail("alice"+i+"@example.com");

            users.add(user);
        }

        return users;
    }
}
