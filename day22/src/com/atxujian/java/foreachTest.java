package com.atxujian.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author xujian
 * @create 2020-02-24 21:56
 */
//jdk5.0新增了foreach循环，用于遍历集合、数组
public class foreachTest {

    public static void main(String[] args) {
        Collection coll=new ArrayList();
        coll.add(false);
        coll.add(new Person("Monkey",10));
        coll.add(123);
        coll.add("ac");
        coll.add(new String("abc"));
        coll.add("ac");

        //for(集合元素的类型  局部变量 ：集合对象)
        //源码中内部依然是调用了迭代器
        for (Object obj:coll){
            System.out.println(obj);
        }
    }


    @Test
    public void test1(){
        //搞一个int型的数组
        int[]number=new int[]{123,456,789};
        for(int i: number){
            System.out.println(i);
        }
    }
    @Test
    public void test2(){
        String[]str=new String[]{"123","456","789"};
        for (int i = 0; i <str.length ; i++) {
            str[i]="abc";
        }
        for (int i = 0; i <str.length ; i++) {
            System.out.println(str[i]);
        }
    }

    @Test
    public void test3(){
        String[]str=new String[]{"123","456","789"};
        for(String s:str){
            s="abc";
        }


        for (int i = 0; i <str.length ; i++) {
            System.out.println(str[i]);
        }
    }
}
