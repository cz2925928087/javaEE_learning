package com.jinan.springmvcdemo.mapper;

import com.jinan.springmvcdemo.entity.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MessageInfoMapperTest {

    @Autowired
    MessageInfoMapper messageInfoMapper;

    @Test
    void insertMessage() {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setFrom("aaa");
        messageInfo.setTo("bbb");
        messageInfo.setMessage("ccc");
        Integer i = messageInfoMapper.insertMessage(messageInfo);
        log.info("影响行数 "+i);
    }

    @Test
    void queryAll() {
        List<MessageInfo> messageInfos = messageInfoMapper.queryAll();
        System.out.println(messageInfos);
    }
}