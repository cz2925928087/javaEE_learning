package com.jinan.springlibarydemo.model;


import com.jinan.springlibarydemo.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class Result<T> {
    private int code;  //-1 未登录   -2 参数错误   200 成功  -100 程序异常
    private String errMsg;
    private T data;

    public static <T> Result<T> unlogin(){
        Result<T> result= new Result<T>();
        result.setCode(ResultCodeEnum.UNLOGIN.getCode());
        result.setErrMsg(ResultCodeEnum.UNLOGIN.getMessage());
        return result;
    }

    public static <T> Result<T> paramError(){
        Result<T> result= new Result<T>();
        result.setCode(ResultCodeEnum.PARAM_ERROR.getCode());
        result.setErrMsg(ResultCodeEnum.PARAM_ERROR.getMessage());
        return result;
    }

    public static <T> Result<T> paramError(String errMsg){
        Result<T> result= new Result<T>();
        result.setCode(ResultCodeEnum.PARAM_ERROR.getCode());
        result.setErrMsg(errMsg);
        return result;
    }

    public static <T> Result<T> success(T data){
        Result<T> result= new Result<T>();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setErrMsg("");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(String errMsg) {
        Result<T> result = new Result<T>();
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setErrMsg(errMsg);
        return result;
    }
}
