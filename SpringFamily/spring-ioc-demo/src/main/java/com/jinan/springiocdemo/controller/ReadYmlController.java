package com.jinan.springiocdemo.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.support.RouterFunctionMapping;

@RestController
@RequestMapping("/yml")
public class ReadYmlController {

    @Value("${server.netty.validate-headers}")
    private Boolean validateHeaders;

    @Value("${string.value}")
    private String str1;
    @Value("${string.value2}")
    private String str2;
    @Value("${string.value3}")
    private String str3;



    @PostConstruct
    public void read() {
        System.out.println("===========");
        System.out.println(validateHeaders);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}
