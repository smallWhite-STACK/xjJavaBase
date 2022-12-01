package threadTest;

public class ThreadTest {

    public static void main(String[] args) {
		/*
		 * Thread myThread1 = new MyThread("A"); // 创建一个新的线程 myThread1 此线程进入新建状态
		 * myThread1.start(); // 调用start()方法使得线程进入就绪状态 Thread myThread2 = new
		 * MyThread("B"); // 创建一个新的线程 myThread2 此线程进入新建状态 myThread2.start(); //
		 * 调用start()方法使得线程进入就绪状态
		 */    
    	Thread myThread1 = new MyThread("A");     // 创建一个新的线程  myThread1  此线程进入新建状态
        Thread myThread2 = new MyThread("B");     // 创建一个新的线程 myThread2 此线程进入新建状态
        myThread1.start();  // 调用start()方法使得线程进入就绪状态
        myThread2.start();  // 调用start()方法使得线程进入就绪状态
   }
}

