package com.jinan.springmvcdemo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Hangdian")
public class Hello_HangDian {
    //@RequestMapping(value = "/hello",method = RequestMethod.GET)
    @GetMapping("/hello")
    //GetMapping仅支持get请求,效果等于上面
    public String hello() {
        return "我要考杭州电子科技大学";
    }

    @PostMapping("/Score")
    //同理PostMapping仅支持post请求,其他注解PutMapping,DeleteMapping等也是一样
    public Integer Score() {
        return 320;
    }

    //指定支持多个请求
    @RequestMapping(value = "/spring",method = {RequestMethod.GET,RequestMethod.POST})
    public String spring() {
        return "hello";
    }


}
