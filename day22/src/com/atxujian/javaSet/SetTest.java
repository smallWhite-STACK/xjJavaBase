package com.atxujian.javaSet;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author xujian
 * @create 2020-02-25 16:41
 */
/*
* Set:存储无序的，不可重复的数据
* 1.无序性
*
* 2.不可重复性
*
* 此时Jack这个本应该相同的应该满足不重复性出现一次，但是出现了两次，
当重写完Customer中的hashCode与equals()后，重复消失，说明
Customer中原本的继承的Object的hashCode是一个随即得哈希值，无特定的运算
* */

public class SetTest {
@Test
    public void test1(){
        Set set = new HashSet();
        set.add(123);
        set.add(new String("abc"));
        set.add(false);
        set.add(null);
        set.add(new Customer("Jack",20));
        set.add(new Customer("Jack",20));

    //利用forech循环
    for(Object obj:set){
        System.out.println(obj);
    }
    System.out.println();
    //或者迭代器
    Iterator iterator = set.iterator();
    while(iterator.hasNext()){
        System.out.println(iterator.next());
    }
    /*null
    abc
    Customer{name='Jack', age=20}
    false
    Customer{name='Jack', age=20}
    123*/

    //重写完hashCode()与equals()方法后
    /*null
    abc
    false
    Customer{name='Jack', age=20}
    123*/


    //此时Jack这个本应该相同的应该满足不重复性出现一次，但是出现了两次，
    //当重写完Customer中的hashCode与equals()后，重复消失，说明
    //Customer中原本的继承的Object的hashCode是一个随即得哈希值，无特定的运算
}

@Test
//LinkedHashSet()类
  //------注意输出顺序：与add的顺序一样，
    public void test2(){
    Set set = new LinkedHashSet();
    set.add(123);
    set.add(new String("abc"));
    set.add(false);
    set.add(null);
    set.add(new Customer("Jack",20));
    set.add(new Customer("Jack",20));

    Iterator iterator = set.iterator();
    while(iterator.hasNext()){
        System.out.println(iterator.next());
    }
//输出结果
    /*123
    abc
    false
    null
    Customer{name='Jack', age=20}*/
}

}
