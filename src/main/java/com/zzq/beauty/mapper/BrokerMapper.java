package com.zzq.beauty.mapper;

import com.zzq.beauty.model.Broker;
import org.springframework.stereotype.Repository;

@Repository
public interface BrokerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Broker record);

    int insertSelective(Broker record);

    Broker selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Broker record);

    int updateByPrimaryKey(Broker record);
}