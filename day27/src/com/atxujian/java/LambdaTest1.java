package com.atxujian.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author xujian
 * @create 2020-03-20 17:01
 *
 *
 * Lambda表达式的使用
 *
 * 1.举例：（o1,o2）->Integer.compare(o1,o2)
 *2.格式：
 *      ->:Lambda操作符  或  箭头操作符
 *      ->左边：Lambda形参列表（其实就是接口中的抽象方法的形参列表）
 *      ->右边：Lambda体（其实就是重写的抽象方法的方法体）
 *
 * 3.Lambda的使用：分为六种情况
 *
 *         总结：
 *         ->左边：Lambda形参列表的参数类型可以省略（类型推断）；如果Lambda形参列表只有一个参数，则括号也可以省略
 *         ->右边：Lambda体应该使用一对{}包裹；如果Lambda体只有一条执行语句（可能是return语句，可以省略这一对{}和return关键字）
 *
 *
 * 4.Lambda的本质：在Java中作为函数式接口的实例
 *
 *5.@FunctionalInterface（注解加不加都可以但加上可以验证）
 *      函数式接口：在Java8中，Lambda表达式就是一个函数式接口的实例。
 *      这就是 Lambda表达式和函数式接口的关系。也就是说，只要一个对象是
 *      函数式接口 的实例，那么该对象就可以用Lambda表达式来表示。
 *  所以以前用匿名实现类表示的现在都可以用Lambda表达式来写
 */

public class LambdaTest1 {
    //语法一：无参，无返回值    ----》详见LambdaTest1
    //语法二：Lambda需要一个参数，但是没有返回值
    @Test
    public void test1(){
        //以Consumer接口为例
        //一般形式
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("我爱中国");

        //Lambda形式
        Consumer<String> consumer2=(s) -> System.out.println(s);
        consumer2.accept("加油，武汉");
    }

    //数据类型可以省略，因为可以有编译器推断得出，成为“类型推断”
    @Test
    public void test3(){
//Lambda形式
        Consumer<String> consumer2=(s) -> { System.out.println(s);};
        consumer2.accept("加油，武汉");

        //我们见过类型推断的东西
        ArrayList<Object> objects = new ArrayList<>();
        int[] ints = new int[]{1,2,3};//d等同于
        int[] ints1 = {1, 2, 3};
    }

    //语法格式四：Lambdau若只需要一个参数时，参数的小括号可以省略
@Test
    public void test4(){
//Lambda形式
    Consumer<String> consumer2=s -> { System.out.println(s);};
    consumer2.accept("加油，武汉");
}

    //语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
@Test
    public void test5(){
    //一般形式
    Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1, o2);
        }
    };
    System.out.println(comparator.compare(45, 56));

    System.out.println("********************");
    //Lambda形式
    Comparator<Integer> comparator2=(o1,o2) -> {
        System.out.println(o1);
        System.out.println(o2);
        return Integer.compare(o1, o2);
    };
    System.out.println(comparator.compare(12, 0));

}

//语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
    @Test
    public void test6(){
       Comparator<Integer> comparator1=(o1,o2) -> {
           return o1.compareTo(o2);
       };
        //Comparator<Integer> comparator1=(o1,o2) ->o1.compareTo(o2);
        int compare = comparator1.compare(12, 23);
        System.out.println(compare);
    }

}
