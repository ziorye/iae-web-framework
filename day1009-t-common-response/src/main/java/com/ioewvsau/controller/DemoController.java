package com.ioewvsau.controller;

import com.ioewvsau.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("/e")
    R e() {
        int i = 1 / 0;
        return R.ok();
    }
}
