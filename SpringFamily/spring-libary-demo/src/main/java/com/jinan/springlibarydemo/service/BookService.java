package com.jinan.springlibarydemo.service;

import com.jinan.springlibarydemo.dao.BookDao;
import com.jinan.springlibarydemo.enums.BookStatus;
import com.jinan.springlibarydemo.mapper.BookInfoMapper;
import com.jinan.springlibarydemo.model.BookInfo;
import com.jinan.springlibarydemo.model.PageRequest;
import com.jinan.springlibarydemo.model.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

//@Component注解到类上作用是将对象给spring进行管理
@Service
@Slf4j
public class BookService {
    //@Autowired作用是将对象从spring容器中取出来,并对对象赋值
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookInfoMapper bookInfoMapper;
    public List<BookInfo> getList() {
//        BookDao bookDao = new BookDao();
        List<BookInfo> bookInfoList = bookDao.mockDate();
        //2.处理图书状态
        for (BookInfo bookInfo : bookInfoList) {
            if(bookInfo.getStatus() == 1) {
                bookInfo.setStatusCN("可借阅");
            }else {
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfoList;
    }

    public Integer addBook(BookInfo bookInfo) {
        Integer result = null;
        try {
            result = bookInfoMapper.insertBook(bookInfo);
        }catch (Exception e) {
            log.error("图书插入发生异常, e: ", e);
        }

        return result==null ? 0: result;
    }

    public PageResult getListByPage(PageRequest pageRequest) {

        int count = bookInfoMapper.count();
        List<BookInfo> bookInfos = bookInfoMapper.getListByLimit(pageRequest);
        //处理图书状态
        for (BookInfo bookInfo:bookInfos){  //0-无效  1- 可借阅  2-不可借阅
            bookInfo.setStatusCN(BookStatus.getStatusByCode(bookInfo.getStatus()).getName());
        }
        PageResult result = new PageResult(count, bookInfos, pageRequest);
        return result;
    }

    public BookInfo queryBookById(Integer bookId) {
        return bookInfoMapper.queryBookById(bookId);
    }

    public Integer updateBook(BookInfo bookInfo) {
        Integer result = null;
        try {
            result = bookInfoMapper.updateBookById(bookInfo);
        }catch (Exception e){
            log.error("图书更新发生异常, e:", e);
        }
        return result==null?0:result;
    }

    public Integer deleteBook(Integer bookId) {
        Integer result = null;
        try {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(bookId);
            bookInfo.setStatus(BookStatus.DETETED.getCode());
            result = bookInfoMapper.updateBookById(bookInfo);
        }catch (Exception e){
            log.error("图书更新发生异常, e:", e);
        }
        return result==null?0:result;
    }


    public Integer batchDeleteBook(List<Integer> ids) {
        return bookInfoMapper.batchDeleteBook(ids);
    }
}
