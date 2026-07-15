package com.jinan.springiocdemo.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "dbtype")
@Data
public class DbType {
    private List<String> name;
    private Map<String,String> map;
 }
