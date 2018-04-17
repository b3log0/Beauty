package com.zzq.beauty.mapper;

import com.github.pagehelper.Page;
import com.zzq.beauty.model.BuyGoods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BuyGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BuyGoods record);

    int insertSelective(BuyGoods record);

    BuyGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BuyGoods record);

    int updateByPrimaryKey(BuyGoods record);

    Page<List<Map<String,Object>>> buyGoodsList(String keyWord);

    List<Map<String,Object>> getBuyGoodsAnEnd(Integer userId);

    List<Map<String, Object>> getCareBuyGoods(String goodsIds);

}