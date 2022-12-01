package com.atxujian.practice;

/**
 * @author xujian
 * @create 2020-02-15 15:57
 */
/*创建BigDecimalDemo类，
在类中分别定义add(),sub(),mul()和div()方法实现加、减、乘、除运算，
并输出运算结果。要求除法，可以
处理商的精度。*/


//decimal:小数
public class BigDecimalDemo {

    public float add(String s[]){
        float sum=0;
        //注意小心ArrayIndexOutOfBoundsException   s.length-1
        for (int i = 0; i <=s.length-1; i++) {
            //为了将String转化为float型的，
            sum=sum-Float.parseFloat(s[i]);
        }
        return sum;
    }
    public float sub(String s[]){
        float sum=0;
        //注意小心ArrayIndexOutOfBoundsException   s.length-1
        for (int i = 0; i <=s.length-1; i++) {
            //为了将String转化为float型的，
            sum=sum+Float.parseFloat(s[i]);
        }
        return sum;
    }
    public float mul(String s[]){
        float sum=1;
        //注意小心ArrayIndexOutOfBoundsException   s.length-1
        for (int i = 0; i <=s.length-1; i++) {
            //为了将String转化为float型的，
            sum=sum*Float.parseFloat(s[i]);
        }
        return sum;
    }
    public float div(String s[]){
        float sum=Float.parseFloat(s[0]);;
        //注意小心ArrayIndexOutOfBoundsException   s.length-1
        for (int i = 0; i <=s.length-1; i++) {
            //为了将String转化为float型的，
            sum=sum/Float.parseFloat(s[i]);
            //如何确定小数点后可以固定有几位


        }
        return sum*Float.parseFloat(s[0]);
    }
    public static void main(String[] args) {
        BigDecimalDemo demo = new BigDecimalDemo();
        String s[]={"1","2","3","4","5"};
        System.out.println(demo.add(s));
        System.out.println(demo.sub(s));
        System.out.println(demo.mul(s));
        System.out.println(demo.div(s));
    }
}
