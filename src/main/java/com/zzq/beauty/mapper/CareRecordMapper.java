package com.zzq.beauty.mapper;

import com.github.pagehelper.Page;
import com.zzq.beauty.model.CareRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface CareRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CareRecord record);

    int insertSelective(CareRecord record);

    CareRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CareRecord record);

    int updateByPrimaryKey(CareRecord record);

    Page<List<Map<String,Object>>> list(String keyWord);

    long getBetweenTimeCount(@Param("startDate") String startDate,@Param("endDate") String endDate);
}