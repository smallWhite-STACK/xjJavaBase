package com.atxujian.java;

import org.junit.Test;

/**
 * @author xujian
 * @create 2020-02-14 14:08
 */

/*StringBuffer类与StringBuilder类
* 1.String、StringBuffer、StringBuilder的异同
* 相同点：
*       三者在底层都是char[]存储
* 不同点：
*   String:不可变的字符序列，
*   StringBuffer:可变的字符序列：线性安全的，但是效率低,可以使用toString到String
*   StringBuider:可变的字符序列：jdk5.0新增，线性不安全的，但是效率高
*
*StringBuffer与StringBuilder的可变性体现在：当改变原有的字符串的长度时，内存区域不需要重新指定
* */
public class StringBufferAndBuilderTest {


    /*StringBuffer的可变性体现*/
    /*
    StringBuffer sb=new StringBuffer();//创建一个空的StringBuffer的对象，它自身的长度为0，但是它的默认空间有16个字符
    StringBuffer sb2=new StringBuffer("abc");//此时长度为3，但是它可以容纳3+16个字符

    此时有两个问题是：
    （1）sb.length();//0
         sb2.length();//3
     (2)当StringBuffer默认的16个位置不断append()，
                要添加的数据底层数组盛不下，则需要扩容底层的数组，
                默认情况下，扩容为原来的2倍+2，同时将原有数组的元素复制到新的数组中
        append()
    开发提示：由于存在可以先确定字符的个数，StringBuffer(int capacity),或者选择StringBuilder(int capacity)
    */


    @Test
    //String.valueOf()是将一个类型用字符串表示形式

//测试三者的效率
    public void test(){
        // 初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));

    }
    @Test
    //StringBuffer的常用方法
    /*
StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
StringBuffer delete(int start,int end)：删除指定位置的内容
StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str    (注意区间左开右闭)
StringBuffer insert(int offset, xxx)：在指定位置插入xxx
StringBuffer reverse() ：把当前字符序列逆转

public int indexOf(String str)  //返回 return str在索引首次出现的 位置
public String substring(int start,int end)
public int length()
public char charAt(int n )
public void setCharAt(int n ,char ch)
*/
    public void test2(){
        StringBuffer abc1 = new StringBuffer("abc");
        StringBuffer abc2 = new StringBuffer("abc");
        StringBuffer abc3 = new StringBuffer("abc");

        abc1.append(1);
        abc1.append('1');//引号不引号影响不大
        System.out.println(abc1);

        abc1.delete(0,1);
        System.out.println(abc1);

        abc2.replace(0,2,"smell");
        System.out.println(abc2);//semllc

        abc3.insert(0,123);//索引为零的地方插入指定内容
        System.out.println(abc3);//123abc

        abc3.reverse();
        System.out.println(abc3);

        int i = abc3.indexOf("23a");
        int i1 = abc3.indexOf("a32");
        System.out.println(i1);//2
        System.out.println(i);//-1

    }
    @Test
    public void test1(){
        StringBuffer s = new StringBuffer("zxc");
        //s.setCharAt('0','0');//索引不需要单引号

        s.setCharAt(0,'a');
        System.out.println(s);
    }
    @Test
    public void test4(){
        int a[]=new int[10];    //开辟了10个空间，默认值为0
        System.out.println(a[5]);   //o,

    }

}
