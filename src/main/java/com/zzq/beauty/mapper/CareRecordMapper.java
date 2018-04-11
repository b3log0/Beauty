package com.zzq.beauty.mapper;

import com.zzq.beauty.model.CareRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface CareRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CareRecord record);

    int insertSelective(CareRecord record);

    CareRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CareRecord record);

    int updateByPrimaryKey(CareRecord record);
}