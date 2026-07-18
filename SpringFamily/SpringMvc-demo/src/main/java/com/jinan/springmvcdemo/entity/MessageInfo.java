package com.jinan.springmvcdemo.entity;

import lombok.Data;

import java.util.Date;

//@Data注解需要引入lombok依赖
@Data
public class MessageInfo {
    private Integer id;
    private String from;
    private String to;
    private String message;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
