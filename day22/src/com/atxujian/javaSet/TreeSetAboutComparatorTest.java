package com.atxujian.javaSet;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author xujian
 * @create 2020-02-26 14:56
 */
public class TreeSetAboutComparatorTest {
    @Test
    public void test(){
        Comparator com = new Comparator(){
            //按年龄大小排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Customer && o2 instanceof Customer){
                    //强转
                    Customer customer1=(Customer)o1;
                    Customer customer2=(Customer)o2;
                    //此时只按照age比较，如果年龄相同则认为为同一对象
                    return Integer.compare(customer1.getAge(),customer2.getAge());
                }else{
                    throw new RuntimeException("输入类型不匹配");
                }
            }
        };
        TreeSet treeSet = new TreeSet(com);
        treeSet.add(new Customer("Jack",6));
        treeSet.add(new Customer("Mac",45));
        treeSet.add(new Customer("Monkey",37));
        treeSet.add(new Customer("Aen",22));
        treeSet.add(new Customer("Ken",26));
        treeSet.add(new Customer("Jordon",75));
        treeSet.add(new Customer("Ya",75));
        //遍历
        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
