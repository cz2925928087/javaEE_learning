package com.jinan.springtrans.controller;

import com.jinan.springtrans.service.LogService;
import com.jinan.springtrans.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pro")
public class PropagationController {
    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;

    @Transactional
    @RequestMapping("/registry")
    public String registry(String name,String password){
        //用户注册
        userService.registryUser(name,password);
        logService.insertLog(name, "用户注册");
        return "注册成功";
    }
}
