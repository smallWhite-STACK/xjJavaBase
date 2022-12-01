package com.atxujian.java;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author xujian
 * @create 2020-03-20 16:08
 *
 *
 * Lambda的一个入门
 */
public class LambdaTest {


    @Test
    public void test1(){

        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("I love China");
            }
        };

        r1.run();
        System.out.println("****************");

        Runnable r2 =() ->System.out.println("我爱中国");
        r2.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare = com1.compare(12, 23);
        System.out.println(compare);

        System.out.println("****************");
//Lambda表达式的写法
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);
        int compare1 = com2.compare(45, 12);
        System.out.println(compare1);

        System.out.println("****************");


        //方法引用
        Comparator<Integer> com3=Integer::compare;
        int compare2 = com3.compare(79, 45);
        System.out.println(compare2);
    }

}
