package com.zzq.beauty.mapper;

import com.zzq.beauty.model.Sys;

public interface SysMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sys record);

    int insertSelective(Sys record);

    Sys selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sys record);

    int updateByPrimaryKey(Sys record);
}