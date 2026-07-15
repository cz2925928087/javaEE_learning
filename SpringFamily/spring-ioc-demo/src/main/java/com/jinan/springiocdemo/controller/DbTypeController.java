package com.jinan.springiocdemo.controller;

import com.jinan.springiocdemo.entity.DbType;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbTypeController {
    @Autowired
    private DbType dbType;


    @PostConstruct
    public void read() {
        System.out.println("=========");
        System.out.println(dbType);
    }
}
