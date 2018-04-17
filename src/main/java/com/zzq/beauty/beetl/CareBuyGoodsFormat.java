package com.zzq.beauty.beetl;

import com.alibaba.fastjson.JSONObject;
import com.zzq.beauty.service.BuyGoodsService;
import com.zzq.beauty.util.SpringContextUtils;
import org.beetl.core.Context;
import org.beetl.core.Function;

import java.util.List;
import java.util.Map;


/**
 * 护理使用的产品
 */
public class CareBuyGoodsFormat implements Function{

    @Override
    public Object call(Object[] objects, Context context) {
        if(objects==null||objects.length>1||objects.length<1){
            return"参数错误";
        }
        StringBuffer sb = new StringBuffer();
        BuyGoodsService buyGoodsService = SpringContextUtils.getBean(BuyGoodsService.class);
        List<Map<String,Object>> list = buyGoodsService.getCareBuyGoods(objects[0].toString());
        for (Map<String, Object> map :list){
            String goodsName= map.get("goodsName").toString();
            String jsonString =map.get("goodsSnapshot").toString();
            JSONObject jsonObject =JSONObject.parseObject(jsonString);
            sb.append("【").append(goodsName).append("[").append(jsonObject.getString("name")).append("]】");
        }
        return sb.toString();
    }
}
