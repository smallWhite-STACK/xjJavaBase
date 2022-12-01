package com.atxujian.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author xujian
 * @create 2020-03-01 20:21
 */
public class GenericTest {
    /*
    * 1.java在继承方面的体现
    *多态性：类A是类B的父类，G<A>和G<B>二者不具备子父类关系，二者是并列关系
    * 2.通配符的使用
    * */
    @Test
    public void test1(){
        //多态性
        Object o1=123;
        String str1="abc";
        o1=str1;
        System.out.println(o1);

        Object[] o=null;
        String[] str={"123","456"};
        o=str;
        System.out.println(Arrays.toString(o));
    }

    @Test
    public void test2(){
        List<Object> list1=null;
        List<String> list2=new ArrayList<String>();

        //将list2赋给list1是错的，
        //编译不通过
        //list1=list2;
        show(list2);
       // show(list1);编译不通过
        show1(list1);

        show2(list1);
        show2(list2);
    }
    public void show(List<String > list){
    }
    public void show1(List<Object> list){
    }

    public <T>  void show2(List<T> list){}


    /*通配符的使用
        通配符：？

        1.类A是类B 的父类，G<A>与G<B>是没有关系的，二者的共同父类是G<?>

        2.1添加（写入）：对于List<?>就  不能  向其内部添加数据，
                除了添加null之外
        2.2获取（读取）：允许读取数据，输出的数据类型为Object

        3.有限制条件的通配符
     * */

   @Test
    public void test4(){
       List<Object> list1=null;//1
       List<String> list2=null;//2
//由于1与2之间没有子父类的关系，所以不满足多态性，所以输出时要写两重载的函数
       List<?> list=null;


       list=list1;
       list=list2;

       //print(list1);
      // print(list2);

       ArrayList<String> list3 = new ArrayList<>();
       list3.add("456");
       list3.add("789");

      // list.add("123");  对于List<?>就  不能  向其内部添加数据，
       list=list3;
       //获取,可以读取数据，而且输出为Objecct
       Object o = list.get(0);
       System.out.println(o);
   }
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }
    }
    /*
         3.有限制条件的通配符
         （儿子 ----》  父亲）
             ? extends A:   《=
             ? super A：     》=
                     G<? extends A>意思是：？继承于A
                     G<? super A>意思是：A继承于？
         */
    @Test
    public void test5(){
        List<? extends Person> l=null;
        List<? super Person> li=null;

        List<Person> list1=new ArrayList<Person>();
        List<Student> list2=new ArrayList<Student>();
        List<Object> list3=new ArrayList<Object>();

        l=list1;
        l=list2;
       // l=list3;   说明子类可以赋给l中

        li=list1;
        //li=list2;
        li=list3;

 //读取数据

        //说明：<? extends Person>  范围：【负无穷（儿子），person】
        l=list1;
        Person person = l.get(0);  //   extends  注意get后的只能是person

       // <? super Person>
        li=list3;
        //super get()的只能是person 的父类
        //Person person11 = li.get(0);  编译不通过
        Object obj=l.get(0);



 //写入数据
        //对于<? extends Person>   不能写入
       // l.add(new Person());  编译不通过

        //<? super Person>   只可以写入【子类  person】
    }



}
