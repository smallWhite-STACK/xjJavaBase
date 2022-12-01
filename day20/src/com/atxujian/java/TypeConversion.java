package com.atxujian.java;

import org.junit.Test;

/**
 * @author xujian
 * @create 2020-02-13 15:11
 */
//char[]与String间的转换
public class TypeConversion {

    @Test
    public void test(){

        /*
        * char[]》》String,直接调用String的构造器
        * String》》char[],需要toCharArray
        * */
        char[] chars = {'h', 'e', 'l','l', 'o'};
        String s = new String(chars);
        System.out.println(s);

        String s1 = new String("HELLO");
        char []array=s1.toCharArray();
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }
        System.out.println(array);
    }
}
