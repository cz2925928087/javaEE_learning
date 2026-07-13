package com.jinan.springlibarydemo.Controller;

import com.jinan.springlibarydemo.dao.BookDao;
import com.jinan.springlibarydemo.model.BookInfo;
import com.jinan.springlibarydemo.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/book")
public class BookController {
    @RequestMapping("/getList")
    public List<BookInfo> getList() {
        //查询图书信息,并返回
        BookService bookService = new BookService();
        List<BookInfo> bookInfoList = bookService.getList();
        return bookInfoList;
    }

}
