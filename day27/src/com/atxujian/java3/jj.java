package com.atxujian.java3;

import org.junit.Test;

/**
 * @author xujian
 * @create 2020-03-27 11:51
 */
public class jj {
    public static void main(String[] args) {
        int a=2;
        int i = (a++) << a;
        System.out.println(i);
        boolean b = 1.0 / 0.0 > 1;
        System.out.println(b);

        int x=3,y=4,z;
        z=++x*3+(++x)*y++;
        System.out.println(z);


    }
    @Test
    public void test1(){
        int a=2;
        a=(a++)+a++;
        System.out.println(a);
    }
}
