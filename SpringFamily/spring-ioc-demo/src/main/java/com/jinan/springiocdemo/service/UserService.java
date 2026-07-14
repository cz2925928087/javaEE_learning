package com.jinan.springiocdemo.service;



import com.jinan.springiocdemo.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
//    @Qualifier("u3")
//    @Resource(name = "u2")
    private UserInfo userInfo;

    public void doService(){
        System.out.println(userInfo);
        System.out.println("do service...");
    }
}

