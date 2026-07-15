package com.jinan.springiocdemo.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prop")
public class ReadPropertiesController {
    @Value("${my.key}")
    private String myKey;

    @Value("${server.port}")
    private Integer serverPort;

    @RequestMapping("/read")
    public String read() {
        return "myKey " + myKey;
    }

    @PostConstruct
    public void read2() {
        System.out.println("serverPort:"+serverPort);
    }
}
