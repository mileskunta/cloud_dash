package com.ezhupai.vo;

/**
 * Created by Administrator on 2018/7/13.
 */
public class CameraRequestVo {
    private String keyword;
    private int start;
    private int limit;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
