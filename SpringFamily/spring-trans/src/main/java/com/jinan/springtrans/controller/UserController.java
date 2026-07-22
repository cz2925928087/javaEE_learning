package com.jinan.springtrans.controller;

import com.jinan.springtrans.service.UserService;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //JDBC事务管理器
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    //定义事务属性
    @Autowired
    private TransactionDefinition transactionDefinition;

    @RequestMapping("/registry")
    public String registry (String name,String password) {
        //开启事务
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(transactionDefinition);
        //用户注册
        Integer result = userService.registryUser(name, password);
        System.out.println( "用户注册成功,影响行数"+result);
        //提交事务
        dataSourceTransactionManager.commit(transaction);
        //事务回滚
        //dataSourceTransactionManager.rollback(transaction);
        return "注册成功";
    }
}
