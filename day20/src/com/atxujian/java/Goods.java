package com.atxujian.java;

/**
 * @author xujian
 * @create 2020-02-19 11:52
 */

//自定义类，并且继承Comparable接口，重写toString方法
public class Goods implements Comparable{
    private String name;
    private double price;
    //构造器


    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public String  getName(){return name;}
    public double getPrice(){return price;}
    @Override
    public String toString() {
        String str="商品" +"：名字是 "+
                name + '\'' +
                ",价钱是 " + price +
                '}';
        return str;

    }

    @Override
    public int compareTo(Object o) {
        //instanceOf是看对象是否属于某一类
        if(o instanceof  Goods){
                //将o转换为Goods类型
            Goods goods=(Goods) o;
            //方式一
         /*   if(this.price>goods.price){
                return 1;
            }else if(this.price<goods.price){
                return -1;
            }else if(this.price==goods.price){
 //               return 0;
                //万一价钱相同，这时候就用名字来决定谁先谁后
  //              return  this.name.compareTo(goods.name);//名字从小到大
                return  -this.name.compareTo(goods.name);//名字从大到小
                }*/

                //方式二
           return Double.compare(this.price,goods.price);
            }
            //如果不是商品的处理方法
//            return 0;
        throw new RuntimeException("传入的数据类型不一致，不是商品");
        }
    }

