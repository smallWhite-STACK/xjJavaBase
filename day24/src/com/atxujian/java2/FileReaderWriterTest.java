package com.atxujian.java2;

import org.junit.Test;

import java.io.*;

/**
 * @author xujian
 * @create 2020-03-07 18:34
 */

/*本节包含三个实验
* 1.文件的读取
* 2.文件的写入
* 3.文件的写入与读取-----相当于文件的复制
*
* */

public class FileReaderWriterTest {
/*将day24的hello.txt读入程序中，并输出到控制台
* */
public static void main(String[] args) {

}
    @Test
    public void testFileReader() {
        //四步
        // 实例化一个File---->提供具体的流----->读入------->关闭流
        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");
            fileReader = new FileReader(file);

            int data = fileReader.read();
            while(data!=-1){
                System.out.print((char) data);
                data=fileReader.read();
            }
/*
两个while只是形式上不同
        int data1;
        while((data1=fileReader.read()!=-1){
            System.out.print((char)data1);
        }*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //为close加上一个选择条件，fileReader不为空，才执行close(),避免异常
            try {
                if(fileReader!=null)
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    //read重载
    public void testFileReader1() {
        //还是四步走    第三步读取发生变化
        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");
            fileReader = new FileReader(file);

            char[] chars = new char[5];
            int data;//每次读取的字符的长度
/*
  //错误实例    //结果是helloworld123
            while((data=fileReader.read(chars)) != -1){
                //遍历data
                for (int i = 0; i <chars.length ; i++) {
                    System.out.print(chars[i]);
                }
            }*/

 //正确实例    //结果是helloworld
            while((data=fileReader.read(chars)) != -1){
                //遍历data

                //用String或者for循环都可以遍历文件
               /* for (int i = 0; i <data ; i++) {
                    System.out.print(chars[i]);
                }*/
                String s = new String(chars, 0,data);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    /*
    * FileWriter：
    * 说明
    *       1.输出操作，对应的File可以不存在，并不会报异常
    *       2.File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件
    *         File对应的硬盘中如果存在：
    *                 如果流使用的构造器是：FileWriter(file,false)/FileWriter(file):对原有的文件覆盖
    *                 如果流使用的构造器是：FileWriter(filee,true):不会对原有的文件覆盖，而是在原有文件的基础上追加内容
    * */
    public void WriterTest()  {
        //四步骤
        /*
        * 实例化file
        * 选择写出流
        * write加东西
        * 关闭流close()
        * */
        FileWriter fileWriter = null;
        try {
            File file = new File("hello1.txt");
            //FileWriter fileWriter = new FileWriter(file);
            //默认值default为false，进行覆盖
            //FileWriter fileWriter = new FileWriter(file,false);

            //如果为true ,则是在原有的基础上，添加
            fileWriter = new FileWriter(file,true);

            //fileWriter.write("I hava a dream,");
            fileWriter.write("you should have a dream");
            fileWriter.write("123");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {if(fileWriter!=null){
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
    }

    @Test
    public void testFileReaderFileWriter() {
        //依然四步骤
        //①创建File类的对象，指明读入与读出的文件
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            File srcfile = new File("hello.txt");
            File destfile = new File("hello2.txt");

            //②创建输入输出流的对象,,读入文件不能为空
            fileReader = new FileReader(srcfile);
            fileWriter = new FileWriter(destfile);

            //③数据的读入与写出操作
            char[] c = new char[5];
            int read;
            while((read = fileReader.read(c))!=-1){
                fileWriter.write(c,0,read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //④关闭流资源,顺序不要求
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
