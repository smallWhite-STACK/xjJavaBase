package com.atxujian.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author xujian
 * @create 2020-03-07 13:33
 */
/*
* 常用方法：  8个
*  public String getAbsolutePath()：获取绝对路径
*  public String getPath() ：获取路径
*  public String getName() ：获取名称
*  public String getParent()：获取上层文件目录路径。若无，返回null
*  public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
*  public long lastModified() ：获取最后一次的修改时间，毫秒值
 public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
 public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组

 File类的重命名功能
 public boolean renameTo(File dest):把文件重命名为指定的文件路径

* */
public class FileTest {

     @Test
     public void test1(){
          //三种构造器---还在内存里面
          //8个常用方法
          File  file1 = new File("hello.txt");   //此时的路径实在day24下面而不是src下面
          File file2 = new File("D:\\UserIntellijIDEA\\IO", "hi.txt");

          //对比相对路径与绝对路径下的方法输出
          System.out.println(file1.getAbsoluteFile());//D:\UserIntellijIDEA\IdeaProjectsAnd\day24\hello.txt
          System.out.println(file1.getPath());   //hello.txt
          System.out.println(file1.getName());  //hello.txt
          System.out.println(file1.getParent()); //null
          System.out.println(file1.length());  //13
          System.out.println(new Date(file1.lastModified()));  //Sat Mar 07 21:04:44 CST 2020
          System.out.println();

          System.out.println(file2.getAbsoluteFile()); //D:\UserIntellijIDEA\IO\hi.txt
          System.out.println(file2.getPath());  //D:\UserIntellijIDEA\IO\hi.txt
          System.out.println(file2.getName()); //hi.txt
          System.out.println(file2.getParent());//D:\UserIntellijIDEA\IO
          System.out.println(file2.length());  //6
          System.out.println(file2.lastModified());   //1583564826683
     }
     @Test
     public void test2(){
          //两个数组  list  listFile
     File file = new File("D:\\UserIntellijIDEA");
     String[] list = file.list();
     for(String str: list){
          System.out.println(str);
     }

     System.out.println();

     File[] files = file.listFiles();
     for(File f: files){
          System.out.println(f);
     }

}
     @Test
     public void test3(){
          //重命名    不能实现覆盖
     File file = new File("hello.txt");
    // File file1 = new File();
     boolean b = file.renameTo(new File("D:\\UserIntellijIDEA\\IO\\hi.txt"));
     System.out.println(b);
}

/*   判断6个方法
 public boolean isDirectory()：判断是否是文件目录
  public boolean isFile() ：判断是否是文件
  public boolean exists() ：判断是否存在
  public boolean canRead() ：判断是否可读
  public boolean canWrite() ：判断是否可写
  public boolean isHidden() ：判断是否隐藏
* */
@Test
     public void test4(){
     File file = new File("hello.txt");

     System.out.println(file.isDirectory());
     System.out.println(file.isFile());
     System.out.println(file.exists());
     System.out.println(file.canRead());
     System.out.println(file.canWrite());
     System.out.println(file.isHidden());
     System.out.println();
     File file1 = new File("D://UserIntellijIDEA\\IO");
     System.out.println(file1.isDirectory());
     System.out.println(file1.isFile());
     System.out.println(file1.exists());
     System.out.println(file1.canRead());
     System.out.println(file1.canWrite());
     System.out.println(file1.isHidden());
}

/*
*  File类的创建功能
* 在磁盘中创建对应的文件或文件目录
*
 public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
 public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。 如果此文件目录的上层目录不存在，也不创建。
 public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下。

 public boolean delete()：删除文件或者文件夹
删除不走回收站

*/
@Test
     public void test5() throws IOException {
     //创建与删除  真正的在硬盘中创建了
     File file = new File("hi.txt");
     if(!file.exists()){
          file.createNewFile();
          System.out.println("创建成功");
     }else{
          file.delete();
          //文件已存在，删除成功
     }

     long l = file.lastModified();
     System.out.println(l);
     Date date = new Date(l);
     System.out.println(date);
}







}
