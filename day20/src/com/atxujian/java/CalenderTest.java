package com.atxujian.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author xujian
 * @create 2020-02-17 19:32
 */
/*  格式化：日期->文本、
    解析：文本->日期
    */

//要求字符串使用构造器指定的格式，否则会报异常（java.text.ParseException）
public class CalenderTest {

//关于Calendar类
    //1.实例化：
    //方式一：由于Calendar是抽象类abstract所以要用它的一个子类来创建
    //方式二：用getInstance()方法
    /*2.常用方法
    * get()
    * set()
    * add()
    * getTime()
    * setTime()
    *
    * */
    @Test
    public void calendarTest1(){

        //方式一
        Calendar calendar=new GregorianCalendar();
        System.out.println(calendar);

        //方式二
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);
        System.out.println(instance.getClass());//class java.util.GregorianCalendar


        //常用方法
        //get()
        int days = instance.get(Calendar.DAY_OF_WEEK);
        System.out.println(days);//3
        System.out.println(instance.get(Calendar.DAY_OF_WEEK));//3
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));//18
        System.out.println(instance.get(Calendar.MONTH));//1

        //set()
        instance.set(Calendar.DAY_OF_MONTH,22);      //此时instance已经变了                      //意思是这个月的第22号
        int days1=instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(days1);//22

        //add
        instance.add(Calendar.DAY_OF_MONTH,-3);
        int day2=instance.get(Calendar.DAY_OF_MONTH);//由于instance在set()的地方已经变了
        System.out.println(day2);   //22-3=19

        //getTime    日历--》Date
        Date time = instance.getTime();
        System.out.println(time);  //Wed Feb 19 14:13:09 CST 2020

        //setTime   Date--》日历
        Date date = new Date();
        instance.setTime(date);//此时instance再次改变为当前的时间


        int i = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);   //18


    }
    @Test
    public void simpleDateFormatTest() throws ParseException{
//使用默认的SimpleDateFormat构造器:用默认的模式和默认语言环境的日期格式符号构造
        SimpleDateFormat format = new SimpleDateFormat();
    //格式化：日期-》文本
        Date date = new Date();//获取实时时间
        System.out.println(date);

        String time=format.format(date);
        System.out.println(time);//20-2-17 下午7:47
                                 //格式是年-月-日  上午/下午时间
    // 解析：文本-》时间
        String stime="20-2-17 下午7:47";
        Date parse = null;
        try {
            parse = format.parse(stime);
            //parse解析需要按照格式写 例如：20-2-17 下午7:47
        } catch (ParseException e) {
            e.printStackTrace();
        }
  //或者throws异常
        //未处理的异常: java.text.ParseException
        System.out.println(parse);

       // SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MMMMM.dd hh:mm:ss aaa");
        SimpleDateFormat format1 = new SimpleDateFormat("yy-MM-dd hh:mm:ss");//为啥不是24样式的时间
        String s = format1.format(date);
        System.out.println(s);

        Date date1 = null;
        date1 = format1.parse(s);
        System.out.println(date1);
    }



}
