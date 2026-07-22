package com.jinan.springtrans.controller;

import com.jinan.springtrans.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/trans")
public class TransController {
    @Autowired
    private UserService userService;

    /*
    * 代码正常执行,事务提交
    * */
    @Transactional
    @RequestMapping("/r1")
    public String r1 (String name,String password) {
        //用户注册
        Integer result = userService.registryUser(name, password);
        System.out.println( "用户注册成功,影响行数"+result);
        return "注册成功";
    }


    /*
    * 代码执行异常,事务回滚
    * */
    @Transactional
    @RequestMapping("/r2")
    public String r2 (String name,String password) {
        //用户注册
        Integer result = userService.registryUser(name, password);
        System.out.println( "用户注册成功,影响行数"+result);
        int a = 10/0;
        return "注册成功";
    }


    /*
     * 代码捕获异常,事务提交
     * */
    @Transactional
    @RequestMapping("/r3")
    public String r3 (String name,String password) {
        //用户注册
        Integer result = userService.registryUser(name, password);
        System.out.println( "用户注册成功,影响行数"+result);
        try {
            int a = 10/0;
        }catch (Exception e) {
            System.out.println("程序发生异常");
        }
        return "注册成功";
    }

    /*
     * 代码捕获异常,然后重新抛出,事务回滚
     * */
    @Transactional
    @RequestMapping("/r4")
    public String r4 (String name,String password) {
        //用户注册
        Integer result = userService.registryUser(name, password);
        System.out.println( "用户注册成功,影响行数"+result);
        try {
            int a = 10/0;
        }catch (Exception e) {
            throw e;
        }
        return "注册成功";
    }


    /*
     * 代码执行异常,手动回滚
     * */
    @Transactional
    @RequestMapping("/r5")
    public String r5 (String name,String password) {
        //用户注册
        Integer result = userService.registryUser(name, password);
        System.out.println( "用户注册成功,影响行数"+result);
        try {
            int a = 10/0;
        }catch (Exception e) {
            System.out.println("程序异常");
            //手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "注册失败";
        }
        return "注册成功";
    }

    /*
    * 程序抛出异常:RuntimeException:事务回滚
    * */
    @Transactional
    @RequestMapping("/r6")
    public String r6 (String name,String password) {
        //用户注册
        Integer result = userService.registryUser(name, password);
        System.out.println( "用户注册成功,影响行数"+result);
        if (true) {
            throw new RuntimeException();
        }
        return "注册成功";
    }

    /*
    * 程序抛出非运行异常 ,提交事务
    * */
    @Transactional
    @RequestMapping("/r7")
    public String r7 (String name,String password) throws IOException{
        //用户注册
        Integer result = userService.registryUser(name, password);
        System.out.println( "用户注册成功,影响行数"+result);
        if(true) {
            throw new IOException();
        }
        return "注册成功";
    }

    /*
    *程序只要抛出异常,事务回滚
    * */
    @Transactional(rollbackFor = {Exception.class, Error.class})
    @RequestMapping("/r8")
    public String r8 (String name,String password) throws IOException{
        //用户注册
        Integer result = userService.registryUser(name, password);
        System.out.println( "用户注册成功,影响行数"+result);
        if(true) {
            throw new IOException();
        }
        return "注册成功";
    }

    /*
    *  设置事务的隔离级别
    *    Isolation.DEFAULT:默认的,已连接数据库的隔离级别为主
    *   Isolation.READ_UNCOMMITTED：将隔离级别设置为读未提交
    *   Isolation.READ_COMMITTED：设置为读已提交
    *   Isolation.REPEATABLE_READ：设置为可重复读
    *   Isolation.SERIALIZABLE：设置为串行化
    * */
    @Transactional(rollbackFor = {Exception.class, Error.class}, isolation = Isolation.SERIALIZABLE)
    @RequestMapping("/r9")
    public String r9 (String name,String password) throws IOException{
        //用户注册
        Integer result = userService.registryUser(name, password);
        System.out.println( "用户注册成功,影响行数"+result);
        if(true) {
            throw new IOException();
        }
        return "注册成功";
    }

}
