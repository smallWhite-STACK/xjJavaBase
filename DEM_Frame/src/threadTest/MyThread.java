package threadTest;

public class MyThread extends Thread {
    
    private String name;
    
    public MyThread(String name){
        this.name = name;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "����  ��" + i);
        }
    }
}
