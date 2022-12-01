package com.atxujian.java;

import org.junit.Test;

import java.util.Date;


/**
 * @author xujian
 * @create 2020-02-14 18:11
 */
/*
* 1.两个构造器    2.两个方法
* 3.两个包的Data
* */
public class DateTest {



    @Test
//构造器 与两个方法（toString与getTime）
    public void test1(){
    //构造器1：Date()
        //Alt+Enter导入类
        Date date = new Date();
        String s = date.toString();//年月日时分秒    Fri Feb 14 18:20:15 CST 2020      (CST中央标准时间)
        System.out.println(s);
        long time = date.getTime();//时间戳          1581675615456
        System.out.println(time);
    //构造器2：Date(数字)
        Date date1 = new Date(1581675615456l);
        String s1 = date1.toString();
        System.out.println(s1);
//java.util.Date与java.sql.Date的转换

        java.sql.Date date3 = new java.sql.Date(12345615266l);
        System.out.println(date3);   //1970-05-24  只输出年月日
   // java.util.Date-->java.sql.Date
        //情况一：多态
        Date date2 = new java.sql.Date(125825262225552525l);
        java.sql.Date date21 = (java.sql.Date) date2;
        System.out.println(date21);
        //情况二 需要getTime()方法
        Date date4 = new Date(1581675615456l);
        /*java.sql.Date date41 = (java.sql.Date) date4;
        System.out.println(date41);//报错：java.lang.ClassCastException: java.util.Date cannot be cast to java.sql.Date
        */
        System.out.println("date4 "+date4);//date4 Fri Feb 14 18:20:15 CST 2020
        java.sql.Date date5 = new java.sql.Date(date4.getTime());
        System.out.println(date5);  //2020-02-14   注意date4到date5日期没有时分秒了，但是并不代表它不能表示，只是没有表示
    //java.sql.Date-->java.util.Date
        java.sql.Date date6 = new java.sql.Date(1581675615456l);
        Date date61 = (Date) date6;
        System.out.println(date61);//2020-02-14
    }
}
