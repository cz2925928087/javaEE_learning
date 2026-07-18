package com.jinan.springlibarydemo.mapper;

import com.jinan.springlibarydemo.model.BookInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class BookInfoMapperTest {
    @Autowired
    BookInfoMapper bookInfoMapper;
    @Test
    void insertBook() {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName("111");
        bookInfo.setAuthor("bbb");
        bookInfo.setCount(21);
        bookInfo.setPrice(BigDecimal.valueOf(21));
        bookInfo.setPublish("aaa");
        bookInfo.setStaus(1);
        bookInfoMapper.insertBook(bookInfo);
    }
}