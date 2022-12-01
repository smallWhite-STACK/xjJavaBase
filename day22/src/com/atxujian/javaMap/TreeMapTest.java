package com.atxujian.javaMap;

import org.junit.Test;

import java.util.*;

/**
 * @author xujian
 * @create 2020-02-28 13:13
 */
public class TreeMapTest {

    //向TreeMap中添加key-value,要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序、定制排序

    @Test
    public void test(){
        TreeMap map = new TreeMap();

        Customer c1 = new Customer("Jack", 56);
        Customer c2 = new Customer("Messy", 48);
        Customer c3 = new Customer("Criticiso", 5);
        Customer c4 = new Customer("NeiMey", 21);
        Customer c5 = new Customer("Luci", 63);
        //这时候这些顾客对象，只是key，我们需要values,我们假设values是分数

        map.put(c1,98);
        map.put(c2,100);
        map.put(c3,56);
        map.put(c4,60);
        map.put(c5,78);


        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            Map.Entry entry=(Map.Entry)next;
            System.out.println(entry.getKey()+"----->"+entry.getValue());
        }
    }


    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Customer && o2 instanceof Customer){
                    Customer c1=(Customer)o1;
                    Customer c2=(Customer)o2;
                    return Integer.compare(c1.getAge(), c2.getAge());
                }
                throw new RuntimeException();
            }
        });

        Customer c1 = new Customer("Jack", 56);
        Customer c2 = new Customer("Messy", 48);
        Customer c3 = new Customer("Criticiso", 5);
        Customer c4 = new Customer("NeiMey", 21);
        Customer c5 = new Customer("Luci", 63);
        //这时候这些顾客对象，只是key，我们需要values,我们假设values是分数

        map.put(c1,98);
        map.put(c2,100);
        map.put(c3,56);
        map.put(c4,60);
        map.put(c5,78);

        //遍历
        //第二种
        Set set = map.keySet();
        for (Object obj:set){
            System.out.println(obj+"---->"+map.get(obj));
        }
    }
}
