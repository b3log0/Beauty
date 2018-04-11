package com.zzq.beauty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping("/index")
    public ModelAndView index(){
            ModelAndView  mv=  new ModelAndView();
            mv.setViewName("main");
            return  mv;
    }
    @RequestMapping("/main")
    public ModelAndView main(){
        ModelAndView  mv=  new ModelAndView();
        mv.setViewName("index");
        return  mv;
    }
}
