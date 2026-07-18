package com.jinan.springmvcdemo.controller;
//留言板接口实现

import com.jinan.springmvcdemo.entity.MessageInfo;
import com.jinan.springmvcdemo.service.MessageInfoService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
     private MessageInfoService messageInfoService;

    public MessageController(MessageInfoService messageInfoService) {
        this.messageInfoService = messageInfoService;
    }

    //private List<MessageInfo> messageInfoList = new ArrayList<>();
    @RequestMapping("/publish")
    public Boolean publish(@RequestBody MessageInfo messageInfo) {
        if(!StringUtils.hasLength(messageInfo.getFrom())
           || !StringUtils.hasLength(messageInfo.getTo())
           ||!StringUtils.hasLength(messageInfo.getMessage())){
            return false;
        }
        messageInfoService.add(messageInfo);
        return true;
    }

    @RequestMapping("/getList")
    public List<MessageInfo> getList() {
        return messageInfoService.queryAllMessage();
    }
}
