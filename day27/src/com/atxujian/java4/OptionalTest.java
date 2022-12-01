package com.atxujian.java4;

import org.junit.Test;

import java.util.Optional;

/**
 * @author xujian
 * @create 2020-03-24 14:06
 */

/*
* Optional类：为了在程序中避免出现空指针异常而创建的
*
* 常用的是：ofNullable(T t)
*           orElse(T  t)
*
* Optional.of(T t):创建一个Optional实例，t必须非空
* Optional.empty():创建一空的Optional实例
* Optional.ofNullable(T t):t可以为null
*
* */
public class OptionalTest {

    @Test
    public void test1(){

        //空指针异常
        Girl girl = new Girl();
        girl=null;
        Optional<Girl> girl1 = Optional.of(girl);
        System.out.println(girl1);
    }

    @Test
     public void test2(){
        Girl girl = new Girl();
        girl=null;
        //ofNullable(T t)：t可以为null
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        System.out.println(girl1);   // Optional.empty

        //orElse(T t1):如果单前的Optional内部封装的t是非空的，则返回内部的t.
        //如果内部的t是空的，则返回orElse()方法中的参数t1.
        Girl lili = girl1.orElse(new Girl("lili"));
        System.out.println(lili);

    }

    public String getGirlName(Boy boy){
        Girl girl = boy.getGirl();
        String name = girl.getName();
        return name;
    }

    @Test
    public void test3(){
        Boy boy = new Boy();
        boy=null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
        //此时由于调用的无参的Boy构造器，Girl无对象，所以出现空指针

    }

    //优化以后的getGirlName(以往避免空指针的措施)
    public String getGirlName1(Boy boy){
        if(boy!=null){
            Girl girl = boy.getGirl();
            if(girl!=null){
                return girl.getName();
            }else{
                return null;
            }
        }
        return null;
    }

    //此时不会报空指针异常，而是返回null
    @Test
    public void test4(){
        Boy boy = new Boy();
        boy=null;
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    //我们利用Optional类再次写一个getGirlName2()
    public String getGirlName2(Boy boy){
        Optional<Boy> boy1 = Optional.ofNullable(boy);
        //此时的boy1一定非空(如果Boy为null则输出didi)
        Boy didi = boy1.orElse(new Boy(new Girl("didi")));

        Girl girl = didi.getGirl();

        //此时girl可能还是null所以还需要在包一层
        //此时girl1一定非空(如果Girl为null)
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl lli = girl1.orElse(new Girl("lli"));
        return lli.getName();
    }
    @Test
    public void test5(){
        Boy boy = new Boy();
        boy=null;
        String girlName2 = getGirlName2(boy);
        System.out.println(girlName2);

        System.out.println("*******************");
        Boy boy1 = new Boy(null);
        String girlName21 = getGirlName2(boy1);
        System.out.println(girlName21);

        System.out.println("*******************");
        Boy boy2 = new Boy(new Girl("苍老师"));
        String girlName3 = getGirlName2(boy2);
        System.out.println(girlName3);
    }




}
