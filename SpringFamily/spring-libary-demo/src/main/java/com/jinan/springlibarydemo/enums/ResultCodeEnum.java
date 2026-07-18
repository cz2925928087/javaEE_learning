package com.jinan.springlibarydemo.enums;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    UNLOGIN(-1, "用户未登录"),
    PARAM_ERROR(-2, "参数异常"),
    FAIL(-100, "内部错误"),
    SUCCESS(200, "成功")
    ;
    private int code;
    private String message;

    ResultCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
