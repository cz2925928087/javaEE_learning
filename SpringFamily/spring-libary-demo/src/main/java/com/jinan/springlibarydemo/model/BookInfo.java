package com.jinan.springlibarydemo.model;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookInfo {
    //图书id
    private Integer id;
    //图书名字
    private String bookName;
    //作者
    private String author;
    //库存
    private Integer count;
    //定价
    private BigDecimal price;
    //出版社
    private String publish;
    //状态码:1表示可借阅,2表示不可借阅,0表示删除
    private Integer staus;
    //状态码含义
    private String stausCN;

    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
}
