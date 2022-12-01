package com.atxujian.java3;

import com.atxujian.java2.Employee;
import com.atxujian.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xujian
 * @create 2020-03-23 16:52
 */

/*
1.Stream的执行流程
①：Stream的实例化
②：一系列的中间操作（过滤、映射、。。。）
③：终止操作

2.说明：
4.1一个中间操作链，对数据源的数据进行处理
4.2一旦执行终止操作，就执行中间操作链，并产生结果，之后，不会再被使用

实例化：
* 创建一个Stream的四种方法
* 方式一：通过集合   ---stream与parallelStream
* 方式二：通过数组   ---Arrays.stream(数组对象)
* 方式三：通过Stream.of()  ---
* 方式四：通过无限流  ---Stream.iterate()    ----Stream.generate()
* */
public class StreamAPITest {
    //方式一:通过集合
    @Test
    public void test1(){
        List<Employee> employees= EmployeeData.getEmployees();
//          default Stream<E> stream():返回一个顺序流
        Stream<Employee> stream = employees.stream();

//          default Stream<E>   parallelStream():返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }
    //方式二：通过数组
    @Test
    public void test2(){
        //调用Arrays类的static<T> Stream<T> stream(T[] array)返回一个流
        int[] arr= new int[]{1,2,3,4,5};
        IntStream stream = Arrays.stream(arr);

        Employee e=new Employee(1,"Javk");
        Employee e1=new Employee(2,"Luck");
        Employee e2=new Employee(3,"User");
        //把对象放进数组
        Employee[] employees=new Employee[]{e,e1,e2};
        Stream<Employee> stream1 = Arrays.stream(employees);

    }
    //方式三：通过Stream的of()
    @Test
    public void test3(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    }


    //方式四 ：创建无限流(造数据)
    @Test
    public void test4(){
//        迭代：
//        public static<T> Stream<T> iterate(final T seed,final UnaryOperator<T> f)
        Stream.iterate(0, t->t+2).limit(10).forEach(System.out::println);

//        生成
//        public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
