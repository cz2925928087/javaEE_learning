package com.jinan.springlibarydemo.service;

import com.jinan.springlibarydemo.dao.BookDao;
import com.jinan.springlibarydemo.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.BooleanLiteral;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

//@Component注解到类上作用是将对象给spring进行管理
@Service
public class BookService {
    //@Autowired作用是将对象从spring容器中取出来,并对对象赋值
    @Autowired
    private BookDao bookDao;
    public List<BookInfo> getList() {
//        BookDao bookDao = new BookDao();
        List<BookInfo> bookInfoList = bookDao.mockDate();
        //2.处理图书状态
        for (BookInfo bookInfo : bookInfoList) {
            if(bookInfo.getStaus() == 1) {
                bookInfo.setStausCN("可借阅");
            }else if(bookInfo.getStaus() == 2){
                bookInfo.setStausCN("不可借阅");
            }
        }
        return bookInfoList;
    }
}
