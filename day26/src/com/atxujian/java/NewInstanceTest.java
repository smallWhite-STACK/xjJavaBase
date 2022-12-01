package com.atxujian.java;

import org.junit.Test;

import java.util.Random;

/**
 * @author xujian
 * @create 2020-03-18 18:00
 */

/*关于：通过反射，创建对应的运行时类的对象*/
public class NewInstanceTest {
    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        Class<Person> personClass = Person.class;
/*newInstance():调用此方法，创建对应的运行时类的对象，内部调用了运行时类的空参的构造器
*
*要想此方法正常的创建运行时类的对象，要求：
*   1.运行时必须提供空参构造器（我们可以通过其他方法调用参数不为空的方法，但是一般不用）
*   2.空参构造器的访问权限得够，通常：设置为public
*
*   在javabean中要求提供一个public的空参构造器。原因：
*   1.便于通过反射，创建运行时的对象
*   2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
*
* */
        Person person = personClass.newInstance();
        System.out.println(person);
    }

    @Test
    //反射的动态性，运行时告诉想要那个对象，使用new不行
    public void test1(){
        int i = new Random().nextInt(3);//随机数为0.1.2.
        String classPath="";
        switch(i){
            case 0:
                classPath="java.util.Date";
                break;
            case 1:
                //sql下的Date没有空参构造器cassPath="java.sql.Date"
                classPath="java.lang.Object";
                break;
            case 2:
                classPath="com.atxujian.java.Person";
                break;
        }
        Object instance = null;
        try {
            instance = getInstance(classPath);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(instance);

    }

    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName(classPath);
        Object o = clazz.newInstance();
        return o;
    }
}
