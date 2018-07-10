package com.myth.pojo;

public class TvInfo {
    private Integer tvCode;

    private String tvCreateTime;

    private String tvAppList;

    public Integer getTvCode() {
        return tvCode;
    }

    public void setTvCode(Integer tvCode) {
        this.tvCode = tvCode;
    }

    public String getTvCreateTime() {
        return tvCreateTime;
    }

    public void setTvCreateTime(String tvCreateTime) {
        this.tvCreateTime = tvCreateTime == null ? null : tvCreateTime.trim();
    }

    public String getTvAppList() {
        return tvAppList;
    }

    public void setTvAppList(String tvAppList) {
        this.tvAppList = tvAppList == null ? null : tvAppList.trim();
    }
}