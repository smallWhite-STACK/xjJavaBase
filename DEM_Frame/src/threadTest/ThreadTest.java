package threadTest;

public class ThreadTest {

    public static void main(String[] args) {
		/*
		 * Thread myThread1 = new MyThread("A"); // ����һ���µ��߳� myThread1 ���߳̽����½�״̬
		 * myThread1.start(); // ����start()����ʹ���߳̽������״̬ Thread myThread2 = new
		 * MyThread("B"); // ����һ���µ��߳� myThread2 ���߳̽����½�״̬ myThread2.start(); //
		 * ����start()����ʹ���߳̽������״̬
		 */    
    	Thread myThread1 = new MyThread("A");     // ����һ���µ��߳�  myThread1  ���߳̽����½�״̬
        Thread myThread2 = new MyThread("B");     // ����һ���µ��߳� myThread2 ���߳̽����½�״̬
        myThread1.start();  // ����start()����ʹ���߳̽������״̬
        myThread2.start();  // ����start()����ʹ���߳̽������״̬
   }
}

