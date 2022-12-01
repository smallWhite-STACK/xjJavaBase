package com.atxujian.java3;

import org.junit.Test;

import java.io.*;

/**
 * @author xujian
 * @create 2020-03-10 20:35
 */
//处理流之二：转换流
public class InputStreamReaderTest {
/*处理流之二：转换流的使用
*   InputStreamReader：将一个字节的输入流转换为字符的输入流
*   OutputStreamWriter:将一个字符的输出流转换为字节的输出流
*
* 2.作用：提供字节流与字符流之间的转换
*
* 3.解码：字节或字节数组---》字符数组或字符串
*   编码：字符数组或字符串---》字节或字节数组
*
* 4.字符集
*
* */

//InputStreamReader
@Test
    public void test1() {
    InputStreamReader isr = null;
    try {
        File file = new File("dbcp.txt");

        FileInputStream fr = new FileInputStream(file);
        //使用默认的字符集，默认的字符集是由文件保存时的字符集所决定的
        //InputStreamReader isr = new InputStreamReader(fr);
        isr = new InputStreamReader(fr,"utf-8");

        char[] chars= new char[20];
        int data;
        while((data=isr.read(chars))!=-1){
            String s = new String(chars,0,data);
            System.out.print(s);
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if(isr!=null){
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
* 总和使用InputStreamReader与OutputStreamWriter*/
@Test
    public void test2(){
    //总体与之前相似
    //1.2.建文件 建流
    InputStreamReader isr = null;
    OutputStreamWriter osw = null;
    try {
        FileInputStream fis= new FileInputStream(new File("dbcp.txt"));
        FileOutputStream fos= new FileOutputStream(new File("dbcp_gbk.txt"));

        isr = new InputStreamReader(fis,"UTF-8");
        osw = new OutputStreamWriter(fos,"gbk");

        //3.使用read与write
        char[] chars=new char[20];
        int data;
        while((data=isr.read(chars))!=-1){
            osw.write(chars, 0, data);
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        //4.关闭流
        if(isr!=null){
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(osw!=null){
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
}
