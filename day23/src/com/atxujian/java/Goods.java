package com.atxujian.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xujian
 * @create 2020-03-01 17:42
 */
public class Goods<T>{
    private String name;
    private double price;

    T goodsT;

    public Goods() {
    }

    public Goods(String name, double price, T goodsT) {
        this.name = name;
        this.price = price;
        this.goodsT = goodsT;
    }
//这些不是泛型方法
    public T getGoodsT() {
        return goodsT;
    }

    public void setGoodsT(T goodsT) {
        this.goodsT = goodsT;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", goodsT=" + goodsT +
                '}';
    }
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e:arr){
            list.add(e);
        }
        return list;
    }
}
