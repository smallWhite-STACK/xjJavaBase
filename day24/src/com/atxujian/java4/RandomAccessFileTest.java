package com.atxujian.java4;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author xujian
 * @create 2020-03-14 10:46
 */
/*test1:复制
* test2:介绍seek方法
* test3:实现插入   ---》可以使用ByteArrayOutputStream--->详见exer中*/


/*
 * RandomAccessFile的使用：
 * ①RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * ②RandomAccessFie既可以作为一个输入流，又可以作为一个输出流
 * ③如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则执行过程中自动创建
 *       如果写出到的文件存在，则会对原有的文件内容进行覆盖（默认情况下：从头覆盖）
 *       注意区分覆盖原文件与对源文件的内容进行覆盖的区别
 *注意方法：void seek(long pos)
 *          long getFilePointer()
 *
 *  ④
 *  思考题：如何让其实现插入的效果，而不是覆盖
 * */
public class RandomAccessFileTest {
    @Test
    public void test1(){
        RandomAccessFile r = null;
        RandomAccessFile rw = null;
        try {
            //复制(字节  字符)
            r = new RandomAccessFile("hpu.png", "r");
            rw = new RandomAccessFile("314hpu.png", "rw");

            byte[] bytes = new byte[1024];
            int data;
            while((data=r.read(bytes))!=-1){
                rw.write(bytes,0,data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(r!=null){
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(rw!=null){
                try {
                    rw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test2(){
        RandomAccessFile rw = null;
        try {
            //向文本中插入内容
            rw = new RandomAccessFile("hi.txt", "rw");
            //在没有使用seek方法时，默认从头对文件内容进行覆盖，使用seek可以得到指针的位置，随机插入，这体现了Random
            // rw.write("zz".getBytes());
            //我们也可以使用seek方法确定插入位置
            rw.seek(3);
            rw.write("yy".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(rw!=null){
                try {
                    rw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*实现插入而非覆盖
    *       而且对于多行的也能处理
    * */
    @Test
    public void test3() throws IOException {
        RandomAccessFile rw = new RandomAccessFile("hi.txt", "rw");

        //先确定自己要插入的seek位置 ，然后利用write将其之后的字符全部写出到StringBuffer中
        //再将seek放回原来的位置，等read完后，再将StringBuffer中的内容放回
    //其中考虑StringBuffer长度，给一个起始的长度（利用File的length方法）

        //确定插入点
        rw.seek(3);
        //将其之后的内容截取到StringBuffer（内存）（利用read 写到内存中）
        StringBuffer buffer = new StringBuffer((int)new File("hi.txt").length());
        byte[] bytes = new byte[20];
        int data;
        while((data=rw.read(bytes))!=-1){
            buffer.append(new String(bytes,0,data));
        }

        //将指针回到插入点
        rw.seek(3);
        rw.write("123".getBytes());

        //将buffer的内容写回去
        rw.write(buffer.toString().getBytes());


        rw.close();

    }

}
