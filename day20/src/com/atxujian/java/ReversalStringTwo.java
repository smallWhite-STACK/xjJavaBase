package com.atxujian.java;

/**
 * @author xujian
 * @create 2020-02-13 16:25
 */

/*
* 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反 转为”abfedcg”
 */
/*按顺序从头到尾
* 利用substring与charAt*/

    //缺陷是start不能为零

public class ReversalStringTwo {

    public static String revervalString(String str,int start,int end){
        //从头开始，先得到头的字符串,利用substring()方法
        String head=str.substring(0,start);
        //中间
        for (int i = end; i >start ; i--) {
            //一个一个字符开始加入
            char c=str.charAt(i);
            head+=c;
        }
        //最后加上结尾
        head+=str.substring(end,str.length());
        return head;
    }

    public static void main(String[] args) {
        ReversalStringTwo two = new ReversalStringTwo();
        String s=new String("ab123456c");
        String s1 = two.revervalString(s,1,5);
        System.out.println(s1);
    }
}
