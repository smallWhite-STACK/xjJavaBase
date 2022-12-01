package com.atxujian.java1;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author xujian
 * @create 2020-02-12 10:15
 */
class NumberThread implements Runnable{
    @Override
    public void run() {
       for(int i=1;i<=100;i++){
           System.out.println(Thread.currentThread().getName()+"输出第"+i+"个数");
       }
    }
}
class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"输出偶数"+i);
            }

        }
    }
}
//关于Callable的实现
class NumberThread2 implements Callable {
    @Override
    public Object call() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "输出奇数" + i);
            }
        }
        return 0;
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //创建线程池Executors(两个API Executors与ExecutorService)
        ExecutorService service = Executors.newFixedThreadPool(10);

        //通过下面的解释，可以知道做出下面强制转换
        ThreadPoolExecutor service1=(ThreadPoolExecutor) service;
//设置线程池的属性
        /*（但是ExecutorService只是一个接口，接口属性比较少，而且还是常量，所以service中没有多少方法）
        所以找接口实现类的对象，利用getClass()方法去找这个实现接口的类
        利用Ctrl+Shift+T搜索此类
        通过搜索找到ThreadPoolExecutor是继承了AbstractExecutorService类，而这个类继承了接口ExecutorService
        */
        //System.out.println(service.getClass());//class java.util.concurrent.ThreadPoolExecutor
  // 此时做出强制转换后可以设置线程池的属性，而直接通过service设置则不可以

     /*   service1.setCorePoolSize(15);
        service1.setCorePoolSize();*/



        //执行
        service.execute(new NumberThread());//适合Runnable，选择是实现Runnable参数接口的类的对象,此时无需调用run()方法
        service.execute(new NumberThread1());

        service.submit(new NumberThread2());//适合Callable
        //service.submit(Callable callable);
        /*不需要以下操作
        NumberThread2 numberThread2 = new NumberThread2();
        FutureTask futureTask = new FutureTask(numberThread2);
        service.submit(futureTask);//适合Callable*/

        //关闭线程池
        service.shutdown();
    }
}
