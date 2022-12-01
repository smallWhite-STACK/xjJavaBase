package com.atxujian.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xujian
 * @create 2022-11-19 17:40
 */
public class Fish {
    @Test
    public void fishWang(){
        /*截止时间为t*/
        String t = "2020-09-08";
        String t0 = "1970-01-01";
        //计算总的天数
//        方法1：
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date time = simpleFormatter.parse(t);
            Date time0 = simpleFormatter.parse(t0);
            long l = (time.getTime() - time0.getTime())/(60*60*24*1000)+1;
//            System.out.println(l);
            if(l%5==0 | l%5==4){
                System.out.println(t+"今天晒网");
            }else{
                System.out.println(t+"今天打鱼");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
