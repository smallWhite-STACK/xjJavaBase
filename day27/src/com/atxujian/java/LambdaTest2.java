package com.atxujian.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author xujian
 * @create 2020-03-20 19:45
 *
 *
 * JAVA内置4大核心函数式接口(基本的)
 *
 * 消费型接口：Consumer<T>     void accept(T t)
 * 供给型接口：Supplier<T>     T  get()
 * 函数型接口：Function<T,R>   R apply(T t)
 * 断定型接口：Predicate<T>      boolean test(T t)
 */
public class LambdaTest2 {

    @Test
    public void test1(){
        happytime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("我有钱，走，消费,买瓶"+aDouble+"价位的水");
            }
        });

        System.out.println("*************************");
        //使用Lambda表达式
        happytime(500, adouble ->      //这个adouble代表的使acceptde形参
                System.out.println("这里的comsumer只是一个定义的Consumer的对象"+adouble));
    }

    public void happytime(double money, Consumer<Double> con){
        con.accept(money);
    }

@Test
    public void test2(){
    List<String> list = Arrays.asList("北京", "天津", "上海", "南京","南海");
    List filterlist = filterString(list, new Predicate<String>() {
        @Override
        public boolean test(String s) {
            return s.contains("海");
        }
    });
    System.out.println("********************************");
    //使用Lambda表达式
    filterString(list, s -> s.contains("京"));


    //遍历
    System.out.println(filterlist);
    for (Object o:filterlist){
        System.out.println(o);
    }
}
//根据给定的规则，过滤集合中的字符串，此规则由Predicate的方法决定
    public List filterString(List<String> list, Predicate<String> pre){
        List<String> filterlist = new ArrayList();
        for(String s:list){
            if(pre.test(s)){
                filterlist.add(s);
            }
        }
        return filterlist;

    }




}
