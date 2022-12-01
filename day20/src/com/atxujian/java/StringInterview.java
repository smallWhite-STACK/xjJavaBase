package com.atxujian.java;

/**
 * @author xujian
 * @create 2020-02-13 11:23
 */

/*面试题*/
public class StringInterview {
    String str = new String("good");
    char [] one={'t','e','s','t'};

    public void repair(String str,char one[]){
        str="test";
        one[0]='b';
//基本数据类型传递的是存储的数据，引用数据类型传递的是地址值
    }
    public static void main(String[] args) {
        StringInterview s = new StringInterview();
        s.repair(s.str,s.one);
        System.out.println(s.str);//good
        System.out.println(s.one);//best
    }
}
