package com.jinan.springlibarydemo.service;

import com.jinan.springlibarydemo.dao.BookDao;
import com.jinan.springlibarydemo.model.BookInfo;
import org.springframework.expression.spel.ast.BooleanLiteral;

import java.awt.print.Book;
import java.util.List;

public class BookService {
    public List<BookInfo> getList() {
        BookDao bookDao = new BookDao();
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
