package com.atxujian.practice;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author xujian
 * @create 2020-02-17 13:26
 */
/*获取两个字符串中最大相同子串
* 例如：获取abcaadada与ageybabcabbac中最大相同的子串
* */
/*java常用类二第七集
* */
//前提：只有一个
public class TestStringFive {
    public String getMaxSameString(String str1,String str2){
        //确定两个字符串长度大小

        int i1=str1.length();
        int i2=str2.length();
        String minStr=(i1>+i2)?str2:str1;
        String maxStr=(i1>i2)?str1:str2;
        //使用长度短的字符串去匹配长的字符串
        //因为操作时就是从代码最长开始的，所以确保输出的就是相同的最长的
        int i3=minStr.length();
        for (int i = 0; i <i3 ; i++) {
            for (int x=0,y=i3-i;y<=i3;x++,y++){
                String temp=minStr.substring(x,y);
                if (maxStr.contains(temp)){
                    return temp;
                }
            }
        }
        return null;
    }

    @Test
    public void test(){
        String str1="abHDENJJjjjik";
        String str2="abcdefghyhjujikhjujjjjj";
        String end=getMaxSameString(str1,str2);
        System.out.println(end);
    }
    @Test
    public void test1(){
        StringBuffer builder = new StringBuffer("agg,chicken,baby,hello,xujian,");
        String[] str=builder.toString().replaceAll(",$","").split("\\,");
        System.out.println(Arrays.toString(str));
    }



}
