package com.jinan.springmvcdemo;
//用户登录接口实现
import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public Boolean login( String userName ,  String passWord, HttpSession session) {
        //参数校验
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(passWord)) {
            return false;
        }
        //判断账号密码是否正确
        //TODO注释,表示临时的未完成的,相当于打个标签
       //因为没有数据库连接,所以就看账户和密码是否等于"admin"
        if("admin".equals(userName) && "admin".equals(passWord)) {
            session.setAttribute("userName",userName);
            return true;
        }
        return false;
    }

    //获取用户登录状态
    @RequestMapping("/getLoginUser")
    public String getLoginUser(HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        return userName == null?"无登录":userName;
    }

}
