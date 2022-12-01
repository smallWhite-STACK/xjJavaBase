package com.atxujian.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *       和方法引用类似，函数式接口的抽象方法和构造器的形参列表一致。
 *       抽象方法的返回值类型即为构造器所属的类的类型
 * 二、数组引用
 *       我们可以把数组看作一个特殊的类，则写法与构造器引用一致。
 *
 *
 * Created by shkstart
 */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的T get()
    //Employee的空参构造器：Employee()      返回的对象就是T
    @Test
    public void test1(){
        //原始方法
        Supplier<Employee> sup=new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();//空参的构造函数
            }
        };
        System.out.println(sup.get());
        System.out.println("*************");
        //使用Lambda表达式
        Supplier<Employee> sup2=() -> new Employee();
        System.out.println(sup2.get());
        System.out.println("*************");
        //使用构造器引用
        Supplier<Employee> sup3=Employee::new;
        System.out.println(sup3.get());
	}

	//Function中的R apply(T t)
    @Test
    public void test2(){
        //我们通过id创建一个Employee的对象
        Function<Integer,Employee> fun1=new Function<Integer, Employee>() {
            @Override
            public Employee apply(Integer id) {
                return new Employee(id);
            }
        };
        System.out.println(fun1.apply(12));

        //使用Lambda表达式
        Function<Integer,Employee> fun2=id -> new Employee(id);
        System.out.println(fun2.apply(13));
        //使用 构造器引用
        Function<Integer,Employee> fun3=Employee::new;
        System.out.println(fun3.apply(15));
    }

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        //这个我们使用构造器为两个参数的构造器
        //原始方法
        BiFunction<Integer,String,Employee> bi1=new BiFunction<Integer, String, Employee>() {
            @Override
            public Employee apply(Integer id, String name) {
                return new Employee(id,name);
            }
        };
        System.out.println(bi1.apply(13, "Javk"));

        //使用Lambda表达式
        BiFunction<Integer,String,Employee> bi2= (id,name) -> new Employee(id,name );
        System.out.println(bi2.apply(13, "Lucy"));

        //使用调用构造器的方式
        BiFunction<Integer,String,Employee> fun3=Employee::new;
        System.out.println(fun3.apply(12, "pig"));
    }

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
         Function<Integer,String[]> fun1=new Function<Integer, String[]>() {
             @Override
             public String[] apply(Integer length) {
                 return new String[length];
             }
         };
        String[] apply = fun1.apply(5);
        System.out.println(Arrays.toString(apply));
        System.out.println("**************");

        //使用Lambda表达式
        Function<Integer,String[]> fun2=length -> new String[length];
        System.out.println(Arrays.toString(fun2.apply(2)));
        System.out.println("**************");

        //使用数组引用
        Function<Integer,String[]> fun3=String[]::new;
        System.out.println(Arrays.toString(fun3.apply(10)));
    }
}
