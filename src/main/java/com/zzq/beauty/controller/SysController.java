package com.zzq.beauty.controller;

import com.zzq.beauty.bean.Sys;
import com.zzq.beauty.util.PropUtil;
import com.zzq.beauty.util.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * 系统参数
 */
@Controller
@RequestMapping("/sys")
public class SysController {
    @RequestMapping("/sys")
    public ModelAndView sysPage() throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        Properties properties= PropUtil.readProperties(getClass().getResource("/conf.properties").getPath());
        String inventoryWarning= properties.getProperty("inventoryWarning");
        String dontCareByDay= properties.getProperty("dontCareByDay");
        String indexStatistics= properties.getProperty("indexStatistics");
        modelAndView.addObject("inventoryWarning",inventoryWarning);
        modelAndView.addObject("dontCareByDay",dontCareByDay);//
        modelAndView.addObject("indexStatistics",indexStatistics);
        modelAndView.setViewName("/sys/sys");
        return  modelAndView;
    }
    @RequestMapping("/update")
    public ModelAndView update(@ModelAttribute Sys sys){
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("inventoryWarning",sys.getInventoryWarning());
        map.put("dontCareByDay",sys.getDontCareByDay());
        map.put("indexStatistics",sys.getIndexStatistics());
        PropUtil.writePropertiesList(getClass().getResource("/conf.properties").getPath(),map);
        return new View().redirect("/sys/sys");
    }
}
