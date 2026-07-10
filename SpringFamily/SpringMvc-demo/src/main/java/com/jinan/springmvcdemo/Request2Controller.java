package com.jinan.springmvcdemo;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request2")
public class Request2Controller {
    //获取cookie
    @RequestMapping("/getCookie")
    public String getCookie(HttpServletRequest request,
                            HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for(Cookie cookie:cookies) {
                System.out.println(cookie.getName()+ "="
                        +cookie.getValue());
            }
        }
        return "获取cookie成功";
    }

    @RequestMapping("/getCookie2")
    public String getCookie(@CookieValue("Java1") String Java1) {
        return "获取cookie成功"+Java1;
    }

    //设置session
    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("name", "瑾桉");
        session.setAttribute("age", 22);
        session.setAttribute("userInfo", new Person("404", 21, 1));
        return "session设置成功";
    }

    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request) {
        //获取session
        HttpSession session = request.getSession();
        System.out.println("name: "+session.getAttribute("name"));
        System.out.println("userInfo: "+session.getAttribute("userInfo"));
        return "获取session成功";
    }
    //通过注解的方式获取session
    public String getSession2(@SessionAttribute(value = "userInfo",required = false)
                              Person userInfo) {
        return "userInfo: " + userInfo;
    }

    //获取header
    @RequestMapping("/getHeader")
    public String getHeader(HttpServletRequest request) {
        String userAgent = request.getHeader("user-Agent");
        return "userAgent" + ":" +userAgent;
    }


}
