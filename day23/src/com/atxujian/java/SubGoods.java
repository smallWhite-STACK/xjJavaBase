package com.atxujian.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xujian
 * @create 2020-03-01 17:52
 */

/*泛型类的继承
* 1.继承时指明泛型类型，子类不是泛型类
* 2.下
* */
public class SubGoods extends Goods<Integer> {

    //此时如果父类中也有这个同名同参的函数，要是静态都是静态，
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e:arr){
            list.add(e);
        }
        return list;
    }
}


