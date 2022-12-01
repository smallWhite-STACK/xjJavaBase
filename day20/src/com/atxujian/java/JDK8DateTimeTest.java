package com.atxujian.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author xujian
 * @create 2020-02-18 14:40
 */

/*
*
* */
public class JDK8DateTimeTest {

    //1.偏移量
    @Test
    public void test1(){
        Date date = new Date(2020, 2, 18);//2020-2-18，星期二
        Date date1 = new Date(2020-1900, 2-1, 18);
        System.out.println(date);      //Thu Mar 18 00:00:00 CST 3920(3920-3-18  星期四)
        System.out.println(date1);     //Tue Feb 18 00:00:00 CST 2020(2020-2-18  星期二)
    }
    @Test
    public void test2(){
        //2.LocalDate、LocalTime、LocalDateTime的常用方法
       /* 这是错误的
       LocalDate localDate = new LocalDate();
        LocalTime localTime = new LocalTime();
        LocalDateTime localDateTime = new LocalDateTime();*/

        //now()获取当前时间三种形式
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);   //2020-02-18
        System.out.println(localTime);   //15:56:36.989
        System.out.println(localDateTime);  //2020-02-18T15:56:36.989

        //of()，指定时间
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 2, 18, 15, 58, 45);
        System.out.println(localDateTime1);  //2020-02-18T15:58:45

        //getXxx(),以localDateTime1为例
        int dayOfMonth = localDateTime1.getDayOfMonth();
        DayOfWeek dayOfWeek = localDateTime1.getDayOfWeek();
        System.out.println(dayOfMonth);     //18
        System.out.println(dayOfWeek);      //TUESDAY

        System.out.println(localDateTime1.getMonth());       //FEBRUARY
        System.out.println(localDateTime1.getMonthValue());  //2
        System.out.println(localDateTime1.getDayOfYear());    //49  (今年的第49天)

        //withXxx
        System.out.println(localDateTime1.withDayOfMonth(29));//将时间改为29号   2020-02-29T15:58:45
        System.out.println(localDateTime1.withHour(6));       //将小时改为6      2020-02-18T06:58:45

        //plus
        System.out.println(localDateTime1.plusYears(50));//加上五十年            2070-02-18T15:58:45
        System.out.println(localDateTime1.plusDays(365));//加上365天             2021-02-17T15:58:45

        //minus  减（省略）
        System.out.println(System.currentTimeMillis());
    }
        @Test
        //Instant

    public void test(){
        //1.实例化
            Instant instant =Instant.now();
            System.out.println(instant);   //输出：2020-02-18T09:11:48.255Z   但是现在时间为17：14，差8个小时
            //这是本初子午线的时间

            //得到东八区的时间atOffset
            OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
            System.out.println(offsetDateTime);  //2020-02-18T17:15:54.569+08:00

         //2.
            // 2.1返回毫秒数
            long l = instant.toEpochMilli();
            System.out.println(l);              //1582017521945



            //2.2将毫秒数转为日期Instant
            Instant instant1 = Instant.ofEpochMilli(l);
            System.out.println(instant1);       //2020-02-18T09:20:04.697Z
        }

         @Test
        //DateTimeFormatter:格式化或解析日期和时间，要么LocalDate、LocalTime、LocalDateTime,要么ofPattern自定义
        /*
         *  预定义的标准格式。如： ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
         *  本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
         *  自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
         * */
    public void test3(){
    //1.预定义的标准格式。如： ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
            //先实例化
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
                 //格式化  日期--》字符串
            LocalDateTime localDateTime = LocalDateTime.now();
             String format = formatter.format(localDateTime);
             System.out.println(localDateTime);  //2020-02-18T18:01:58.730
             System.out.println(format);         //2020-02-18   字符串

                   //解析  字符串--》日期
             TemporalAccessor parse = formatter.parse(format);
//因为LocalDate、LocalTime、LocalDateTime实现接口(interface)Temporal，而Temporal继承了TemporalAccessor类
             System.out.println(parse);    //{},ISO resolved to 2020-02-18


    /*2.本地化相关的格式。如：2.1适用于LocalDateTime
                            ofLocalizedDateTime(FormatStyle.LONG)
                           ofLocalizedDateTime(FormatStyle.SHORT)
                           ofLocalizedDateTime(FormatStyle.MEDIUM)
                           ofLocalizedDateTime(FormatStyle.FULL)

                           2.2适用于LocalDate
                           ofLocalizedDateTime(FormatStyle.LONG)
                           ofLocalizedDateTime(FormatStyle.SHORT)
                           ofLocalizedDateTime(FormatStyle.MEDIUM)

             */
              //先实例化,以LocalDateTime为例
             DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
             String format1 = formatter1.format(localDateTime);
             System.out.println(format1); //FULL:2020年2月18日 星期二  LONG:2020年2月18日   MEDIUM:2020-2-18  SHORT:20-2-18

             //以LocalDate为例
             DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
             LocalDate localDate = LocalDate.now();
             String format2 = formatter2.format(localDate);
             System.out.println(format2); // FULL:2020年2月18日 星期二   LONG:2020年2月18日  MEDIUM:2020-2-18  SHORT:20-2-18
                //解译省略

    //3.ofPattern()
             DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
             String format3 = formatter3.format(localDateTime);
             System.out.println(format3);    //yyyy-MM-dd hh:mm:ss  --> 2020-02-18 08:10:25

         }
}
