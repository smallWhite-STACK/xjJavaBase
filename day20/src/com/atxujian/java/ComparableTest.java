package com.atxujian.java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;


/*
* 一，说明：Java中的对象，正常情况下，只能进行==或!=。不能使用< 或 >
*           但在开发场景中，我们需要对多个对象进行排序，言外之意，就需要
*           比较对象的大小，
*           如何实现？使用两个接口中的任何一个：Comparable或Comparator
*
* 二.Comparable接口的使用
*
* */
/**
 * @author xujian
 * @create 2020-02-19 10:55
 */


public class ComparableTest {
    /*
    * Comparable接口的使用实例：
    * 1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出两个比较对象
    * 2.像String、包装类重写了compareTo(obj)方法,就实现了从小到大的排列
    * 3.重写compareTo(obj)的规则：
    *       如果当前对象this大于形参对象obj，则返回正整数
    *       如果当前对象this等于形参对象obj，则返回零
    *       如果当前对象this小于形参对象obj，则返回负整数
    *4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，并重写compareTo()
    * 方法，在compareTo()方法中指明如何排序（比如在购物是按照价格、评论、好评数排序）
    * */
    @Test
    public void test1(){
        String []str={"kk","gg","jj","mm","dd"};
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));   //[dd, gg, jj, kk, mm]
    }


    @Test
    //这里我们创建了一个Good商品类，用来当作自定义类

    public void test2(){
        Goods[] goods = new Goods[5];//指定长度,这里面的每一个数组对象都是一个商品
        //开始商品初始化
        goods[0]=new Goods("oppo",3200);
        goods[1]=new Goods("xiaomi",3999);
        goods[2]=new Goods("vivo",4000);
        goods[3]=new Goods("huawei",6600);
        goods[4]=new Goods("meizu",3200);
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }


    @Test
    //这里我们说明Comparator
    public void test3(){
        Goods[] goods = new Goods[5];
        goods[0]=new Goods("羊",123);
        goods[1]=new Goods("猪",1000);
        goods[2]=new Goods("牛",190);
        goods[3]=new Goods("鸡",300);
        goods[4]=new Goods("鸭",600);

        //对goods的对象排序
        Arrays.sort(goods, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //先判断对象是否为商品
                if(o1 instanceof Goods && o2 instanceof Goods){
                    //将o1与o2 强转为Goods
                    Goods goods1=(Goods) o1;
                    Goods goods2=(Goods) o2;
                    //按价钱由低到高排列，
                    if(goods1.getPrice()==goods2.getPrice()){
                        //此处调用的compareTo是Comparable中的compareTo
                        return goods1.getName().compareTo(goods2.getName());

                    }else{
                        return Double.compare(goods1.getPrice(),goods2.getPrice());
                    }
                }
                //return 0;
                throw new RuntimeException("你属入的不是商品");
            }
        });
        System.out.println(Arrays.toString(goods));
    }


    @Test
    public void test4(){
        String[] s = new String[]{"KK","AA","ZZ","RR"};
//        System.out.println(Arrays.toString(s));
        Arrays.sort(s, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String & o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    //从大到小
                    return -s1.compareTo(s2);

                }
                throw new RuntimeException("数据类型出错");
            }
        });
        System.out.println(Arrays.toString(s));
    }
    @Test
    public void testBigInteger() {
        BigInteger bi = new BigInteger("12433241123");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);  //12433241123
        System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));  //1130.486
        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));  //1130.486454545454545
    }
    public static void main(String[] args) {
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);
        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);
        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);
        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);
        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);
        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);
        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);
//        java的version:1.8.0_131
//        java的home:C:\Program Files\Java\jdk1.8.0_131\jre
//        os的name:
//        Windows 10
//        os的version:10.0
//        user的name:dell
//        user的home:C:\Users\dell
//        user的dir:D:\UserIntellijIDEA\IdeaProjectsAnd
    }
}
