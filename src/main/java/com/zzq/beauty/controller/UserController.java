package com.zzq.beauty.controller;

import com.zzq.beauty.model.Person;
import com.zzq.beauty.rest.MyRestResponse;
import com.zzq.beauty.service.PersonService;
import com.zzq.beauty.util.PageBean;
import com.zzq.beauty.util.RestCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController{
	@Autowired
	private PersonService personService;
    private ModelAndView modelAndView;

    @RequestMapping("/userList")
	public ModelAndView userList(@RequestParam(value = "pageNum",defaultValue = "1",required = false) Integer pageNum,
                                 @RequestParam(value = "pageNum",defaultValue = "",required = false) String  keyWord
                                 ){
	    modelAndView = new ModelAndView();
        PageBean<List<Map<String,Object>>> page= personService.getPersonAndReCommender(pageNum,10,"%"+keyWord+"%");
        modelAndView.addObject("list",page.getList());
        modelAndView.addObject("page",page);
        modelAndView.setViewName("/user/userList");
        return modelAndView;
    }
    @RequestMapping("/addUser")
    public ModelAndView addUser(
                                @RequestParam(value = "personId",required = false) Integer personId
    ){
	    modelAndView = new ModelAndView();
	    if(personId==null){//add

        }else{//edit
            Person person =personService.getPersonById(personId);
            modelAndView.addObject("person",person);
            modelAndView.addObject("salesManId",person.getUserid());
        }

	    modelAndView.addObject("salesMans",personService.getSalesman());
	    modelAndView.setViewName("/user/addUser");
        return modelAndView;
    }
    @RequestMapping("/saveUser")
    public MyRestResponse saveUser(@RequestParam(value = "userId",defaultValue = "0",required = false) Integer userId,
                                   @ModelAttribute("person") Person person,
                                   @RequestParam(value = "id",defaultValue = "0",required = false) Integer id
    ){
        person.setType(1);
        person.setCreatedate(new Date());
        person.setUserid(userId);
        personService.insert(person);
        return new MyRestResponse(RestCode._200.getCode(),"添加成功！");
    }

}
