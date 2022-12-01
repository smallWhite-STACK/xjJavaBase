package com.atxujian.javaList;

import com.atxujian.java.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xujian
 * @create 2020-02-25 15:03
 */
/*Test1
void add(int index,Object ele)
* boolean addAll(int index,Collection eles)
*
* Test2
*int indexOf(Object obj)
* int lastIndexOf(Object obj)
*
* Test3
* Object remove()既可以按索引删除，又可以按元素内容
* Object set(int index,Object obj)
* List sublist(int fromIndex,int toIndex)  截取，影响返回值，区间左闭右开
* */
public class AboutListTest {

    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("abc");
        list.add(456);
        list.add(new Person("Jack",20));
        list.add(456);

        System.out.println(list);
//[123, abc, 456, Person{name='Jack', age=20}, 456]
        //使用void add(int index,Object ele):在index位置插入ele元素
        list.add(1,000);
        System.out.println(list);
//[123, 0, abc, 456, Person{name='Jack', age=20}, 456]

        //boolean addAll(int index,Collection eles)将eles中的元素添加到list中
        List list1 = Arrays.asList(123,456);//Arrays的静态方法asList(),
        /*list.addAll(5,list1);
        System.out.println(list);
        System.out.println(list.size());*/
//[123, 0, abc, 456, Person{name='Jack', age=20}, 123, 456, 456]
//size 为  8
        //但是这种情况
        list.add(list1);//默认从最后加上
        System.out.println(list);
        System.out.println(list.size());
//[123, 0, abc, 456, Person{name='Jack', age=20}, 456, [123, 456]]
        //size  为7
    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("abc");
        list.add(456);
        list.add(new Person("Jack",20));
        list.add(456);

        //int indexOf(Object obj),返回obj在list中第一次出现的位置，否则返回-1
        int i = list.indexOf(456);
        int i1 = list.lastIndexOf(456);
        System.out.println(i);    //2
        System.out.println(i1);   //4

        //remove()
        list.remove(3);
        System.out.println(list);

        //set()
        list.set(0,"xujain");
        System.out.println(list);  //[xujain, abc, 456, 456]
        //subList()
        List list1 = list.subList(0, 2);
        System.out.println(list1);   //[xujain, abc]
    }

}
