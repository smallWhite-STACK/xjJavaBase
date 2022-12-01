package com.atxujian.java3;

import com.atxujian.java2.Employee;
import com.atxujian.java2.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xujian
 * @create 2020-03-24 9:14
 */
/*
* Stream的终止操作
* 1.匹配与查询
* 2.归约
* 3.收集
* */
public class StreamAPITest2 {
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
        //1.匹配与查询
//    allMatch(Predicate p) 检查是否匹配所有元素
        //练习：是否所有的员工的工资大于2000
        boolean b = list.stream().allMatch(e -> e.getSalary() > 2000);
        System.out.println(b);

//    anyMatch(Predicate p) 检查是否至少匹配一个元素
        //练习：看是否有姓“雷”的员工
        boolean b1 = list.stream().anyMatch(e -> e.getName().startsWith("雷"));
        System.out.println(b1);

//    noneMatch(Predicate p) 检查是否没有匹配所有元素，（存在即为false）
        //练习：看是否存在有姓“雷”的员工
        boolean b2 = list.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(b2);

//    findFirst() 返回第一个元素
        Optional<Employee> employee = list.stream().findFirst();
        System.out.println(employee);

//    findAny() 返回当前流中的任意元素
        Optional<Employee> employee1 = list.stream().findFirst();
        System.out.println("findAny   " + employee1);
        //或者
        Optional<Employee> employee2 = list.parallelStream().findFirst();
        System.out.println("findAny    " + employee2);

    }
    @Test
    public void test2(){
        List<Employee> list = EmployeeData.getEmployees();
//    count() 返回流中元素总数
        //可以结合filter
        long count1 = list.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count1);

        long count = list.stream().count();
        System.out.println(count);
//      max(Comparator c) 返回流中最大值
        //练习：返回最高的工资(只显示工资)：(所以我们可以结合map映射一个工资表)
        Optional<Double> max = list.stream().map(e -> e.getSalary()).max(Double::compare);
        System.out.println(max);

//       min(Comparator c) 返回流中最小值
        //返回最低工资的员工
        Optional<Employee> min = list.stream().min((e1,e2)->Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);

        //或者，原始方法
        Optional<Employee> min1 = list.stream().min(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
        });
        System.out.println(min1);


//    forEach(Consumer c) 内部迭代(使用 Collection 接口需要用户去做迭代， 称为外部迭代。相反，Stream API 使用内部迭 代——它帮你把迭代做了)
            //我们需要区分内部迭代与链表的默认方法forEach
        list.stream().forEach(System.out::println);
        System.out.println();
        //使用集合的遍历操作
        list.forEach(System.out::println);

    }

    //备注：map 和 reduce 的连接通常称为 map-reduce 模式，因 Google 用它来进行网络搜索而出名。
    @Test
    public void test3(){
//        2.归约
//        reduce(T identity, BinaryOperator b)：可以将流中元素反复结合起来，得到一个值。返回 T
        //练习1：计算1-10的自然数的和(reduce中的identity是默认初始值)
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);


//        reduce(BinaryOperator b)：可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
//        练习2：计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduce1 = employees.stream().map(e -> e.getSalary()).reduce(Double::sum);
        Optional<Double> reduce2 = employees.stream().map(e -> e.getSalary()).reduce((d1, d2) -> d1 + d2);
        System.out.println(reduce1);
        System.out.println(reduce2.get());//使用这个get()的方法，必须确定非空

    }

    //3.收集
    @Test
    public void test4(){
//collect(Collector c)：将流转换为其他形式。接收一个 Collector 接口的实现，用于给Stream中元素做汇总 的方法
        //练习一：查找工资大于6000的员工，结果返回一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("****************");

        Set<Employee> set= employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        set.forEach(System.out::println);
    }
}
