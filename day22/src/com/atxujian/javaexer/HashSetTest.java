package com.atxujian.javaexer;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author xujian
 * @create 2020-02-26 17:02
 */
public class HashSetTest {
    @Test
    public void test(){
        HashSet set = new HashSet();
        PersonO p1 = new PersonO(1001,"AA");
        PersonO p2 = new PersonO(1002,"BB");

        set.add(p1);
        set.add(p2);
        p1.setName("CC");
        set.remove(p1);
        System.out.println(set);

        System.out.println();
        set.add(new PersonO(1001,"CC"));
        System.out.println(set);

        System.out.println();
        set.add(new PersonO(1001,"AA"));
        System.out.println(set);
    }
}
