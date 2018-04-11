package com.zzq.beauty.mapper;

import com.zzq.beauty.model.Goods;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}