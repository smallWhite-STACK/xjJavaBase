package com.atxujian.java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author xujian
 * @create 2020-02-20 18:16
 */
/*
*
* 测试：System类
*       Math类
*       BigInter类与BigDecimal类
* */
public class TestMath {

    @Test
    public void test(){
        //System类
        /*
        * java.version
        * java.home
        * os.name
        * os.version
        * user.name
        * user,home  用户的主目录
        * user.dir
        * */
        String javaVersion=System.getProperty("java.version");
        System.out.println(javaVersion);         //1.8.0_131
        String javaHome=System.getProperty("java.home");
        System.out.println(javaHome);            //E:\Java\jre
        String osName=System.getProperty("os.name");
        System.out.println(osName);              //Windows 10
        String osVersion=System.getProperty("os.version");
        System.out.println(osVersion);           //10.0
        String userName=System.getProperty("user.name");
        System.out.println(userName);            //dell
        String userHome=System.getProperty("user.home");
        System.out.println(userHome);            //C:\Users\dell
        String userDir=System.getProperty("user.dir");
        System.out.println(userDir);             //D:\UserIntellijIDEA\IdeaProjectsAnd\day20
    }
    @Test
    public void test2(){
        BigInteger big1 = new BigInteger("12345678945115525522255");
        BigDecimal big2 = new BigDecimal(7);
        BigDecimal big3 = new BigDecimal(3);
        System.out.println(big2.divide(big3,BigDecimal.ROUND_HALF_UP));
        System.out.println(big2.divide(big3,25,BigDecimal.ROUND_HALF_UP));   //25是指定的小数点后保留几位
    }

}
