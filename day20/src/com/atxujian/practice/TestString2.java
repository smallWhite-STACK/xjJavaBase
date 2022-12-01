package com.atxujian.practice;

/**
 * @author xujian
 * @create 2020-02-15 11:14
 */

/*．一个应用程序，接受用户输入的一行字符串，统计字符个数，然后反序输出。*/
public class TestString2 {
    public static void main(String[] args) {
        //还是使用命令行参数

        if(args[0].length()>0){
        String str=args[0];
        System.out.println(str.length());
        //因为String中不存在 reverse()方法，无法像StringBuffer字符串直接调用方法
            for (int i = str.length(); i >0; i--) {
                System.out.print(str.charAt(i-1));
            }

        }
    }
}
