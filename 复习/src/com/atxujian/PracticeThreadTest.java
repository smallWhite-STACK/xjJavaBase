package com.atxujian;

/**
 * @author xujian
 * @create 2022-11-18 19:03
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元， 每次存1000， 存3次。每次存完打
 * 印账户余额。
 * 问题： 该程序是否有安全问题，如果有，如何解决？
 * 【提示】
 * 1，明确哪些代码是多线程运行代码，须写入run()方法
 * 2， 明确什么是共享数据。
 * 3，明确多线程运行代码中哪些语句是操作共享数据的。
 * 拓展问题：可否实现两个储户交替存钱的操作
 */
public class PracticeThreadTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread number1 = new Thread(number);
        Thread number2 = new Thread(number);
        number1.setName("线程1");
        number2.setName("线程2");

        number1.start();
        number2.start();
    }
}
class Number implements  Runnable{
    private int i = 1;

    @Override
    public void run() {
        while(true){
            synchronized (this){
                notify();

                if (i<=100){
//                    try {
//                        Thread.sleep(100);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }

                    System.out.println(Thread.currentThread().getName()+":"+i);
                    i++;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
        }

        }
    }
}
