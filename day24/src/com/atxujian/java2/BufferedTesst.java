package com.atxujian.java2;

import org.junit.Test;

import java.io.*;

/**
 * @author xujian
 * @create 2020-03-10 16:48
 */

/*
* 处理流之一：缓冲流的使用
*
* 1.缓冲流
* BufferedInputStream
* BufferedOutputStream
* BufferedReader
* BufferedWriter
*
*
* 2.作用：提供流的读取、写入的速度
*           提高读写速度的原因：内部提供了一个缓冲区
*
* 3.处理流：套接在已有的“流”的外面
* */


public class BufferedTesst {
/*
* 实现非文本的复制
* */
@Test
    public void bufferedInputOutputStreamTest(){
    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;

    try {
        //1造文件
        File srcFile = new File("hpu.png");
        File destFile = new File("hpu2.png");

        //2.造流
        //2.1造节点流
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);

        //2.2造处理流
        bis = new BufferedInputStream(fis);
        bos = new BufferedOutputStream(fos);

        //3.调用read与write
        byte[] bytes = new byte[5];
        int data;
        while((data=bis.read(bytes))!=-1){
            bos.write(bytes, 0, data);
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        //4关闭流
        //本来需要关闭四个流，而且先关闭外部流（处理流），
        //但是由于外部流的关闭，内部流也被关闭了，所以内部流不需要关闭
        if(bos!=null){
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(bis!=null){
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
* 使用BufferedReader和BufferedWriter*/
@Test
    public void bufferedReaderWriterStreamTest() {
    /*//1.搞File
    File srcfile = new File("开发手册.pdf");
    File destfile = new File("copy开发手册.pdf");

    //2.造流  四个流
    FileReader fr = new FileReader(srcfile);
    FileWriter fw = new FileWriter(destfile);
    BufferedReader bufferedReader = new BufferedReader(fr);
    BufferedWriter bufferedWriter = new BufferedWriter(fw);
    */

    //1与2 的合集    File的初始化和造流可以写在一起
    BufferedReader br= null;
    BufferedWriter bw = null;
    try {
        //pdf不属于文本格式
        br = new BufferedReader(new FileReader(new File("hi.txt")));
        bw = new BufferedWriter(new FileWriter(new File("hi2.txt")));

/*        //3第一类：  调用read与writer
        char[] chars=new char[1024];
        int data;
        while((data=br.read(chars))!=-1){
            bw.write(chars, 0, data);
        }
*/

        //3第二类    ：使用读一行的方法readline()与String类型的data
        String data;
    while((data=br.readLine())!=null){
        //第一种
  //      bw.write(data+"/n");
        //第二种
        bw.write(data);
        bw.newLine();
    }



    } catch (IOException e) {
        e.printStackTrace();
    }

    finally {
        //4.关闭流
        if(br!=null){
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(bw!=null){
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
}
