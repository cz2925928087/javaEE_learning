package com.jinan.springlibarydemo.Controller;


import com.jinan.springlibarydemo.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Boolean login(String userName, String passWord, HttpSession session) {
        log.info("用户登录,接收到的参数 name {}",userName);

        //如果账号密码为空,返回false
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(passWord)) {
            return false;
        }
        //验证账号密码是否正确,
        //TODO 暂时用admin代替
//        if("admin".equals(userName) && "admin".equals(passWord)) {
//            session.setAttribute("userName",userName);
//            return true;
//        }

        Boolean result = userService.checkPassword(userName,passWord);
        return result;
    }

    //获取用户登录状态
    @RequestMapping("getLoginUser")
    public String getLoginUser(HttpSession session) {
        String userName = (String)session.getAttribute("userName");
        return userName == null?"无登录":userName;
    }
}
