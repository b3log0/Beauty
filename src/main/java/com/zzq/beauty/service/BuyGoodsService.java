package com.zzq.beauty.service;

import com.zzq.beauty.model.BuyGoods;
import com.zzq.beauty.util.PageBean;

import java.util.List;
import java.util.Map;

public interface BuyGoodsService {
    void insert(BuyGoods buyGoods);

    BuyGoods selectByPrimaryKey(Integer id);

    String[] buy(Integer[] goodsId, Integer[] num, Integer userId);

    PageBean<List<Map<String,Object>>> buyGoodsList(Integer pageNum,Integer pageSize,String keyWord);
}
