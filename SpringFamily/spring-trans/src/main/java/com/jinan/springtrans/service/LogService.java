package com.jinan.springtrans.service;

import com.jinan.springtrans.Mapper.LogInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.interceptor.TransactionAttribute;

@Service
public class LogService {
    @Autowired
    private LogInfoMapper logInfoMapper;


    //设置事务传播级别
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertLog(String name,String op) {
        logInfoMapper.insertLog(name,"⽤⼾注册");
        try {
            int a = 10/0;
        }catch (Exception e) {
            //回滚当前事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

    }
}
