package com.atxujian.java;

import org.junit.Test;

import java.util.*;

/**
 * @author xujian
 * @create 2020-02-24 10:26
 */
/*
Collection接口中常用的方法  15个(五个方法一组)
add()   addAll()   size()   clear()   isEmpty()
contains()   containsAll()   remove()   removeAll()  toArray()
retainAll()   hashCode()    equals()
结论：：
向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals()
* */
public class CollectionTest {
    @Test
    public  void test10() {
        HashSet set = new HashSet();
        Person p1 = new Person("AA",1001);
        Person p2 = new Person("BB",1002);
        set.add(p1);
        set.add(p2);
        p1.setName("CC");
        System.out.println(set.size());
        set.remove(p1);
        System.out.println(set);
        System.out.println(set.size());
        System.out.println();
        set.add(new Person("CC",1001));
        System.out.println(set);
        System.out.println();
        set.add(new Person("AA",1001));
        System.out.println(set);
    }

    @Test
    public void test1(){
        Collection coll=new ArrayList();

        //add(Object e)将元素e添加到集合coll中
        coll.add("aa");
        coll.add("AA");
        coll.add(new Date());
        coll.add(123);

        //size():获取添加的元素的有效个数
        System.out.println(coll.size());


        //addAll():将指定集合中的所有元素添加到此集合
    Collection coll1=new ArrayList();

        coll1.add("ss");
        coll1.add("aaa");
        coll1.add("cc");
        coll1.add(456);
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);

        //isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());    //false

        //clear()：清空
        coll.clear();
        System.out.println(coll.isEmpty());   //true
    }
    @Test
    public void test2(){
        Collection coll=new ArrayList();
        Person person = new Person("徐健", 20);
        coll.add("aa");
        coll.add(new String("xujian"));
        coll.add(new Date());
        coll.add(123);
        coll.add(new Person("徐健",20));
        coll.add(person);

//6.(boolean)  contains(Object obj):判断元素中是否包括obj
        //我们需要知道contains()匹配的是地址还是内容，，
        //在String中：由于重写了equals,所以对于字符串比较的是内容
        //我们在判断时会调用obj对象所在类的equals()

        boolean contains = coll.contains(123);      //true
        System.out.println(contains);
        boolean contains1 = coll.contains(new String("xujian"));

        boolean  contains2= coll.contains(new Person("徐健", 20));
        System.out.println(coll.contains(person));  //true
        System.out.println(contains1);    //true
        System.out.println(contains2);    //false  --->true(重写equals方法后)

//7..containsAll(Collection coll):判断形参coll1是否都存在与当前集合中

        Collection coll1=Arrays.asList(123,new String("xujian"));
        System.out.println(coll.containsAll(coll1));   //true
    }
    @Test
//8.boolean remove(Object obj):从当前集合中移除obj
    //而且remove也需要重写equals
        public void test(){
        Collection coll=new ArrayList();
        coll.add("aa");
        coll.add(new String("xujian"));
        coll.add(new Date());
        coll.add(123);
        coll.add(new Person("徐健",20));
        coll.add(false);

        coll.remove(123);
        coll.remove(new Person("徐健",20));
        //这是当重写了Person中的equals()方法，才为true


//9.boolen removeAll(Collection coll1):差集，从当前集合中移除coll1中所有元素
        System.out.println(coll);
        Collection coll1=Arrays.asList("aa");
        System.out.println(coll.removeAll(coll1));
        System.out.println(coll);
    }

    @Test
    public void test3(){

        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jack",20));
        coll.add(false);
        coll.add(new String("abc"));

 //10.retainAll(Collection coll1):取交集,获取当前集合与从coll1相交的元素，并返回给coll
       Collection coll1=Arrays.asList(123,new String("abc"),789);
        System.out.println(coll.retainAll(coll1));
        System.out.println(coll);
//11equals(Object obj):判断当前集合和形参集合的元素都相同  （有序的）
        Collection coll2=new ArrayList();
        coll2.add(new Person("Jack",20));
        coll2.add(123);
        coll2.add(456);
        coll2.add(false);
        coll2.add(new String("abc"));

        System.out.println(coll.equals(coll2));   //false顺序不同
    }


    @Test
    public void test4(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jack",20));
        coll.add(false);
        coll.add(new String("abc"));
//12.hashCode():指出元素的存储位置
        System.out.println(coll.hashCode());

//13.toArray()     集合--》数组
        Object[] objects = coll.toArray();
        //由于Object无法直接输出各个元素，需要遍历
        for (int i = 0; i <objects.length ; i++) {
            System.out.print(objects[i]+"  ");
        }
        System.out.println();

    //数组--》集合调用Arrays的静态方法asList()
        //①
        List<String> strings = Arrays.asList(new String[]{"AA","as"});
        System.out.println(strings);    //[AA, as]
        System.out.println(strings.size());      //2

        //②
        List<int[]> ints = Arrays.asList(new int[]{123, 456});   //错的
        List ints2 = Arrays.asList(new Integer[]{123, 456});    //对的
        List ints3 = Arrays.asList(123,456);                    //对的
        System.out.println(ints);    //[[I@78e03bb5]
        System.out.println(ints.size());  //结果为1 ，说明Arrays.asList(new int[]{123, 456})这个方式被认为只有一个元素
        System.out.println(ints2);         //[123, 456]
        System.out.println(ints2.size());  //2
        System.out.println(ints3);        //[123, 456]
        System.out.println(ints3.size());  //2
    }
 //14.iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试
}
