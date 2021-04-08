/*
 * @projectName raladmin
 * @package com.ral.admin
 * @className com.ral.admin.Demo
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Demo
 * @Description
 * @author renyunhui
 * @date 2021/3/30 18:03
 * @version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        System.err.println(isLegalDate("1988-04-10 00:00:00", "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 根据时间 和时间格式 校验是否正确
     * @param sDate 校验的日期
     * @param format 校验的格式
     * @return
     */
    public static boolean isLegalDate(String sDate,String format) {
        DateFormat formatter = new SimpleDateFormat(format);
        try {
            Date date = formatter.parse(sDate);
            return sDate.equals(formatter.format(date));
        } catch (Exception e) {
            return false;
        }
    }
}
