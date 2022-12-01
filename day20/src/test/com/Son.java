package test.com;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Son{

    public static void main(String[] args) {
        //到这里就不要在thorws，不合适，再抛就是给虚拟机了
//        这里使用try-catch

        try {
            method2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public static void method2() throws IOException{
        method1();
    }
    @Test
    public static void method1() throws FileNotFoundException, IOException {

            File file = new File("test.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            int a =  fileInputStream.read();
            while(a != -1){
                System.out.print((char)a);
                a = fileInputStream.read();
            }
            fileInputStream.close();

    }
}