package com.atxujian.javaSet;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author xujian
 * @create 2020-02-26 11:33
 */
/*
* TreeSet要求元素是同一类型，而且输出结果从小到大
*
* */
public class TreeSetTest {
    @Test
    //说明添加元素为同一类型

    public void test1(){
        TreeSet set = new TreeSet();

       /* set.add(123);
        set.add(new String("abc"));
        set.add(false);*/
   //add不同类型的元素，会报错
//java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String

        set.add(123);
        set.add(456);
        set.add(789);
        set.add(000);

        //迭代器
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    //由于没有重写Customer的Comparable接口的compareTo()方法，TreeSet不知如何去比较
    public void test2(){
        TreeSet set = new TreeSet();
        set.add(new Customer("Jack",20));
        set.add(new Customer("Monkey",60));
        set.add(new Customer("Lacuy",25));
        set.add(new Customer("Aen",46));
        set.add(new Customer("Ken",53));
        set.add(new Customer("Ken",52));

    Iterator iterator = set.iterator();
        while(iterator.hasNext()){
        System.out.println(iterator.next());
    }
}
}