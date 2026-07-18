package com.jinan.springlibarydemo.Controller;

import com.jinan.springlibarydemo.model.BookInfo;
import com.jinan.springlibarydemo.model.PageRequest;
import com.jinan.springlibarydemo.model.PageResult;
import com.jinan.springlibarydemo.model.Result;
import com.jinan.springlibarydemo.service.BookService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/getList")
    public List<BookInfo> getList() {
        //查询图书信息,并返回
        // BookService bookService = new BookService();
        List<BookInfo> bookInfoList = bookService.getList();
        return bookInfoList;
    }

    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo) {
        /*
         * 1.参数校验
         * 2.添加图书
         * 3.返回结果
         * */
        if (!StringUtils.hasLength(bookInfo.getBookName())
                || !StringUtils.hasLength(bookInfo.getAuthor())
                || bookInfo.getCount() == null
                || bookInfo.getPrice() == null
                || !StringUtils.hasLength(bookInfo.getPublish())
                || bookInfo.getStatus() == null) {
            return "参数错误不合法";
        }
        Integer result = bookService.addBook(bookInfo);
        return result == 1 ? "" : "参数插入失败";
    }



    @RequestMapping("/getListByPage")
    public Result<PageResult> getListByPage(PageRequest pageRequest){
        log.info("获取翻页信息, pageRequest: {}", pageRequest);
        //参数校验  TODO
        PageResult pageResult = bookService.getListByPage(pageRequest);
        return Result.success(pageResult);
    }


    @RequestMapping("?queryBookById")
    public BookInfo queryBookById(Integer bookId) {
        log.info("查询图书详情,bookId: {}",bookId);
        //参数校验
        if(bookId == null || bookId<0) {
            return null;
        }
        BookInfo bookInfo = bookService.queryBookById(bookId);
        return bookInfo;
    }

    @RequestMapping("/updateBook")
    public String updateBook(BookInfo bookInfo) {
        log.info("修改图书信息, bookInfo:{}", bookInfo);
        //参数校验
        if(bookInfo.getId() == null || bookInfo.getId()<0) {
            return "参数不正确";
        }
        Integer result = bookService.updateBook(bookInfo);
        return result==1?"": "数据更新失败";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(Integer bookId){
        log.info("删除图书信息, bookId:{}", bookId);
        if (bookId==null || bookId<0){
            return "参数不正确";
        }

        Integer result = bookService.deleteBook(bookId);
        return result==1?"": "数据删除失败";
    }

    @RequestMapping("/batchDeleteBook")
    public String batchDeleteBook(@RequestParam List<Integer> ids){
        log.info("批量删除图书, ids:{}", ids);
        if (CollectionUtils.isEmpty(ids)){
            return "未设置需要删除的图书";
        }
        try {
            bookService.batchDeleteBook(ids);
        }catch (Exception e){
            log.error("批量删除图书失败, e:", e);
            return "批量删除图书失败";
        }
        return "";
    }

}
