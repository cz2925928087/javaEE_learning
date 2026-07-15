package com.jinan.log.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/log")
public class LoggerController {
    private static  Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @RequestMapping("/print")
    public String  print() {
        System.out.println("打印日志");
        logger.info("打印日志");
        return "日志打印成功";
    }
}
