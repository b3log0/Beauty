package com.zzq.beauty.controller;

import com.zzq.beauty.service.BuyGoodsService;
import com.zzq.beauty.service.CareRecordService;
import com.zzq.beauty.service.PersonService;
import com.zzq.beauty.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private PersonService personService;
    @Autowired
    private BuyGoodsService buyGoodsService;
    @Autowired
    private CareRecordService careRecordService;
    @RequestMapping("/index")
    public ModelAndView index(){
            ModelAndView  mv=  new ModelAndView();
            mv.setViewName("main");
            return  mv;
    }
    @RequestMapping("/main")
    public ModelAndView main(){
        ModelAndView  mv=  new ModelAndView();

        Date endDate= DateUtil.beforOrAfterTime(new Date(),1);

        Date startDate=DateUtil.beforOrAfterTime(endDate,-7);;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String startDateStr=simpleDateFormat.format(startDate);
        String endDateStr=simpleDateFormat.format(endDate);
        //新增会员
        long personNum=personService.getBetweenTimePerson(startDateStr,endDateStr);
        mv.addObject("newPersonCount",personNum);
        //销售额
        double sale=buyGoodsService.getSale(startDateStr,endDateStr);
        mv.addObject("sale",sale);

        //销售个数
        long saleGoodsNum=buyGoodsService.getSaleGoodsNum(startDateStr,endDateStr);
        mv.addObject("saleGoodsNum",saleGoodsNum);
        //护理次数
        long careNum=careRecordService.getBetweenTimeCount(startDateStr,endDateStr);
        mv.addObject("careNum",careNum);




        mv.setViewName("index");
        return  mv;
    }
}
