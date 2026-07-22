package com.jinan.springlibarydemo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/t1")
    public String t1() {
        int[] array = {1,2,3};
        System.out.println(array[3]);
        return "t1";
    }

    @RequestMapping("/t2")
    public Integer t2() {
        int a = 10/0;
        return 10;
    }

    @RequestMapping("/t3")
    public Boolean t3() {
        String a = null;
        System.out.println(a.length());
        return true;
    }
}
