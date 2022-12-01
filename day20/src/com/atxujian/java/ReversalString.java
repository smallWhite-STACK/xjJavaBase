package com.atxujian.java;

/**
 * @author xujian
 * @create 2020-02-13 15:37
 */
/*将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反 转为”abfedcg”
 */
/*第一种：先得头尾，再搞中间*/
public class ReversalString {
  //需要自己写一个方法去实现char[]的反转
    //首先：实现String到插入[]的反转
    public static String reversalString(String str,int start,int end){
        char []chars=str.toCharArray();
        return reversalChar(chars,start,end);
    }
    //去实现char[]的反转
    public static String reversalChar(char[] chars,int start,int end){
        for (int i = start,j=end; i <j; i++,j--) {
            char temp=chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
        }
        //得到一个char [],需要换成String，new一个String
        return new String(chars);
    }

    public static void main(String[] args) {
        ReversalString rever = new ReversalString();
        String str=new String("ab123456c");
       String str1= rever.reversalString(str,2,7);
        System.out.println(str1);
    }


}
