package com.atxujian.java3;

import org.junit.Test;

import java.io.*;

/**
 * @author xujian
 * @create 2020-03-12 15:01
 */
public class OtherStream {

    /*1.输入输出流
    * 从键盘输入字符串，要求将读取的整行字符串转成大写输出，然后继续进行输入操作
    * 直至当输入“e”或者“exit”，退出程序。
    *
    *
    * 方法一：Scanner通过使用Scanner的对象调用nextInt\nextLine等方法
    * 方法二：使用System.in实现 System.in--->转换流--->BufferedReader的readLine()
    *
    * */

    public static void main(String[] args) {

       /* Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        System.out.println(s1.toUpperCase());*/

        //方法二：使用System.in实现 System.in--->转换流--->BufferedReader的readLine()
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while(true){
                System.out.println("请输入字符串");
                String s = br.readLine();
                if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)) {
                    System.out.println("程序结束");
                    break;
                }
                String toUpperCase = s.toUpperCase();
                System.out.println(toUpperCase);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

   /*2.打印流
   * */
    @Test
    public void test1(){
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("text.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
        ps = new PrintStream(fos, true);

        if (ps != null) {
// 把标准输出流(控制台输出)改成文件
            System.setOut(ps);
        }
        for (int i = 0; i <= 255; i++) {
            // 输出ASCII字符
          System.out.print((char) i);
          if (i % 50 == 0) {
              // 每50个数据一行
          System.out.println();
          // 换行
                         }
                     }
                 }
          catch (FileNotFoundException e) {
              e.printStackTrace();
             } finally {
              if (ps != null) {
               ps.close();
           }
        }
  }

    /*
    *3.数据流：
    * 3.1DataInputStream与DataOutputStream  没有Reader与Writer
    * 3.2作用：用于读取或写出基本数据类型的变量或字符串
    *
    *
    * 练习：将内存中的字符串，基本数据类型的变量写出到文件中
    *
    * 异常处理：依然是try-catch-finally
    * */
     @Test
    public void test2() throws IOException {
         DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

         //写出
         dos.writeUTF("徐健");
         dos.flush();   //刷新操作，将内存中的数据写入文件
         dos.writeInt(20);
         dos.flush();
         dos.writeBoolean(true);

         //关闭流
         dos.close();

     }

     /*数据读入DataInputStream
     * 将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中
     *
     * 注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致！
     *
     *
     * */
     @Test
    public void test3() throws IOException {
         DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));

         //读入
         String name = dis.readUTF();
         int age = dis.readInt();
         boolean isMale = dis.readBoolean();
         System.out.println(name+"    "+age+"    "+isMale);

         //关闭流
         dis.close();



     }
}
















