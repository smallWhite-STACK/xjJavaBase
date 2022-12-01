package com.atxujian.java1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xujian
 * @create 2020-02-11 21:04
 */
/*
* 创建多线程的另外两种方法
* Callable
*
* */
//1..创建一个实现Callable接口的类
class NumThread implements Callable {
    int numCount=0;
//2.实现call()方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        //call()方法可以抛出异常
        for(int i=0;i<=100;i++){
            System.out.println("第一个数是"+i);
            numCount=numCount+i;
        }
        return numCount;
    }
}
public class CallableTest {
    public static void main(String[] args) {
//3.创建Callable接口实现的类的对象
        NumThread numThread = new NumThread();
        //这里变量numThread无法直接调用start()方法，需要借助futuretask类
//4.将此Callable接口实现的对象作为传递到FutureTask构造器中，创建FutureTask对的对象
        FutureTask futureTask = new FutureTask(numThread);
//FutureTask实现了接口RunnableFuture,而RunnableFuture实现了Runnable接口
        //此时需要创建线程对象
//5.将FutrueTask的对象作为参数传递到Thread类的构造器中，创建Thread的对象并调用start()方法
        new Thread(futureTask).start();

        try {
            //get()方法的返回值即为FutureTask构造参数Callable实现类重写call()的返回值
//6.利用FutureTask的对象获取Callable中call()方法的返回值
            Object number = futureTask.get();
            System.out.println("和为"+number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
