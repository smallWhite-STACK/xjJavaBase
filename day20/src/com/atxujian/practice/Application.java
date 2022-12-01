package com.atxujian.practice;

/**
 * @author xujian
 * @create 2020-02-15 9:48
 */

/*请编写一个 Application 实现如下功能：接受命令行中给出的一个字母串，先将该串原样输出，
然后判断该串的第一个字母是否为大写，若是大写则统计该串中大写字母的个数，并将所有大写字母输出；
否则输出信息串”第一个字母不是大写字母!”。*/

//命令行参数
public class Application {

    public static void main(String[] args) {
        //count大写字母个数
        int count=0;
        if(args.length>0){
            System.out.println(args[0]);
            //A--Z对应65-90,判断首字母是否为大写
            if((int) args[0].charAt(0)>=65&&(int) args[0].charAt(0)<=90){
                for (int i = 0; i <args[0].length() ; i++) {
                    if((int) args[0].charAt(i)>=65&&(int) args[0].charAt(i)<=90){
                        System.out.println(args[0].charAt(i));
                        count++;
                    }
                }
                System.out.println("一共"+count+"个大写字母");
            }else{
                System.out.println("第一个字母不是大写");
            }
      }else{
            System.out.println("请给出命令行参数");

        }
    }
}
