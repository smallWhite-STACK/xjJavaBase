package com.atxujian.java1;

/**
 * @author xujian
 * @create 2020-02-11 14:04
 */
//对应 印象笔记的  多线程440
/*
* 生产者消费者问题
* 生产者（Productor）、店员（Clerk）、消费者（Customer）*/

/*分析：
* 1.是否是多线程问题：是
* 2.是否有共享数据（线程安全问题）
* 3.如何解决线性安全问题：同步机制（三种方法）
* 4.是否涉及线性通信问题
* */

class Clerk{

    private int count=20;
    public synchronized void product(){
        notify();
        if(count<20) {
            count++;
            System.out.println(Thread.currentThread().getName() + "生产第" + count + "件产品");
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
     public synchronized void custom(){
        if(count>1) {
            System.out.println(Thread.currentThread().getName() + "消费第" + count + "件产品");
            count--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Productor extends Thread{

    private Clerk clerk;
    public Productor(Clerk clerk){
        this.clerk = clerk;
    }


    @Override
    public void run() {
        System.out.println("生产者一开始生产产品");
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                clerk.product();
        }
    }
}
class Customer extends Thread {
    private Clerk clerk;
    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费产品");
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                clerk.custom();
        }
    }
}
public class ProduceTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor produce = new Productor(clerk);
        produce.setName("生产者一");
        Customer customer = new Customer(clerk);
        customer.setName("消费者一");
        produce.start();
        customer.start();
    }
}
