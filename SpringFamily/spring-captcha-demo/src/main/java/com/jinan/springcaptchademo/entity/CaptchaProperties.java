package com.jinan.springcaptchademo.entity;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "captcha")
@Data
public class CaptchaProperties {
    private Integer width;
    private Integer height;
    private Integer codeCount;
    private Integer circleCount;
    private Session session;
}
