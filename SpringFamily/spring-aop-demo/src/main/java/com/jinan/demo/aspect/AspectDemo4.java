package com.jinan.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@Order(3)
public class AspectDemo4 {
    //定义切点
    @Pointcut("execution(* com.jinan.demo.controller.*.*(..))")
    public void pt(){}

    @Before("pt()")
    public void doBefore() {
        log.info("执⾏ AspectDemo4 -> Before ⽅法");
    }

    @After("pt()")
    public void doAfter() {
        log.info("执⾏ AspectDemo4 -> After ⽅法");
    }
}
