package com.jinan.springiocdemo.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class UserComponent {

    public String doComponent(){
        System.out.println("do component...");
        return "do component...";
    }
}