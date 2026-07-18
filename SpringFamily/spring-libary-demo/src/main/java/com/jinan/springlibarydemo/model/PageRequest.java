package com.jinan.springlibarydemo.model;

import lombok.Data;

@Data
public class PageRequest {
    private int currentPage = 1;
    private int pageSize =10;

    private int offset;

    public int getOffset() {
        return (currentPage-1) * pageSize;
    }

}
