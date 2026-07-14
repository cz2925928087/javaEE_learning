package com.jinan.springiocdemo.config;

import ch.qos.logback.core.hook.DefaultShutdownHook;
import com.jinan.springiocdemo.entity.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfig {

    @Bean
    public DefaultShutdownHook objectMapper(){
        return new DefaultShutdownHook();
    }

    @Bean
    public UserInfo userInfo(){
        return new UserInfo("zhangsan", 16);
    }

    @Bean({"u2", "userInfo2"})
//    @Primary
    public UserInfo userInfo2(){
        return new UserInfo("lisi", 17);
    }
}
