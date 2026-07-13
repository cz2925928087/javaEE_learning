package com.jinan.springlibarydemo.dao;
//dao层一般存放数据相关的代码

import com.jinan.springlibarydemo.model.BookInfo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookDao {
    public List<BookInfo> mockDate() {
        List<BookInfo> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("图书"+i);
            bookInfo.setAuthor("作者"+i);
            bookInfo.setCount(new Random().nextInt(100));
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(100)));
            bookInfo.setPublish("出版社"+i);
            bookInfo.setStaus(i%5==0?2:1);
            list.add(bookInfo);
        }
        return list;
    }
}
