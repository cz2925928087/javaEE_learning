package com.jinan.springlibarydemo.advice;


import com.jinan.springlibarydemo.model.Result;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@ControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler
    public Object handler(Exception e) {
        return Result.fail("内部错误请联系管理员");
    }

    @ExceptionHandler
    public Object handler(ArithmeticException e) {
        return Result.fail("发生算术异常");
    }

    @ExceptionHandler
    public Object handle(NullPointerException e) {
        return Result.fail("发生空指针异常");
    }
}
