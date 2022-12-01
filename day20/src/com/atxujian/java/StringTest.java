package com.atxujian.java;


import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xujian
 * @create 2020-02-12 21:26
 */

class Person extends Object{
    String name;
    int age;
//alt+shift+s构造函数的快捷键
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class StringTest {

//        String str = new String("good");
        String str = "good";
        char[] ch = { 't', 'e', 's', 't' };
        public void change(String str, char ch[]) {
            str = "test ok";
            ch[0] = 'b';
        }
        public static void main(String[] args) {
//            StringTest ex = new StringTest();
//            ex.change(ex.str, ex.ch);
//            System.out.print(ex.str + " and ");//
//            System.out.println(ex.ch);

//            System.out.println();
//            String str = null;
//            StringBuffer sb = new StringBuffer();
//            sb.append(str);
//            System.out.println(sb.length());//4
//            System.out.println(sb);//null
//            StringBuffer sb1 = new StringBuffer(str); //Exception in thread "main" java.lang.NullPointerException
//            System.out.println(sb1);//
//            Date date = new Date();
//            System.out.println(date.toString());
//            new java.sql.Date();
            Date date = new Date(); // 产生一个Date实例

// 产生一个formater格式化的实例
            SimpleDateFormat formater = new SimpleDateFormat();
            System.out.println(formater.format(date));// 打印输出默认的格式


            SimpleDateFormat formater2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            System.out.println(formater2.format(date));

            Date date2 = new Date();
            try {
                // 实例化一个指定的格式对象
                date2= formater2.parse("2020-09-08");
                // 将指定的日期解析后格式化按指定的格式输出
                System.out.println(date2.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            java.sql.Date date_sql = new java.sql.Date(date2.getTime());
            System.out.println(date_sql);



        }

/*   String的特性
* 常量与常量
* 变量与常量
* intern()方法
* */
    @Test
    public void test4(){
        /*与final常量有关*/
        //此时s1就是一个常量，s4就是一个常量与一个常量的运算
        final String s1="JavaEE";
        String s2="JavaSE";
        String s3=s1+s2;
        String s4=s1+"JavaSE";
        String s5="JavaEEJavaSE";
        System.out.println(s3==s5);//false
        System.out.println(s4==s5);//true
    }    @Test
    public void test3(){
        String s1="JavaEE";
        String s2="JavaSE";
        String s3="JavaEEJavaSE";

        String s4=s1+s2;
        String s5="JavaEE"+s2;
        String s6=s1+"JavaSE";//例如s4 s5 s6三个由于右边有变量参与了，所以都相当于new了一个对象，都会牵扯到堆

        String s7="JavaEE"+"JavaSE";//这是自变量的连接


        System.out.print(s4+s5+s6+s7);
        System.out.println();
       // System.out.println(s3.equals(s4));
//        System.out.println(s3==s4);//false
//        System.out.println(s3==s5);//false
//        System.out.println(s3==s6);//false
//        System.out.println(s3==s7);//true
//        System.out.println(s5==s6);//false
        System.out.println(s4==s5);  //fasle
        System.out.println(s6==s5); //fasle
        System.out.println(s4==s6);//fasle
//        System.out.println(s4==s5);

        String s8 = s4.intern();//返回值在常量池中
        System.out.println(s3==s8);//true
    }
    @Test
    public void test2(){
        Person per = new Person("Tom", 12);
        Person per2 = new Person("Tom", 12);

        System.out.println(per.equals(per2));//false
        System.out.println(per.name.equals(per2.name));//true

        //public boolean equals(Object obj) {
        //        return (this == obj);
        //    }
        System.out.println(per.name==per2.name);//true
        System.out.println(per.hashCode());//580024961
        System.out.println(per2.hashCode()); //2027961269
        System.out.println(per.name.hashCode()); //84274
        System.out.println(per2.name.hashCode()); //84274
        per2.name="Jack";
        System.out.println(per.name.equals(per2.name));//false
    }
    /*
     * String:字符串
     * 1.String:声明为final，不可继承
     * 2.String实现了Serializable接口：表示字符串是支持序列化的
     *         实现了Comparable接口：表示String可以比较大小
     * 3.String内部定义了final  char[]  value用于存储字符串数据
     * 4.String:代表不可变的字符序列。简称：不可变  性。
     *     体现：1.当对字符串重新赋值时，需要重新指定内存区域赋值，
     *           不能使用原有的value（字符串长度）
     *           2.对于str3，当改变原有的字符串的长度时，也需要重新指定内存区域
     *           3.当使用String的方法replace()修改指定字符串时，也需要重新指定内存区域
     * 5.String str="abc";//字面量的方式声明在常量池中
     * 6.字符串常量池中不会存储相同内容的字符串
     * */
    @Test
    //此处设计到JUnit的（Java的一个单元测试框架）（白盒测试）
    public void test1(){
        String str="abc";//字面量的方式
        String str2="abc";
        String abc = new String("abc");
        String abc1 = new String("abc");

        System.out.println(str==abc);//false
        System.out.println(str.equals(abc));//true
        System.out.println(abc.equals(abc1));//true
        System.out.println(abc==abc1);//false

        System.out.println(str==str2);//==比较的是地址值true
        System.out.println(str.hashCode());//96354
        System.out.println(str2.hashCode());//96354
        str="123";
        System.out.println(str);
        System.out.println(str2);

        String str3="123";
        System.out.println(str3.hashCode());//48690
        str3+="abc";
        System.out.println(str3);//123abc
        System.out.println(str3.hashCode());//1450620144


        String str4="abc";
        //replace是代替字符串中的一个字符，所以单引号
        String str5 = str4.replace('a','m');
        System.out.println(str4);//abc
        System.out.println(str5);//mbc

        System.out.println(abc.hashCode()); //96354
        abc="xj";
        System.out.println(abc.hashCode()); //3826

    }
}
