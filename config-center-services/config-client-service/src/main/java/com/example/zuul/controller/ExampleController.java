package com.example.zuul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
@RefreshScope
public class ExampleController {

    @Value("${config.center.test}")
    private String test;

    @GetMapping("/test")
    public String test(){
        return "config center server test:  " + test;
    }
}
