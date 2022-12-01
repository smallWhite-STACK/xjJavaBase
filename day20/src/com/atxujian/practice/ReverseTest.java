package com.atxujian.practice;

/**
 * @author xujian
 * @create 2020-02-16 9:45
 */

/*将一个字符串进行反转。将字符串中指定部分进行反转。
比如将“abcdefg”反转为”abfedcg”*/
public class ReverseTest {


    public String myReverse(String str, int start, int end){

      //toChaArray
        char[] c=str.toCharArray();


        return lastReverse(c,start,end);
    }
    public String lastReverse(char[] c,int start,int end){
        for (int i = start,j=end; i <j ; i++,j--) {
            char temp=c[start];
            c[start]=c[end];
            c[end]=temp;
        }

        return new String (String.valueOf(c));

        //return new String(c);
    }

    public static void main(String[] args) {
        ReverseTest test = new ReverseTest();
       // test.myReverse("xujian",1,2);
        System.out.println(test.myReverse("xujian",1,2));
    }
}
