package com.jinan.springmvcdemo.service;

import com.jinan.springmvcdemo.entity.MessageInfo;
import com.jinan.springmvcdemo.mapper.MessageInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageInfoService {

    @Autowired
    MessageInfoMapper messageInfoMapper;

    public void add(MessageInfo messageInfo) {
        messageInfoMapper.insertMessage(messageInfo);
    }

    public List<MessageInfo> queryAllMessage() {
        List<MessageInfo> messageInfos = messageInfoMapper.queryAll();
        return messageInfos;
    }
}
