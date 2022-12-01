package com.atxujian.javaCollections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xujian
 * @create 2020-02-28 15:36
 */
public class CollectionsTest {

/*Collections:操作Collection、Map的工具类

面试题：Collection与Collections的区别
*
* */


    @Test
    public void test1(){
        //copy()方法
          List list=new ArrayList();
            list.add(123);
            list.add(456);
            list.add(1);
            list.add(8);
            list.add(9);

       /* List dest=new ArrayList();
        Collections.copy(dest, list);
        //由于dest的长度为0，所以会报异常j
        // ava.lang.IndexOutOfBoundsException: Source does not fit in dest
        System.out.println(dest);*/

        //正确的方式应该用Arrays.asList

        List dest1= Arrays.asList(new Object[list.size()]);
        System.out.println(dest1.size());    //5
        Collections.copy(dest1, list);
        System.out.println(dest1);           //[123, 456, 1, 8, 9]

    /*Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使
    将指定集合包装成线程同步的集合，
    从而可以解决多线程并发访问集合时的线程安全问题 */

        List list1 = Collections.synchronizedList(list);
        //此时的list1便是线程安全的

    }
}
