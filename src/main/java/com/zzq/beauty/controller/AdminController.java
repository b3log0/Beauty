package com.zzq.beauty.controller;

import com.zzq.beauty.model.Person;
import com.zzq.beauty.model.User;
import com.zzq.beauty.rest.MyRestResponse;
import com.zzq.beauty.service.PersonService;
import com.zzq.beauty.service.UserService;
import com.zzq.beauty.util.RestCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private PersonService personService;

    @RequestMapping("/adminList")
    public ModelAndView adminList(
            @RequestParam(value = "pageNum",defaultValue = "1",required = false) Integer pageNum,
            @RequestParam(value = "keyWord",defaultValue = "",required = false) String keyWord
    ){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",userService.getUserList(pageNum,10,"%"+keyWord+"%"));
        modelAndView.addObject("keyWord",keyWord);
        modelAndView.setViewName("admin/adminList");
        return modelAndView;
    }
    @RequestMapping("/addAdmin")
    public ModelAndView addAdmin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/addAdmin");
        return modelAndView;
    }
    @RequestMapping("/saveAdmin")
    public @ResponseBody
    MyRestResponse saveAdmin(@ModelAttribute User user, @ModelAttribute  Person person){
        if(userService.isHaveUserName(user.getUsername())>0){
            return new MyRestResponse(RestCode._201.getCode(),RestCode._201.getMessage());
        }
        user.setCreatedate(new Date());
        user.setState(0);
        userService.insert(user);
        person.setUserid(user.getId());
        person.setType(0);
        person.setCreatedate(new Date());
        personService.insert(person);
        return new MyRestResponse(200,"成功");
    }
}
