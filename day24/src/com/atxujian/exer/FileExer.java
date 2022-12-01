package com.atxujian.exer;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author xujian
 * @create 2020-03-07 16:20
 */

/*
*
* 1. 利用File构造器，new 一个文件目录file
*   1)在其中创建多个文件和目录
*   2)编写方法，实现删除file中指定文件的操作
2. 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
拓展1：并计算指定目录占用空间的大小 拓展2：删除指定文件目录及其下的所有文件
*/
public class FileExer {
    @Test
    public void test1() throws IOException {
        //假定我们在D盘创建一个目录为 D：//file目录
        File file1 = new File("D:\\file\\file1");
        if(!file1.exists()){
        boolean mkdirs = file1.mkdirs();
            System.out.println("目录file创建成功，并且创建了file1");
        }else{
            System.out.println("file已存在，创建file1成功");
        }

        File txt1 = new File("D:\\file\\xujian.txt");
        boolean newFile = txt1.createNewFile();
        if(newFile){
            System.out.println(txt1.getName()+"创建成功");
        }

        boolean delete = file1.delete();
        if(delete){
            System.out.println("file1删除成功");
        }
    }
@Test
//2. 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
        public void test2(){
        File file = new File("C:\\Users\\dell\\Desktop\\pictures");
        String[] list = file.list();
        //我们先遍历一下数组，确定有jpg结尾的图片
        for(String str:list){
            System.out.println(str);
        }
        //然后我们可以使用String特有的endsWith 方法判断jpg
        int count=0;
        for(String str:list){
            if(str.endsWith("jpg")){
                count++;
                System.out.println(str);
            }
        }
    System.out.println("一共"+count+"张jpg的图片");
    }
@Test
/*3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
拓展1：并计算指定目录占用空间的大小
拓展2：删除指定文件目录及其下的所有文件*/
    public void test3(){
    File file = new File("D:\\file");
    File[] files = file.listFiles();
    for(File f:files){
        if(f.isDirectory()){
            File[] files1 = f.listFiles();
            for(File f1:files1){
                System.out.println(f1+"  长度  "+f1.length());
            }
        }
        System.out.println(f+"  长度  "+f.length());
    }
}


}



