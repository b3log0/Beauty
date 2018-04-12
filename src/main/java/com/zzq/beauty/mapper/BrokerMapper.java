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

    /**
     * 查询 最后一条 推荐者信息
     * @param clientID
     * @return
     */
    Broker selectLaster(Integer clientID);

}