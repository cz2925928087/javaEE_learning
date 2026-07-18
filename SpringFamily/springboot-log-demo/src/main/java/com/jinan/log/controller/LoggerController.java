package com.jinan.log.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/logger")
public class LoggerController {
    private static  Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @RequestMapping("/print")
    public String  print() {
        System.out.println("打印日志");
        //logger.info("打印日志");
        logger.error("打印error日志");
        logger.warn("打印warn日志");
        logger.info("打印info日志");
        logger.debug("打印debug日志");
        logger.trace("打印trace日志");
        return "日志打印成功";
    }
}
