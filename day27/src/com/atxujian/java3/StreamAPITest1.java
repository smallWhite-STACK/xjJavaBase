package com.atxujian.java3;

import com.atxujian.java2.Employee;
import com.atxujian.java2.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author xujian
 * @create 2020-03-23 17:26
 */
/*
* 测试Stream的中间操作
*       1.筛选与切皮   ---》test1
*       2.映射
*       3.排序
*
*
* */

public class StreamAPITest1 {

//1. 筛选与切皮
    //filter
    //limit
    //skip
    //distinct
    @Test
    public void test1(){
        //先创建一个list对象，然后调用stream，--》筛选与切片
//filter
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
//filter(Predicate p) 接收Lambda ， 从流中排除某些元素
        //练习：查询员工表中工资薪资大于7000的员工信息
        stream.filter(e->e.getSalary()>7000).forEach(System.out::println);
        System.out.println();

//limit(n)--截断流，使其元素不超过给定数量
        Stream<Employee> stream1 = list.stream();
        stream1.limit(3).forEach(System.out::println);
        System.out.println();

//skip(n) --跳过元素，返回一个扔掉了前n个元素的流，若流中的元素不足n个，则返回一个空流，与limit(n)互补
        Stream<Employee> stream2 = list.stream();
        stream2.skip(30).forEach(System.out::println);
        System.out.println();
//distinct:--筛选，通过流所所生成元素的hashcode()和equals()去除重复元素
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        //新建一个流
        Stream<Employee> stream3 = list.stream();
        stream3.distinct().forEach(System.out::println);
    }


    @Test
    public void test2(){
//2.    映射
        //map(Function f)
       // 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        //练习0：让链表中的字母变为大写
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map(str->str.toUpperCase()).forEach(System.out::println);
        System.out.println("*****************");
//        练习1：获取员工 姓名长度大于3的员工的姓名
        List<Employee> employees = EmployeeData.getEmployees();
        //通过映射拿到每一个员工的名字,map(Employee::getName())
        employees.stream().map(name->name.getName()).filter(name->name.length()>3).forEach(System.out::println);

        System.out.println("***********************");


//        练习2：流中有流(调用方法fromStringToStream)我们依然使用上面list
        Stream<Stream<Character>> streamStream = list.stream().map(this::fromStringToStream);
                    //此时我们得到一个stream中还有一个stream的例子
        streamStream.forEach(stream->stream.forEach(System.out::println));
        System.out.println("*******************");


//        flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另 一个流，然后把所有流连接成一个流
        // 我们使用flatMap方式对练习2进行处理
        // 练习2：流中有流(调用方法fromStringToStream)我们依然使用上面list
        list.stream().flatMap(s->fromStringToStream(s)).forEach(System.out::println);

    }

//声明fromStringToStream可以换成静态的方法，可以直接使用类名::fromStringToStream
    public Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c:str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
    @Test
    public void test3(){
        //用链表中的add与 addAll方法去比较map与flatMap
        ArrayList<Object> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        ArrayList<Object> listb = new ArrayList<>();
        listb.add(4);
        listb.add(5);
        listb.add(6);

        lista.add(listb);
        System.out.println(lista);  //注意此时lista有几个元素

        //试试如果是lista.addAll(listb)   ,结果如何

    }

    //3.排序
    @Test
    public void test4(){
//        sorted() 产生一个新流，其中按自然顺序排序
        List<Integer> list = Arrays.asList(12, 0, 53, 58, 7);
        list.stream().sorted().forEach(System.out::println);
        System.out.println("*********************");

//        sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
        //由于Employee并未实现Comparable接口，所以我们使用定制排序(使用年龄)

 //原始方法
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int compare = Integer.compare(o1.getAge(), o2.getAge());
                if(compare!=0){
                    return compare;
                }else{
                    return Double.compare(o1.getSalary(),o2.getSalary() );
                }
            }
        }).forEach(System.out::println);
        System.out.println("*********************");
 //使用Lambda表达式
        List<Employee> employees1 = EmployeeData.getEmployees();
        employees1.stream().sorted((o1,o2) ->
                {
                    int compare = Integer.compare(o1.getAge(), o2.getAge());
                    if (compare!=0){
                        return compare;
                    }else{
                        return -Double.compare(o1.getSalary(), o2.getSalary());
                    }
                }
        ).forEach(System.out::println);
    }
}
