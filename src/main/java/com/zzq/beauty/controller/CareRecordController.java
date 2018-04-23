package com.zzq.beauty.controller;

import com.zzq.beauty.model.CareRecord;
import com.zzq.beauty.model.Person;
import com.zzq.beauty.rest.MyRestResponse;
import com.zzq.beauty.service.BuyGoodsService;
import com.zzq.beauty.service.CareRecordService;
import com.zzq.beauty.service.PersonService;
import com.zzq.beauty.util.CommonUtil;
import com.zzq.beauty.util.DateUtil;
import com.zzq.beauty.util.PageBean;
import com.zzq.beauty.util.RestCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/careRecord")
public class CareRecordController {
    @Autowired
    private CareRecordService careRecordService;
    @Autowired
    private BuyGoodsService buyGoodsService;
    @Autowired
    private PersonService personService;


    @RequestMapping("/add")
    public ModelAndView add(@RequestParam(value = "id") Integer userId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userId",userId);
        modelAndView.addObject("goodsList",buyGoodsService.getBuyGoodsAnEnd(userId));
        modelAndView.addObject("userList",personService.getSalesman());
        modelAndView.setViewName("/careRecord/addCareRecord");
        return  modelAndView;
    }

    /**
     * 护理几率
     * @param goodsId 商品IDs
     * @param userId  技师
     * @param personId 客户
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    MyRestResponse save(@RequestParam(value = "goodsId") String [] goodsId,
                        @RequestParam(value = "userId",defaultValue = "0") Integer userId,
                        @RequestParam(value = "personId") Integer personId,
                        @RequestParam(value = "dateTime") String dateTime){
        Person person = personService.getPersonById(personId);
        if(userId==0){
            userId=person.getUserid();
        }

        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date =new Date();
        try {
            if(dateTime!=null||dateTime.length()>0)
            date=simpleDateFormat.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CareRecord careRecord = new CareRecord();
        careRecord.setGoodsid(CommonUtil.toString(Arrays.asList(goodsId),","));
        careRecord.setPersonid(personId);
        careRecord.setUserid(userId);
        careRecord.setCreatedate(date);
        careRecordService.insert(careRecord);
        return new MyRestResponse(RestCode._200.getCode(),"操作成功！");
    }
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "startDate",required = false,defaultValue = "null") String startDate,
                             @RequestParam(value = "endDate",required = false,defaultValue = "null") String endDate,
                             @RequestParam(value = "pageNum",defaultValue = "1",required = false) Integer pageNum,
                              @RequestParam(value = "keyWord",defaultValue = "",required = false) String keyWord){
        ModelAndView modelAndView = new ModelAndView();
        if(startDate.equals("null")){
            startDate=new SimpleDateFormat("yyyy-MM-01").format(new Date());
        }
        if(endDate.equals("null")){
            int maxDay= DateUtil.getCurrentMonthLastDay();
            endDate=new SimpleDateFormat("yyyy-MM-"+maxDay).format(new Date());
        }
        modelAndView.addObject("startDate",startDate);
        modelAndView.addObject("endDate",endDate);

        PageBean<List<Map<String,Object>>> page =careRecordService.list(pageNum,10,"%"+keyWord+"%",startDate,endDate);
        modelAndView.addObject("list",page.getList());
        modelAndView.addObject("page",page);
        modelAndView.addObject("keyWord",keyWord);
        modelAndView.setViewName("/careRecord/careRecordList");
        return  modelAndView;
    }
}
