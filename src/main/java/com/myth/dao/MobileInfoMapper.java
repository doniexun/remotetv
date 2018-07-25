package com.myth.dao;

import com.myth.pojo.MobileInfo;

public interface MobileInfoMapper {
    int deleteByPrimaryKey(Integer mobileCode);

    int insert(MobileInfo record);

    int insertSelective(MobileInfo record);

    MobileInfo selectByPrimaryKey(Integer mobileCode);

    int updateByPrimaryKeySelective(MobileInfo record);

    int updateByPrimaryKey(MobileInfo record);
}