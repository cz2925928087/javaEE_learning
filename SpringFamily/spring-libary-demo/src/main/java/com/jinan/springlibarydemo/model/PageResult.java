package com.jinan.springlibarydemo.model;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private Integer count;
    private List<T> records;

    private PageRequest request;

    public PageResult(Integer count, List<T> records, PageRequest request) {
        this.count = count;
        this.records = records;
        this.request = request;
    }

}
