package com.jinan.mybatisdemo.mapper;

import com.jinan.mybatisdemo.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Test
    void selectAll() {
        List<UserInfo> userInfos = userInfoMapper.selectAll();
        userInfos.forEach(System.out::println);
    }

    @Test
    void selectById() {
        UserInfo userInfo = userInfoMapper.selectById(1);
        System.out.println(userInfo);
    }

    @Test
    void selectByAgeAndGender() {
        List<UserInfo> userInfo = userInfoMapper.selectByAgeAndGender(18, 1);
        System.out.println(userInfo);
    }

    @Test
    void insertUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("404");
        userInfo.setPassword("404");
        userInfo.setAge(18);
        userInfo.setGender(0);
        Integer result = userInfoMapper.insertUser(userInfo);
        log.info("影响行数:"+ result);
    }

    @Test
    void insertUser2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("404");
        userInfo.setPassword("404");
        userInfo.setAge(18);
        userInfo.setGender(0);
        Integer result = userInfoMapper.insertUser(userInfo);
        log.info("影响行数:{}, 自增ID:{}", result, userInfo.getId());
    }

    @Test
    void deleteUser() {
        Integer result = userInfoMapper.deleteUser(7);
        log.info("影响行数"+result);
    }

    @Test
    void updateUser() {
        userInfoMapper.updateUser("张三",5);

    }
}