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

    void end(Integer id);

    /**
     * 获取用户所有未使用完的产品
     * @param userId
     * @return
     */
    List<Map<String,Object>> getBuyGoodsAnEnd(Integer userId);

    /**
     * 获取使用的护理产品
     * @param userId
     * @return
     */
    List<Map<String,Object>> getCareBuyGoods(String goodsIds);
}
