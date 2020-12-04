package com.sxteng.hutool.date;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    /**
     * 标准日期格式：yyyy-MM-dd
     */
    public static final String NORM_DATE_PATTERN = "yyyy-MM-dd";

    @Test
    public void test(){

        Student student = new Student();
        Human human = new Human();

        BeanUtil.copyProperties(student,human);

        Date date = new Date();
        System.out.println(date.getTime());
        date = date2DateOfYYYYMMDD(date);
        System.out.println(date.getTime());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Date date2 = new Date();
        date2.setHours(2);
        System.out.println(date2.getTime());
        date2 = date2DateOfYYYYMMDD(date2);
        System.out.println(date2.getTime());


    }

    public static Date date2DateOfYYYYMMDD(Date date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String strDate =  format.format(date);
            return format.parse(strDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public  void test2() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstDate = format.parse("2020-08-08 12:33:45");
        Date secondDate = format.parse("2020-08-07 12:33:44");

        System.out.println(accurateToDayCompare(firstDate,secondDate));

    }

    /**
     * 精确到天比较日期大小
     * 若日期为null则大于另一个日期
     * @param firstDate 比较第一个日期
     * @param secondDate 比较第二个日期
     * @return 比较结果，如果firstDate大于secondDate 则返回大于0; 等于则返回0;小于则返回小于0
     */
    public static int accurateToDayCompare(Date firstDate, Date secondDate) {

        try {

            if (firstDate == secondDate) {
                return 0;
            } else if (firstDate == null) {
                return 1;
            } else if (secondDate == null) {
                return -1;
            }

            SimpleDateFormat format = new SimpleDateFormat(NORM_DATE_PATTERN);
            String firstDateAccuDayStr = format.format(firstDate);
            String secondDateAccuDayStr = format.format(secondDate);
            Date firstDateAccuDay = format.parse(firstDateAccuDayStr);
            Date secondDateAccuDay = format.parse(secondDateAccuDayStr);
            Calendar firstCalendar = Calendar.getInstance();
            firstCalendar.setTime(firstDateAccuDay);
            Calendar secondCalendar = Calendar.getInstance();
            secondCalendar.setTime(secondDateAccuDay);
            return firstCalendar.compareTo(secondCalendar);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
