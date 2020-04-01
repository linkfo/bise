package com.admin.utils;

import java.util.List;

public class MyPage {
    public Integer pageSize;
    public Integer pageNumber;

    public List rows;
    public Long total;

    public MyPage(Long total ,List rows){
        this.total=total;
        this.rows=rows;
    }
    public MyPage(Long total , List rows, Integer pageSize, Integer pageNumber){
        this.total=total;
        this.rows=rows;
        this.pageSize=pageSize;
        this.pageNumber=pageNumber;
    }
    public MyPage(){

    }
}
