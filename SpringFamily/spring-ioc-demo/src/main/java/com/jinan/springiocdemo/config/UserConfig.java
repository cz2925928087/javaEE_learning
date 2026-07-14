package com.jinan.springiocdemo.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    public String doConfiguration(){
        System.out.println("do configuration...");
        return "do configuration...";
    }
}
