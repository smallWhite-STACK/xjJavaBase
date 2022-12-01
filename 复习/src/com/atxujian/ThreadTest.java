package com.atxujian;

/**
 * @author xujian
 * @create 2022-11-18 16:58
 */
public class ThreadTest {

    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne();
        ThreadTwo threadTwo = new ThreadTwo();
        Thread threadTwoo = new Thread(threadTwo);
        System.out.println(threadOne.getPriority());
        System.out.println(threadTwoo.getPriority());
        threadOne.start();
        threadTwoo.start();


    }

}
class ThreadOne extends Thread{
    @Override
    public void run() {
        super.run();
        for(int i=0;i<100;i++){
            if((i+1)%2==0){
                System.out.print(" 奇"+i);
            }
        }

    }
}
class ThreadTwo implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.print(" 偶"+i);
            }
        }
    }
}
