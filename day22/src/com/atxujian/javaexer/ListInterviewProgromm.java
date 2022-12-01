package com.atxujian.javaexer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xujian
 * @create 2020-02-25 15:50
 */
/*关于List的一个面试题*/
public class ListInterviewProgromm {
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//  [1, 2]--->[1, 3]

    }
        private static void updateList(List list) {

        //list.remove(2);

        list.remove(new Integer(2));

    }
}
