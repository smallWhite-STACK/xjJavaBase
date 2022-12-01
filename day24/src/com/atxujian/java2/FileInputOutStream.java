package com.atxujian.java2;

import org.junit.Test;

import java.io.*;

/**
 * @author xujian
 * @create 2020-03-10 11:34
 */
public class FileInputOutStream {

    @Test
    public void testFileInputOutStream() {
        //这个步骤与FileReaderWriter相似
        //四步走
        //1
        FileInputStream in= null;
        FileOutputStream out = null;
        try {
            File srcfile=new File("hpu.png");
            File destfile = new File("hpu1.png");

            //2
            in = new FileInputStream(srcfile);
            out = new FileOutputStream(destfile);

            //3
            byte[] bytes = new byte[5];
            int data;
            while((data=in.read(bytes))!=-1){
                out.write(bytes,0,data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
//指定文件下的文件的复制


}
