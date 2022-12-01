package com.atxujian.java;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @author xujian
 * @create 2020-02-21 13:48
 */
public class Excepience {
    @Test
    public void test() throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date= format.parse("2017-08-16");
        java.sql.Date date2=new java.sql.Date(date.getTime());
        System.out.println(date);              //Wed Aug 16 00:00:00 CST 2017

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        TemporalAccessor parse = formatter.parse("2017-08-16");
       // System.out.println(parse);



    }}
