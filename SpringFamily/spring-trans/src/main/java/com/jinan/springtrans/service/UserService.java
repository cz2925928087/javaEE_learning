package com.jinan.springtrans.service;

import com.jinan.springtrans.Mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;


    @Transactional(propagation = Propagation.REQUIRED)
    public Integer registryUser(String name,String password){
        Integer result = userInfoMapper.insert(name, password);
        return result;
    }
}
