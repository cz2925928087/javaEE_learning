package com.jinan.springcaptchademo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.jinan.springcaptchademo.constant.Constant;
import com.jinan.springcaptchademo.entity.CaptchaProperties;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.jinan.springcaptchademo.constant.Constant.VALID_MILLIS_TIME;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    @Autowired
    private CaptchaProperties captchaProperties;

    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpSession session, HttpServletResponse response) {
        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(captchaProperties.getWidth(),
                captchaProperties.getHeight(),
                captchaProperties.getCodeCount(),
                captchaProperties.getCircleCount());

        try {
            captcha.write(response.getOutputStream());
            //设置session
            session.setAttribute(Constant.SESSION_CAPTCHA_NAME, captcha.getCode());
            session.setAttribute(Constant.SESSION_CAPTCHA_DATE, System.currentTimeMillis());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                response.getOutputStream().close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @RequestMapping("/check")
    public Boolean check(String captcha, HttpSession session) {
        if (!StringUtils.hasLength(captcha)) {
            return false;
        }

        //获取验证码
        String captchaCode = (String) session.getAttribute(Constant.SESSION_CAPTCHA_NAME);
        Long sessionDate = (Long) session.getAttribute(Constant.SESSION_CAPTCHA_DATE);
        if (captchaCode.equalsIgnoreCase(captcha)) {
            if (sessionDate == null || System.currentTimeMillis() - sessionDate < VALID_MILLIS_TIME) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
