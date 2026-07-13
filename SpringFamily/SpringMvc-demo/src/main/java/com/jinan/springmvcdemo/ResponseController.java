package com.jinan.springmvcdemo;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

//返回的是数据
//@RestController = Controller + ResponseBody
//返回的是视图,返回页面
@Controller
//@ResponseBody
@RequestMapping("/response")
public class ResponseController {
    //在方法上加上ResponseBody返回的是该方法上的数据
    @ResponseBody
    @RequestMapping("/returnHtml")
    public String returnHtml() {
        List<Integer> list = List.of(1,2,3);
        return "/index.html";
    }
    //@ResponseBody
    //返回视图页面
    @RequestMapping("/returnPage")
    public String returnPage() {
        List<Integer> list = List.of(1,2,3);
        return "/index.html";
    }
    @ResponseBody
    @RequestMapping("/returnPage2")
    public String returnPage2() {
        List<Integer> list = List.of(1,2,3);
        return "<h1>我是H1标题</h1>";
    }

    @ResponseBody
    @RequestMapping("/returnJson")
    public Person returnJson() {
        return new Person("zhangshan",12,1);
    }

    @ResponseBody
    @RequestMapping("/returnJson2")
    public Map<String,String> returnJson2() {
        Map<String,String> map = new HashMap<>();
        map.put("id","2925");
        map.put("name","0854");
        return map;
    }


    //设置状态码
    @ResponseBody
    @RequestMapping("/setStatus")
    public String setStatus(HttpServletResponse response) {
        response.setStatus(400);
        return "设置状态码成功";
    }

    //设置content-type
    @ResponseBody
    @RequestMapping(value = "/setType",produces = "application/json")
    public String setContentType() {
        return "{\"success\":true}";
    }
}
