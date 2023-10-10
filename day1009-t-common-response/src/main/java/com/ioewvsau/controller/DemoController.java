package com.ioewvsau.controller;

import com.ioewvsau.exception.BusinessException;
import com.ioewvsau.exception.SystemException;
import com.ioewvsau.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/e/{id}")
    R se(@PathVariable int id) {
        switch (id) {
            case 0 -> throw new BusinessException("BusinessException - 数据不符合规范", 500000);
            case 99 -> throw new SystemException("SystemException - 这个问题比较严重，需要记录日志并发邮件给技术支持团队", 500099);
        }
        return R.ok();
    }

    @GetMapping("/i")
    R i() {
        System.out.println("DemoController.i");
        return R.ok();
    }
}
