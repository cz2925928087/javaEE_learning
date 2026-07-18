package com.jinan.mybatisdemo.mapper;

import com.jinan.mybatisdemo.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UpdatesUserInfoXmlMapperTest {

    @Autowired
    UpdatesUserInfoXmlMapper updatesUserInfoXmlMapper;

    @Test
    void insertUserByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("张三");
        userInfo.setPassword("zhangsan");
        userInfo.setAge(19);
        userInfo.setGender(1);
        Integer results = updatesUserInfoXmlMapper.insertUserByCondition(userInfo);
        System.out.println(results);
    }


    @Test
    void queryByCondition() {
        List<UserInfo> userInfos = updatesUserInfoXmlMapper.queryByCondition();
        userInfos.forEach(System.out::println);

    }
}