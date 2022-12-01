package com.atxujian.java;

import org.junit.Test;

/**
 * @author xujian
 * @create 2020-02-14 16:59
 */
//字符串;关于null的一个例子


public class StringInterviewTwo  {
    @Test
    public void test()  {
        String str = null; //null不占内存，为空，不是对象
        StringBuffer sb = new StringBuffer();

        System.out.println(str);      //null
        System.out.println(sb);       //空字符串，但是是对象，占内存
        sb.append(str);//调用StringBuffer的方法append
        System.out.println(sb.length());//4
        System.out.println(sb);    //null(本来占内存了，现在不占了)

        /*StringBuffer sb1 = new StringBuffer(str);//str本来就不占内存，好比又创建了一个不占内存的StringBuffer
        System.out.println(sb1);//不占内存，报错*/

        //StringBuffer sb2 = new StringBuffer(null);
        // System.out.println(sb2);
    }
}
