package com.jinan.springmvcdemo;

import lombok.Data;

//@Data注解需要引入lombok依赖
@Data
public class MessageInfo {
    private String from;
    private String to;
    private String message;

}
