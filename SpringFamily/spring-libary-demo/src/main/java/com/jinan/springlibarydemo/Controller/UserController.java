package com.jinan.springlibarydemo.Controller;


import com.jinan.springlibarydemo.model.Result;
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
    public Result<Boolean> login(String userName, String passWord, HttpSession session) {
        log.info("用户登录,接收到的参数 name {}", userName);

        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(passWord)) {
            return Result.paramError("账号或密码不能为空");
        }

        Boolean result = userService.checkPassword(userName, passWord);
        if (result) {
            session.setAttribute("userName", userName);
            log.info("用户 {} 登录成功, session已存入", userName);
            return Result.success(true);
        }
        return Result.paramError("账号或密码不正确");
    }

    @RequestMapping("getLoginUser")
    public Result<String> getLoginUser(HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        if (userName == null) {
            return Result.unlogin();
        }
        return Result.success(userName);
    }
}
