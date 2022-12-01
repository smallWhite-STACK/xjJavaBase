package com.atxujian.exer;

import java.io.File;

/**
 * @author xujian
 * @create 2020-03-09 21:24
 */
public class Exer1 {
    /*3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
         拓展1：并计算指定目录占用空间的大小
         拓展2：删除指定文件目录及其下的所有文件
*/
    public static void main(String[] args) {
        Exer1 exer1 = new Exer1();
        File file = new File("D:\\39xu");
        exer1.cycleDirs(file);

    }

    public void panduan(File file){
            if(file.isDirectory()){
                File[] files = file.listFiles();
                for (File f:files){
                    System.out.println(f.getName());
                    if(f.isDirectory()){
                        cycleDirs(f);
                    }
                }
            }else{
                System.out.println(file.getName());
            }
    }
    public void cycleDirs(File f) {
        while(f.isDirectory()){
            File[] files = f.listFiles();
            for(File f1:files){
                if(f1.isDirectory()){
                    System.out.println(f1.getName());
                    f=f1;
                }else{
                    f=f1;
                    System.out.println(f1.getName());
                    break;
                }
            }
        }


    }

}
