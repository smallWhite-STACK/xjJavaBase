package com.atxujian.java;

import org.junit.Test;

import java.lang.annotation.ElementType;

/**
 * @author xujian
 * @create 2020-03-18 14:56
 */
public class ReflectionTest {

    //1.如何获取一个Class的对象（三种方式）

    @Test
    public void test() throws ClassNotFoundException {
        //方式一:调用运行时类的属性
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        //方式二：通过运行时类的对象，调用getClass方法
        Person person = new Person();
        Class<? extends Person> personClass1 = person.getClass();
        System.out.println(personClass1);

        //方式三：调用Class的静态方法forName(String classPath)
        Class personClass2 = Class.forName("com.atxujian.java.Person");
        Class<?> aClass2 = Class.forName("java.lang.String");
        System.out.println(personClass2);
        System.out.println(aClass2);

        //比较personClass  personClass1 personClass2三者之间的关系
        System.out.println(personClass==personClass2);     //true
        System.out.println(personClass==personClass1);     //true


        //方式四
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class personClass3 = classLoader.loadClass("com.atxujian.java.Person");
        System.out.println(personClass3);

        System.out.println(personClass1==personClass3);   //true

    }

    @Test
    public void test1(){
        Class c1 = Object.class;
        System.out.println(c1);  //class java.lang.Object
        Class c2 = Comparable.class; System.out.println(c2);//interface java.lang.Comparable
        Class c3 = String[].class; System.out.println(c3);//class [Ljava.lang.String;
        Class c4 = int[][].class; System.out.println(c4);//class [[I
        Class c5 = ElementType.class; System.out.println(c5);//class java.lang.annotation.ElementType
        Class c6 = Override.class; System.out.println(c6);//interface java.lang.Override
        Class c7 = int.class; System.out.println(c7);//int
        Class c8 = void.class; System.out.println(c8);//void
        Class c9 = Class.class;System.out.println(c9);//class java.lang.Class
        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要元素类型与维度一样，就是同一个Class System.out.println(c10 == c11);
        System.out.println(c10==c11);   ///true
    }

    static int i=100;

    @Test
    public void test2(){
        System.out.println(i);
         i=10;
        System.out.println(i);
    }

}
