package com.zzq.beauty.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzq.beauty.mapper.CareRecordMapper;
import com.zzq.beauty.model.CareRecord;
import com.zzq.beauty.service.CareRecordService;
import com.zzq.beauty.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CareRecordServiceImpl implements CareRecordService{
    @Autowired
    CareRecordMapper careRecordMapper;

    @Override
    public void insert(CareRecord record) {
        careRecordMapper.insert(record);
    }

    @Override
    public PageBean<List<Map<String, Object>>> list(Integer pageNum, Integer pageSize, String keyWord) {
        PageHelper.startPage(pageNum,pageSize);
        Page<List<Map<String,Object>>> page = careRecordMapper.list(keyWord);
        return new PageBean<List<Map<String,Object>>>(page.getPageNum(),page.getPageSize(),page.getTotal(),page.getPages(),page.getResult());
    }

    @Override
    public long getBetweenTimeCount(String startDate, String endDate) {
        return careRecordMapper.getBetweenTimeCount(startDate,endDate);
    }
}
