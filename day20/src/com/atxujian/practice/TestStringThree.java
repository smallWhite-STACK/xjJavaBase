package com.atxujian.practice;

import java.util.Scanner;

/**
 * @author xujian
 * @create 2020-02-15 17:14
 */
/*
* 4.编写一个Java应用程序，从键盘读取用户输入两个字符串，
* 并重载3个函数分别实现这两个字符串的拼接、整数相加和浮点数相加。
* 要进行异常处理，对输入的不符合要求的字符串提示给用户，不能使程序崩溃。*/

//重载函数名一样，形参不一样


public class TestStringThree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个字符串");
        String str1 = sc.nextLine();
        System.out.println(str1);
        System.out.println("请输入第二个字符串");
        String str2 = sc.nextLine();
        System.out.println(str2);

        int i1=Integer.parseInt(str1);
        int i2=Integer.parseInt(str2);

        float f1=Float.parseFloat(str1);
        float f2=Float.parseFloat(str2);

        TestStringThree three = new TestStringThree();
        System.out.println(three.strAdd1(str1,str2));
        System.out.println(three.strAdd1(i1,i2));
        System.out.println(three.strAdd1(f1,f2));
    }

    static String strAdd1(String str1, String str2) {
        return str1 + str2;
    }

    static String strAdd1(int i1,int i2) {
        //调用valueOf(),将int、float型转换为String型

            return String.valueOf(i1+i2);
    }
    static String strAdd1(float f1,float f2){
        //valueOf()
        return String.valueOf(f1+f2);
    }
}

