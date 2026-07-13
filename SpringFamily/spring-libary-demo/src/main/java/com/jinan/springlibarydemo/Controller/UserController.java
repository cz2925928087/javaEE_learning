package com.jinan.springlibarydemo.Controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String userName, String passWord, HttpSession session) {
        //如果账号密码为空,返回false
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(passWord)) {
            return false;
        }
        //验证账号密码是否正确,
        //TODO 暂时用admin代替
        if("admin".equals(userName) && "admin".equals(passWord)) {
            session.setAttribute("userName",userName);
            return true;
        }
        return false;
    }

    //获取用户登录状态
    @RequestMapping("getLoginUser")
    public String getLoginUser(HttpSession session) {
        String userName = (String)session.getAttribute("userName");
        return userName == null?"无登录":userName;
    }
}
