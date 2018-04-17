package com.zzq.beauty.service;

import com.zzq.beauty.model.CareRecord;
import com.zzq.beauty.util.PageBean;

import java.util.List;
import java.util.Map;

public interface CareRecordService {
    void insert(CareRecord record);

    PageBean<List<Map<String,Object>>> list(Integer pageNum,Integer pageSize,String keyWord);
}
