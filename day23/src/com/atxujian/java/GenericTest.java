package com.atxujian.java;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author xujian
 * @create 2020-03-01 12:34
 */
/*
* 泛型的使用：j
* 1.dk5.0新增的特性
* 2.在集合中使用泛型
*    总结：
*    ①集合接口或集合类在jdk5.0时都修改为带泛型的结构
*    ②在实例化集合类时，可以指明具体的泛型类型
*    ③指明完后，在集合类或接口中凡是定义或接口时，内部结构（比如：方法，构造器）使用到泛型的位置，都指定为实例化时的泛型类型
*       比如：add(E e)---->实例化以后：add(Integer e)
*    ④注意点：泛型的类型必须是类，不能是基本数据类型，需要用到基本数据类型的位置，那包装类替换
*    ⑤如果实例化时，没有指明泛型的类型。默认为java.lang.Object类型
*
* 3.如何自定义泛型结构：泛型类，泛型接口，泛型方法
*
*
*
* */
public class GenericTest {
    @Test
    public void Test1(){
        //在集合中使用泛型的情况

        //后面尖括号内容可以省略
        //Map<String,Integer> map=new HashMap<String,Integer>();
        Map<String, Integer> map = new HashMap<>();

        map.put("Tom", 20);
        map.put("mm", 25);
        map.put("JJ", 29);

        //调用方法entrySet
        //因为Entry是Map的一个内部接口
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key+"---->"+value);
        }
    }
}
