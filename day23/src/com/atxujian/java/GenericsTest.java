package com.atxujian.java;

import org.junit.Test;

import java.util.List;

/**
 * @author xujian
 * @create 2020-03-01 17:41
 */
/*
*
* 如果定义了泛型类，实例化没有指明类的泛型，则默认此泛型为Object类型
* 要求：如果定义了类是泛型的，建议实例化时要指明类的泛型
* */
public class GenericsTest {
    @Test
    public void test(){
        //此时实例化没有指明泛型
        Goods goods = new Goods();
        goods.setGoodsT(123);
        goods.setGoodsT("abc");

        //指明泛型
        //无参数
        Goods<String> tgoods=new Goods<String>();
       // tgoods.setGoodsT(123);    已经指明为String
        tgoods.setGoodsT("abc");

        //有参数
        Goods<String> tgoods1=new Goods<String>("Apple",25,"Nice");
        tgoods1.setGoodsT("Origial");
        System.out.println(tgoods1);
    }

    @Test
    public void test2(){
        //继承的类---》不是泛型类
        //实例化
        SubGoods subGoods = new SubGoods();
        //用set，由于子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不再需要指明泛型
        subGoods.setGoodsT(123);
        System.out.println(subGoods);
    }

    @Test
    public void test3(){
        //继承的类---》是泛型类
        SubGoods1<Integer> subGoods1 = new SubGoods1<>();
        subGoods1.setGoodsT(123);
        System.out.println(subGoods1);
    }

    @Test
    public void test4(){
        SubGoods subGoods = new SubGoods();
        Integer[] arr=new Integer[]{1,2,3,4};
        List<Integer> integers = subGoods.copyFromArrayToList(arr);
        System.out.println(integers);
    }
}
