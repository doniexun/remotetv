package com.myth.dao;

import com.myth.pojo.TvInfo;

public interface TvInfoMapper {
    int deleteByPrimaryKey(Integer tvCode);

    int insert(TvInfo record);

    int insertSelective(TvInfo record);

    TvInfo selectByPrimaryKey(Integer tvCode);

    int updateByPrimaryKeySelective(TvInfo record);

    int updateByPrimaryKey(TvInfo record);
}