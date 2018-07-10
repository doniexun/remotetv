package com.myth.pojo;

public class MobileInfo {
    private Integer mobileCode;

    private String mobileCreateTime;

    public Integer getMobileCode() {
        return mobileCode;
    }

    public void setMobileCode(Integer mobileCode) {
        this.mobileCode = mobileCode;
    }

    public String getMobileCreateTime() {
        return mobileCreateTime;
    }

    public void setMobileCreateTime(String mobileCreateTime) {
        this.mobileCreateTime = mobileCreateTime == null ? null : mobileCreateTime.trim();
    }
}