package com.zzq.beauty.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhuzhiqiang on 2018/4/22.
 */
public class DateUtil {
    /**
     * 获取当月有多少天
     * @return
     */
    public static int getCurrentMonthLastDay()
    {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获取一个日期N天之前
     * @param date
     * @param day
     * @return
     */
    public static Date beforOrAfterTime(Date date,int day){

        Calendar a = Calendar.getInstance();
        a.setTime(date);
        a.add(Calendar.DATE,day);
        return a.getTime();
    }
    
}
