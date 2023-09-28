package com.ioewvsau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestMappingController {
    @RequestMapping(method = RequestMethod.GET, path = "/request-mapping-method-get")
    @ResponseBody
    String requestMappingMethodGet() {
        return "@RequestMapping(method = RequestMethod.GET, path = \"/request-mapping-method-get\")";
    }

    @GetMapping("/get-mapping")
    @ResponseBody
    String getMapping() {
        return "@GetMapping(\"/get-mapping\")";
    }
}
