package com.zzq.beauty.mapper;

import com.zzq.beauty.model.BuyGoods;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BuyGoods record);

    int insertSelective(BuyGoods record);

    BuyGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BuyGoods record);

    int updateByPrimaryKey(BuyGoods record);
}