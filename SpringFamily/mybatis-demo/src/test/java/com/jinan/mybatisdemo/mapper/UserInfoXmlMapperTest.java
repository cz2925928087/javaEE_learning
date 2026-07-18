package com.jinan.mybatisdemo.mapper;

import com.jinan.mybatisdemo.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserInfoXmlMapperTest {
    @Autowired
    private UserInfoXmlMapper userInfoXmlMapper;

    @Test
    void selectAll() {
        List<UserInfo> userInfos = userInfoXmlMapper.selectAll();
        userInfos.forEach(System.out::println);
    }

    @Test
    void selectById() {
        UserInfo userInfos = userInfoXmlMapper.selectById(1);
        System.out.println(userInfos);
    }

    @Test
    void selectByAgeAndGender() {
        List<UserInfo> userInfos = userInfoXmlMapper.selectByAgeAndGender(22,1);
        userInfos.forEach(System.out::println);
    }

    @Test
    void insertUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("李四");
        userInfo.setPassword("lisi");
        userInfo.setAge(18);
        userInfo.setGender(1);
        Integer result = userInfoXmlMapper.insertUser(userInfo);
        log.info("影响行数: "+result);
    }

    @Test
    void deleteUser() {
        Integer result = userInfoXmlMapper.deleteUser(5);
        log.info("影响行数: "+result);
    }

    @Test
    void updateUser() {
        userInfoXmlMapper.updateUser("张三",9);
    }
}