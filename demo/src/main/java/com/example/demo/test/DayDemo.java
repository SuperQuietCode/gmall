package com.example.demo.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  计算两个日期之间的间隔天数
 *
 * 	2020-11-00 for 500
 *  2021-2-8   for 600
 *  2022-3-15  for 1000
 */
public class DayDemo {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse("2019-06-19");
        Date endDate = sdf.parse("2022-3-15");
        long betweenDate = (endDate.getTime() - startDate.getTime()) / (60 * 60 * 24 * 1000);
        System.out.println(betweenDate);
    }
}
