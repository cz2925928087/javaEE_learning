package com.jinan.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/t1")
     public String t1() {
        log.info("执行t1");
        return "t1";
    }

    @RequestMapping("t2")
    public boolean t2() {
        try {
            int a = 10/0;
        }catch (ArithmeticException e) {
            log.error("发生错误");
        }

        log.info("执行t2");
        return true;
    }
}
