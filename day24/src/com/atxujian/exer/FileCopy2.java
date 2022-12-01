package com.atxujian.exer;

import java.io.*;

/**
 * @author xujian
 * @create 2020-03-10 18:18
 */

/*利用处理流实现的非文本的复制，
通过设置相同的byte数组长度，比较执行时间
*
*
* */
public class FileCopy2 {


    public void copyFile(File srcfile, File destfile){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //2.造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(srcfile);
            FileOutputStream fos = new FileOutputStream(destfile);

            //2.2造处理流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.调用read与write
            byte[] bytes = new byte[1024];
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
                    System.out.println("执行成功");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        FileCopy2 fileCopy2 = new FileCopy2();
        //新建File

        File srcfile = new File("C:\\Users\\dell\\Desktop\\test1.avi");
        File destfile = new File("C:\\Users\\dell\\Desktop\\copy2.avi");
        long start = System.currentTimeMillis();
        fileCopy2.copyFile(srcfile, destfile);
        long end = System.currentTimeMillis();

        System.out.println("耗费时间为"+(end-start)+"毫秒");
    }
}
