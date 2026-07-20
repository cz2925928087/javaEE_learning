package com.jinan.springlibarydemo.interceptor;


import com.jinan.springlibarydemo.model.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userName") == null) {
            log.warn("用户未登录, 拦截请求: {}", request.getRequestURI());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\": 401, \"msg\": \"未登录，请先登录\"}");
            return false;
        }
        log.info("已登录用户: {}, 放行请求: {}", session.getAttribute("userName"), request.getRequestURI());
        return true;
    }
}
