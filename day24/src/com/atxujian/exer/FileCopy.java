package com.atxujian.exer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xujian
 * @create 2020-03-10 14:09
 */
/*
*
* 使用字节流来复制
*
*
* */
public class FileCopy {
    public void copyFile(File srcfile, File destfile){
        FileInputStream in= null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(srcfile);
            out = new FileOutputStream(destfile);

            //3
            byte[] bytes = new byte[1024];
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

    public static void main(String[] args) {
        FileCopy fileCopy = new FileCopy();

        File file = new File("C:\\Users\\dell\\Desktop\\test1.avi");
        File file1 = new File("C:\\Users\\dell\\Desktop\\copy1.avi");

        long start = System.currentTimeMillis();

        fileCopy.copyFile(file, file1);

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为"+(end-start)+"毫秒");
    }


}
