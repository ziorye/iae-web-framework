package com.ioewvsau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
    @GetMapping("/show")
    String show(Model model) {
        model.addAttribute("msg", "get data form Model");
        return "show";
    }
}
