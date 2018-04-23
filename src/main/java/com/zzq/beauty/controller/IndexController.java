package com.zzq.beauty.controller;

import com.zzq.beauty.model.User;
import com.zzq.beauty.rest.MyRestResponse;
import com.zzq.beauty.service.BuyGoodsService;
import com.zzq.beauty.service.CareRecordService;
import com.zzq.beauty.service.PersonService;
import com.zzq.beauty.service.UserService;
import com.zzq.beauty.util.DateUtil;
import com.zzq.beauty.util.RestCode;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private PersonService personService;
    @Autowired
    private BuyGoodsService buyGoodsService;
    @Autowired
    private CareRecordService careRecordService;
    @Autowired
    private UserService userService;
    @RequestMapping("/index/index")
    public ModelAndView index(){
            ModelAndView  mv=  new ModelAndView();
            mv.setViewName("main");
            return  mv;
    }
    @RequestMapping("/index/main")
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
            User u = new User();
            u.setId(Integer.parseInt(user.get("id").toString()));
            u.setLastlogindate(new Date());
            userService.updateUserSelective(u);
            request.getSession().setAttribute("user",user);
            return  new MyRestResponse(200,"",null);
        }else{
            return  new MyRestResponse(RestCode._303.getCode(),RestCode._303.getMessage(),null);
        }
    }
}
