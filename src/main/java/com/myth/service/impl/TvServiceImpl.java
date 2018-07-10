package com.myth.service.impl;

import com.myth.dao.TvInfoMapper;
import com.myth.pojo.TvInfo;
import com.myth.service.TvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TvServiceImpl implements TvService {
    @Autowired
    private TvInfoMapper tvInfoMapper;
    @Override
    public int updateByPrimaryKey(TvInfo record) {
        tvInfoMapper.updateByPrimaryKey(record);
        return 0;
    }
}
