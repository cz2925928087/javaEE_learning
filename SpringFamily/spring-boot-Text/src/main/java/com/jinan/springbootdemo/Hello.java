package com.jinan.springbootdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @RequestMapping("/hello")
    public Integer Spring() {
        int n = 10 / 2;
        return 100;
    }
}
