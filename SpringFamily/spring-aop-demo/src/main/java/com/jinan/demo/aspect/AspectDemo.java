package com.jinan.demo.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
@Aspect
public class AspectDemo {

    //定义切点
    @Pointcut("execution(* com.jinan.demo.controller.*.*(..))")
    public void pt(){}

    @Around("pt()")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //记录方法开始执行的时间
        //long start = System.currentTimeMillis();
        log.info("Around方法开始执行");
        //执行目标方法
        Object result = joinPoint.proceed();
        //记录方法结束的时间
        //long end = System.currentTimeMillis();
        log.info("Around结束执行");
        //记录耗时
        //log.info(joinPoint.getSignature() + "耗时:{}ms", end - start);
        return result;
    }

    @Before("pt()")
    public void doBefore() {
        log.info("执行Before方法");
    }

    @After("pt()")
    public void doAfter() {
        log.info("执行After方法");
    }

    @AfterReturning("pt()")
    public void doAfterReturning() {
        log.info("执行AfterReturn方法");
    }

    @AfterThrowing("pt()")
    public void doAfterThrowing() {
        log.info("执行AfterReturn方法");
    }
}
