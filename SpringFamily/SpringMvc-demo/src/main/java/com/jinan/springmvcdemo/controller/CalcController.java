package com.jinan.springmvcdemo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//计算器接口实现
@RestController
@RequestMapping("/calc")
public class CalcController {
    @RequestMapping("/sum")
    public String sum(Integer num1,Integer num2) {
        if(num1 == null || num2 == null){
            return "参数不合法";
        }
        Integer sum = num1 + num2;
        return "相加的结果为"+ sum;
    }

    @RequestMapping("/sub")
    public String sub(Integer num1,Integer num2) {
        if(num1 == null || num2 == null) {
            return "参数不合法";
        }
        Integer sub = 0;
        if(num1>num2) {
            sub = num1-num2;
        }else {
            sub = num2-num1;
        }
        return "相减结果为"+sub;
    }

    @RequestMapping("/mul")
    public String mul(Integer num1,Integer num2) {
        if(num1 == null || num2 == null){
            return "参数不合法";
        }
        Integer result = num1 * num2;
        return "相乘的结果为"+ result;
    }

    @RequestMapping("/div")
    public String div(Integer num1,Integer num2) {
        if(num1 == null || num2 == null){
            return "参数不合法";
        }
        if(num2 == 0){
            return "除数不能为0";
        }
        Double result = (double) num1 / num2;
        return "相除的结果为"+ result;
    }
}
