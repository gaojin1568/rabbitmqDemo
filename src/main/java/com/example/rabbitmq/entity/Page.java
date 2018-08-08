package com.example.rabbitmq.entity;

import java.io.Serializable;

public class Page implements Serializable {

    private static final long serialVersionUID = -112501448055278680L;

    private Integer pageNum;
    private String PageName;
    private String PageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageName() {
        return PageName;
    }

    public void setPageName(String pageName) {
        PageName = pageName;
    }

    public String getPageSize() {
        return PageSize;
    }

    public void setPageSize(String pageSize) {
        PageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", PageName='" + PageName + '\'' +
                ", PageSize='" + PageSize + '\'' +
                '}';
    }
}
