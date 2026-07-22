package com.jinan.springlibarydemo.advice;

import com.jinan.springlibarydemo.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    @Autowired
    public static ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        //是否对结果进行处理
        return false;
    }

    @Override
    public @Nullable Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof Result<?>) {
            //如果返回的结果中包含了body,就直接返回body
            return body;
        }
        return Result.success(body);
    }
}
