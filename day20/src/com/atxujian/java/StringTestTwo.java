package com.atxujian.java;

//import com.sun.org.apache.xpath.internal.operations.String;
//此包导入后关于String 的定义报错
//错误:(26, 20) java: 不兼容的类型: java.lang.String无法转换为com.sun.org.apache.xpath.internal.operations.String
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author xujian
 * @create 2020-02-13 19:36
 */
//String与其他结构的转换

public class StringTestTwo {

    @Test
    public void test2(){

    }


    //String与byte[]的转换,使用方法getBytes()、Arrays.toString()
    @Test
    /*
    *编码：String到byte[]
    * 解码：byte[]到String
    * 编码解码过程一定记得用同一种字符集，负责会出现乱码
    * */
    public void test() throws UnsupportedEncodingException {

        //String》》byte[]
        String str="123abc徐健";
        byte[] bytes=str.getBytes();//默认的字符集进行转换UTF-8
        System.out.println(bytes);           //[B@22927a81
        System.out.println(bytes.toString());//[B@22927a81
        System.out.println(Arrays.toString(bytes));//[49, 50, 51, 97, 98, 99]
        //[49, 50, 51, 97, 98, 99, -27, -66, -112, -27, -127, -91]  汉字占三个字符


        byte[] gbk=str.getBytes("gbk");//使用gbk字符集进行编码
        System.out.println(Arrays.toString(gbk));
        //[49, 50, 51, 97, 98, 99, -48, -20, -67, -95]  汉字占两个字符
        System.out.println("***********************");
        //byte[]到String,还是构造器。
        String s = new String(bytes);
        System.out.println(s);
        String s1 = new String(gbk);
        System.out.println(s1);//123abc�콡    由于UTF-8与gbk，所以乱码
        System.out.println("*******************解决乱码");
        //输入原有的
        String gbks = new String(gbk, "gbk");
        System.out.println(gbks);

    }
}
