package cn.lzq.springboot.controller;

import java.util.Calendar;

/**
 * @author zhiqi.liu@yoho.cn
 * @create 2016-10-24 14:22
 */
public class Main {
    private static final int DAY_SECOND = 24 * 60 * 60;
    private static final int HOUR_SECOND = 60 * 60;
    //一年366天的秒数
    private static final int YEAR_SECOND = 366 * DAY_SECOND;
    public static void main(String[] args) {
        String s = "INSERT INTO sale_brand(id,brand_name,brand_alif,top_sort_id,top_sort_name) " +
                "SELECT e.id, " +
                "       e.brand_name, " +
                "       e.brand_alif, " +
                "       t.id AS top_sort_id, " +
                "       t.brand_type_name AS top_sort_name " +
                "FROM brand_erp e " +
                "LEFT JOIN brand_pm_relate b ON BINARY e.brand_name = b.brand_name " +
                "LEFT JOIN top_brand_type t ON b.brand_type = t.type_other_name";
        System.out.println(s);

        long todayEndTimeSecond = System.currentTimeMillis() / 1000;
        long todayStartTimeSecond = todayEndTimeSecond - DAY_SECOND;
        long yesterdayStartTimeSecond = todayStartTimeSecond - YEAR_SECOND;
        long yesterDayEndTimeSecond = todayEndTimeSecond - YEAR_SECOND;

        System.out.println(yesterDayEndTimeSecond+"---"+yesterdayStartTimeSecond);
    }
}
