package com.jinan.log.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/logger2")
public class LoggerController2 {
    @RequestMapping("/print")
    public String print() {
        System.out.println("打印日志");
        //logger.info("打印日志");
        log.error("打印error日志");
        log.warn("打印warn日志");
        log.info("打印info日志");
        log.debug("打印debug日志");
        log.trace("打印trace日志");
        return "日志打印成功";
    }
}
