package com.atxujian.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author xujian
 * @create 2020-02-24 17:20
 */
/*
*
* 关于迭代器的描述
* 我们不会采用单一的利用next()去迭代，或者for循环(Test1与Test2)
* 我们结合hasNext()于next()方法
*
* Test3与Test4是两种错误的写法
*
* */
public class IteratorTest {

    public static void main(String[] args) {
        //初始化，调用方法：iterator
        Collection coll=new ArrayList();
        coll.add(false);
        coll.add(new Person());
        coll.add(123);
        coll.add("ac");
        coll.add(new String("abc"));

        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){   //hasNext()判断是否还有下一个元素
            //next()：①指针下移，②将下移以后集合位置上的的元素返回
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test(){
        Collection coll=new ArrayList();
        coll.add(false);
        coll.add(new Person());
        coll.add(123);
        coll.add("ac");
        coll.add(new String("abc"));

        Iterator iterator = coll.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());//coll中只有五个元素，所欲此时已经完全输出完毕

        //多写输出语句会报异常，java.util.NoSuchElementException
        System.out.println(iterator.next());

    }

    @Test
    public void test2(){
        Collection coll=new ArrayList();
        coll.add(false);
        coll.add(new Person());
        coll.add(123);
        coll.add("ac");
        coll.add(new String("abc"));

        Iterator iterator = coll.iterator();
        for (int i = 0; i <coll.size() ; i++) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3(){
        Collection coll=new ArrayList();
        coll.add(false);
        coll.add(new Person());
        coll.add(123);
        coll.add("ac");
        coll.add(new String("abc"));
        coll.add("ac");

        Iterator iterator = coll.iterator();
        while(iterator.next()!=null){
            System.out.println(iterator.next());
            //结果为
         /*    Person{name='null', age=0}
               ac
               并且伴随异常NoSuchElementException
         */
        }
    }

    @Test
    //
    public void test4(){
        Collection coll=new ArrayList();
        coll.add(false);
        coll.add(new Person());
        coll.add(123);
        coll.add("ac");
        coll.add(new String("abc"));
        coll.add("ac");

        //我们直接在while中建造迭代器对象
        while(coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }

        //结果会是一直都是false
    }

    @Test
    public void test5(){
        Collection coll=new ArrayList();
        coll.add(false);
        coll.add(new Person("Monkey",10));
        coll.add(123);
        coll.add("ac");
        coll.add(new String("abc"));
        coll.add("ac");

        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            if(new Person("Monkey",10).equals(next)){
                iterator.remove();
            }
        }

        //由于iterator第一次遍历已经到最底下了，需要重新写一个迭代器从头开始
        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
