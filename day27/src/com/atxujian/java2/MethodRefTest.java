package com.atxujian.java2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * Created by xujian
 *
 * 1.使用情景：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 *
 *2.方法引用：本质其实就是Lambda表达式，方法引用可以看做是Lambda表达式深层次的表达。
 *
 * 3.使用格式：类（对象） ：：方法名
 *
 * 4.具体有以下三情况：
 * 对象：：非静态方法；
 * 类：：静态方法
 *
 * 类：：非静态方法
 *
 * 5.方法引用的要求：实现接口的抽象方法的参数列表和返回值类型，
 *  *      必须与方法引用的方法的参数列表和返回值类型保持一致！（针对4的前两种情况）
 *  *      例如：void  T t
 *  *            void  T t
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
        Consumer<String> con1=str -> System.out.println(str);
        con1.accept("北京");
        System.out.println("*****************");

        PrintStream out = System.out;
		Consumer<String> con2 =out::println;
		//Consumer<String> con3=System.out::println;
        con2.accept("beijing");
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
        Employee jack = new Employee(1002, "Jack", 20, 9800);

        Supplier<String> supplier=() -> jack.getName();
        System.out.println(supplier.get());
        System.out.println("*********************");

        Supplier<String> supplier2=jack::getName;
        System.out.println(supplier2.get());
    }

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)          注意这两个compare一模一样
	@Test
	public void test3() {

		/*Comparator<Integer> com1=new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};*/
		System.out.println("***********************");
		//利用Lambda表达式对Compator重写
		Comparator<Integer> com2=(o1, o2) -> Integer.compare(o1, o2);
		System.out.println(com2.compare(13, 13));
		System.out.println("***********************");
		//利用方法引用
		Comparator<Integer> com3=Integer::compare;
		System.out.println(com3.compare(45, 0));
	}
	
	//Function中的R apply(T t)   传入一个形参，得到另外一个类型的参数
	//Math中的Long round(Double d)     注意这两个函数方法都是传入一个类型得到另外一个类型
	@Test
	public void test4() {
		//原来
		Function<Double,Long> fun1=new Function<Double, Long>() {
			@Override
			public Long apply(Double aDouble) {
				return Math.round(aDouble);
			}
		};
		System.out.println(fun1.apply(123.521));
		System.out.println("***********************");
		//使用Lambda表达式
		Function<Double,Long> fun2=d ->Math.round(d);
		System.out.println(fun2.apply(123.521));
		System.out.println("***********************");
		//使用方法引用
		Function<Double,Long> fun3=Math::round;
		System.out.println(fun3.apply(123.521));
	}

	// 情况三：类 :: 实例方法 
	// Comparator中的int compare(T t1,T t2)
	// String中的 t1.compareTo(t2)     此时两个函数，t1作为调用函数的主体，所以看String
	@Test
	public void test5() {
		//原来匿名类
		Comparator<Double> com1=new Comparator<Double>() {
			@Override
			public int compare(Double o1, Double o2) {
				return o1.compareTo(o2);
			}
		};
		System.out.println(com1.compare(123.123, 123.1));
		System.out.println("***********************");
		//使用Lambda表达式
		Comparator<Double> com2=(o1,o2) ->o1.compareTo(o2);
		System.out.println(com2.compare(123.123, 123.1));
		System.out.println("***********************");
		//使用方法调用
		Comparator<Double> com3=Double::compareTo;
		Comparator<String> com4=String::compareTo;
		System.out.println(com3.compare(123.123, 123.1));
		System.out.println(com4.compare("123456.123456","123456.321654"));
	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)            同上
	@Test
	public void test6() {
		//原方法
		BiPredicate<String,String> bi=new BiPredicate<String, String>() {
			@Override
			public boolean test(String s, String s2) {
				return s.equals(s2);
			}
		};
		System.out.println(bi.test("320.0", "320.000"));
		System.out.println("*************************");
		//使用Lambda表达式
		BiPredicate<String,String> bi2=(s,s2) -> s.equals(s2);
		System.out.println(bi2.test("320.0", "320.000"));
		System.out.println("*****************************");
		//使用方法调用
		BiPredicate<String,String> bi3=String::equals;
		System.out.println(bi3.test("456","456"));


	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();  //与上面不同，
	@Test
	public void test7() {
		//创建一个Employee的对象
		Employee jacky = new Employee(12, "Jacky", 20, 12000);
		//原始方法：
		Function<Employee,String> fun1=new Function<Employee, String>() {
			@Override
			public String apply(Employee employee) {
				return employee.getName();
			}
		};
		System.out.println(fun1.apply(jacky));
		System.out.println("********************");
		//使用Lambda表达式
		Function<Employee,String> fun2=employee -> employee.getName();
		System.out.println(fun2.apply(jacky));
		System.out.println("********************");
		//使用方法调用
		Function<Employee,String> fun3 =Employee::getName;
		System.out.println(fun3.apply(jacky));
	}

}
