package com.dinner.snqjf.common.util.date;

import java.util.Date;

/*
* 类描述：
* @auther linzf
* @create 2017/11/15 0015 
*/
public class DateUtil {

    /**
     * 功能描述：根据时间和传过来的格式 格式化显示时间
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return "null";
        }
        if (pattern == null || pattern.equals("") || pattern.equals("null")) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        return new java.text.SimpleDateFormat(pattern).format(date);
    }




}
