package com.zzq.beauty.beetl;

import com.alibaba.fastjson.JSONObject;
import org.beetl.core.Context;
import org.beetl.core.Function;

public class GoodsJSONFormat implements Function {
    @Override
    public Object call(Object[] objects, Context context) {
        if(objects.length==0||objects.length>1){
            return "参数错误！";
        }
        String jsonObject = objects[0].toString();
        System.out.println(jsonObject);
        JSONObject goods = JSONObject.parseObject(jsonObject);
        return "商品名称："+goods.get("name")+"  |   价格："+goods.get("price");
    }
}
