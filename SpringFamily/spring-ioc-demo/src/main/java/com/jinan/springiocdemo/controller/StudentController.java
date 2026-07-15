package com.jinan.springiocdemo.controller;

import com.jinan.springiocdemo.entity.StudentInfo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentInfo student;

    @PostConstruct
    public void readStudent() {
        System.out.println("=============");
        System.out.println(student);
    }
}
