package com.jinan.demo.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
//@Order数字越小Before越先执行,数字越大After越先执行
@Order(1)
public class AspectDemo3 {
    //定义切点
    @Pointcut("execution(* com.jinan.demo.controller.*.*(..))")
    public void pt(){}


    @Before("pt()")
    public void doBefore() {
        log.info("执⾏ AspectDemo3 -> Before ⽅法");
    }

    @After("pt()")
    public void doAfter() {
        log.info("执⾏ AspectDemo3 -> After ⽅法");
    }
}
