package com.atxujian;

/**
 * @author xujian
 * @create 2022-11-18 21:17

        生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
        取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
        生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
        知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
        果店中有产品了再通知消费者来取走产品。
*/
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Thread productorThread = new Thread(new Productor(clerk));
        Thread consumerThread = new Thread(new Consume(clerk));
        productorThread.start();
        consumerThread.start();
    }
}

class Clerk { // 售货员
    private int product = 0;
    public synchronized void addProduct() {
        if (product >= 20) {
            try {
                wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        } else {
            product++;
            System.out.println("生产者生产了 第" + product + "个产品");
            notifyAll();
        }
    }
    public synchronized void getProduct() {
        if (this.product <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("消费者取走了第" +
                    product + "个产品");
            product--;
            notifyAll();
        }
    }
}

class Productor implements Runnable { // 生产者
    Clerk clerk;
    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }
    public void run() {
        System.out.println("生产者开始生产产品");
        while (true) {
            try {
                Thread.sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}

class Consume implements Runnable { // 消费者
    Clerk clerk;
    public Consume(Clerk clerk) {
        this.clerk = clerk;
    }
    public void run() {
        System.out.println("消费者开始取走产品");
        while (true) {
            try {
                Thread.sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.getProduct();
        }
    }
}
