package com.zzq.beauty.controller;

import com.github.pagehelper.Page;
import com.zzq.beauty.model.Goods;
import com.zzq.beauty.service.BuyGoodsService;
import com.zzq.beauty.service.CareRecordService;
import com.zzq.beauty.service.PersonService;
import com.zzq.beauty.util.DateUtil;
import com.zzq.beauty.util.PageBean;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhuzhiqiang on 2018/4/22.
 * 财务管理
 */
@Controller
@RequestMapping("/financial")
public class FinancialController {
    @Autowired
    private BuyGoodsService buyGoodsService;
    @Autowired
    private CareRecordService careRecordService;
    @Autowired
    private PersonService personService;

    /**
     * 销售记录
     * @param startDate
     * @param endDate
     * @param pageNum
     * @param keyWord
     * @return
     */
    @RequestMapping("/sales")
    public ModelAndView sales(@RequestParam(value = "startDate",required = false,defaultValue = "null") String startDate,
                              @RequestParam(value = "endDate",required = false,defaultValue = "null") String endDate,
                              @RequestParam(value = "pageNum",defaultValue = "1",required = false) Integer pageNum,
                              @RequestParam(value = "keyWord",defaultValue = "",required = false) String keyWord
                              ){
        if(startDate.equals("null")){
            startDate=new SimpleDateFormat("yyyy-MM-01").format(new Date());
        }
        if(endDate.equals("null")){
            int maxDay= DateUtil.getCurrentMonthLastDay();
            endDate=new SimpleDateFormat("yyyy-MM-"+maxDay).format(new Date());
        }
        ModelAndView modelAndView=new ModelAndView();
        PageBean<List<Map<String,Object>>>page =buyGoodsService.getSales(pageNum,20,startDate,endDate,"%"+keyWord+"%");
        modelAndView.addObject("list",page.getList());
        modelAndView.addObject("page",page);
        modelAndView.addObject("startDate",startDate);
        modelAndView.addObject("endDate",endDate);
        modelAndView.addObject("keyWord",keyWord);
        modelAndView.setViewName("/financial/financialList");
        return modelAndView;
    }
    /**
     * 统计
     *  当月护理人 （次数）  总次数
     *  销售额
     *  新增会员
     *  产品销量（top10）
     */
    public ModelAndView count(
            @RequestParam(value = "startDate",required = false,defaultValue = "null") String startDate,
            @RequestParam(value = "endDate",required = false,defaultValue = "null") String endDate
    ){
        if(startDate.equals("null")){
            startDate=new SimpleDateFormat("yyyy-MM-01").format(new Date());
        }
        if(endDate.equals("null")){
            int maxDay= DateUtil.getCurrentMonthLastDay();
            endDate=new SimpleDateFormat("yyyy-MM-"+maxDay).format(new Date());
        }
        //销售额
        double sale =buyGoodsService.getSale(startDate,endDate);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/");
        //// TODO: 2018/4/22
        return modelAndView;


    }
}
