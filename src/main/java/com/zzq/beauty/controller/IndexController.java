package com.zzq.beauty.controller;

import com.zzq.beauty.DemoApplication;
import com.zzq.beauty.model.User;
import com.zzq.beauty.rest.MyRestResponse;
import com.zzq.beauty.service.*;
import com.zzq.beauty.util.DateUtil;
import com.zzq.beauty.util.PropUtil;
import com.zzq.beauty.util.RestCode;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping("/")
public class IndexController {
    private String confProp;
    @Autowired
    private PersonService personService;
    @Autowired
    private BuyGoodsService buyGoodsService;
    @Autowired
    private CareRecordService careRecordService;
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SysService sysService;

    @RequestMapping("/index/index")
    public ModelAndView index(){
            ModelAndView  mv=  new ModelAndView();
            mv.setViewName("main");
            return  mv;
    }
    @RequestMapping("/index/main")
    public ModelAndView main(){
        //获取prop文件内容
        String indexStatistics = sysService.select("indexStatistics").getValue();
        int indexDay=Integer.parseInt(indexStatistics);

        ModelAndView  mv=  new ModelAndView();
        mv.addObject("indexDay",indexDay);
        Date endDate= new Date();

        Date startDate=DateUtil.beforOrAfterTime(endDate,-indexDay);

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
        //护理超时人数
        String dontCareByDay= sysService.select("dontCareByDay").getValue();
         startDate=DateUtil.beforOrAfterTime(endDate,-Integer.parseInt(dontCareByDay));
         startDateStr=simpleDateFormat.format(startDate);
         endDateStr=simpleDateFormat.format(endDate);
        long careOutTimeNum=personService.getCareOutTimeTimePerson(startDateStr,endDateStr);

        mv.addObject("outCare",dontCareByDay);
        mv.addObject("careOutTimeNum",careOutTimeNum);
        //库存预警
        String inventoryWarning= sysService.select("inventoryWarning").getValue();
        mv.addObject("inventoryWarning",inventoryWarning);
        long inStock=goodsService.goodsInStock(Integer.parseInt(inventoryWarning));
        mv.addObject("inStock",inStock);

        mv.setViewName("index");
        return  mv;
    }
    @RequestMapping("/")
    public ModelAndView login(HttpServletRequest request){
        request.setAttribute("base",request.getContextPath());
        ModelAndView  mv=  new ModelAndView();
        mv.setViewName("login");
        return  mv;
    }
    @RequestMapping("/out")
    public ModelAndView out(HttpServletRequest request){
        request.setAttribute("base",request.getContextPath());
        ModelAndView  mv=  new ModelAndView();
        mv.setViewName("login");
        return  mv;
    }
    @RequestMapping("/singIn")
    public @ResponseBody MyRestResponse singIn(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord, HttpServletRequest request){
        request.setAttribute("base",request.getContextPath());
        ModelAndView  mv=  new ModelAndView();
        HashMap<String,Object> user= (HashMap<String, Object>) userService.singIn(userName,passWord);
        if(user!=null){
            if(Integer.parseInt(user.get("state").toString())==1){
                return  new MyRestResponse(RestCode._304.getCode(),RestCode._304.getMessage(),null);
            }
            User u = new User();
            u.setId(Integer.parseInt(user.get("id").toString()));
            u.setLastlogindate(new Date());
            userService.updateUserSelective(u);
            request.getSession().setAttribute("user",user);
            return  new MyRestResponse(200,"",null);
        }
        else{
            return  new MyRestResponse(RestCode._303.getCode(),RestCode._303.getMessage(),null);
        }
    }
}
