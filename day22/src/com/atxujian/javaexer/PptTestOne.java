package com.atxujian.javaexer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author xujian
 * @create 2020-03-01 10:17
 */
/*请从键盘随机输入10个整数保存到List中，
并按倒序、从大 到小的顺序显示出来
 */
public class PptTestOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入10个整数");
        ArrayList list = new ArrayList();
        for (int i = 0; i <10 ; i++) {
            int temp = scanner.nextInt();
            list.add(temp);
        }
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);   //实现倒序

        Collections.sort(list, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Integer && o2 instanceof Integer){
                    Integer i1=(Integer)o1;
                    Integer i2=(Integer)o2;
                    return -Integer.compare(i1, i2);
                }
                throw new RuntimeException();
            }
        });
        System.out.println(list);

    }
}
