package com.zzq.beauty.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzq.beauty.mapper.BuyGoodsMapper;
import com.zzq.beauty.mapper.GoodsMapper;
import com.zzq.beauty.model.BuyGoods;
import com.zzq.beauty.model.Goods;
import com.zzq.beauty.service.BuyGoodsService;
import com.zzq.beauty.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BuyGoodsServiceImpl implements BuyGoodsService{
    @Autowired
    BuyGoodsMapper buyGoodsMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public BuyGoods selectByPrimaryKey(Integer id) {
        return buyGoodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insert(BuyGoods buyGoods) {
        buyGoodsMapper.insert(buyGoods);
    }

    @Override
    @Transactional
    public String[] buy(Integer[] goodsId, Integer[] num, Integer userId) {
        Date date = new Date();
        for (int i=0;i<goodsId.length;i++){
            Goods goods =goodsMapper.selectByPrimaryKey(goodsId[i]);
            if(goods.getNum()<num[i]){//库存不足
                return new String[]{"302",goods.getName()};
            }
            if(0>=num[i]){//参数错误
                return new String[]{"301",""};
            }
            BuyGoods buyGoods = new BuyGoods();
            buyGoods.setNum(num[i]);
            buyGoods.setPrice(goods.getPrice());
            buyGoods.setGoodssnapshot(JSON.toJSON(goods).toString());
            buyGoods.setGoodsid(goods.getId());
            buyGoods.setState(1);
            buyGoods.setUserId(userId);
            buyGoods.setCreatedate(date);
            insert(buyGoods);
            //减少库存
            goodsMapper.reduceInventory(num[i],goods.getId());
        }
        return  new String[]{"200",""};
    }


    @Override
    public PageBean<List<Map<String, Object>>> buyGoodsList(Integer pageNum, Integer pageSize, String keyWord) {
        PageHelper.startPage(pageNum,pageSize);
        Page<List<Map<String, Object>>> page =buyGoodsMapper.buyGoodsList(keyWord);
        return new PageBean<List<Map<String, Object>>>(page.getPageNum(),page.getPageSize(),page.getTotal(),page.getPages(),page.getResult());
    }

    @Override
    public void end(Integer id) {
        BuyGoods buyGoods =buyGoodsMapper.selectByPrimaryKey(id);
        buyGoods.setState(0);
        buyGoods.setUpdatedate(new Date());
        buyGoodsMapper.updateByPrimaryKeySelective(buyGoods);
    }

    @Override
    public List<Map<String,Object>> getBuyGoodsAnEnd(Integer userId) {
        return buyGoodsMapper.getBuyGoodsAnEnd(userId);
    }

    @Override
    public List<Map<String, Object>> getCareBuyGoods(String goodsIds) {
        return buyGoodsMapper.getCareBuyGoods(goodsIds);
    }
}
