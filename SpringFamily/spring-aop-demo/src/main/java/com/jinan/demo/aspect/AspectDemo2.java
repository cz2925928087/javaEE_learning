package com.jinan.demo.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
@Order(2)
public class AspectDemo2 {
    //定义切点
    @Pointcut("execution(* com.jinan.demo.controller.*.*(..))")
    public void pt(){}

    @Before("pt()")
    public void doBefore() {
        log.info("执⾏ AspectDemo2 -> Before ⽅法");
    }

    @After("pt()")
    public void doAfter() {
        log.info("执⾏ AspectDemo2 -> After ⽅法");
    }

}
