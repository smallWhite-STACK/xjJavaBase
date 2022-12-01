package com.atxujian;

import java.util.concurrent.*;

/**
 * @author xujian
 * @create 2022-11-18 20:12
 */
public class CallableTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println(executorService.getClass()); //ThreadPoolExecutor
        ThreadPoolExecutor exec = (ThreadPoolExecutor) executorService;

        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);
        exec.submit(futureTask);

        System.out.println("0000000");



        //我们可使用get方法接收FutureTask的返回值
        try {
            Object sum = futureTask.get();
            System.out.println("100以内所有偶数的和为："+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        exec.shutdown();
    }

}
class MyThread implements Callable{
    private int number = 1;

    @Override
    public Object call() {
        int sum = 0;
        while(number<=100){
            if(number%2==0){
                System.out.println("偶数"+number);
                sum+=number;
            }
            number++;
        }
        return sum;
    }
}
