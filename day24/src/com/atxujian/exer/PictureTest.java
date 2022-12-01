package com.atxujian.exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xujian
 * @create 2020-03-10 19:43
 */

/*图片加密test1 与 解密test2 */
public class PictureTest {
   @Test
    public void test1(){
       FileInputStream fis = null;
       FileOutputStream fos = null;
       try {
           fis = new FileInputStream("hpu.png");
           fos = new FileOutputStream("hpuMimi.png");

           byte[] buffer = new byte[20];
           int data;
           while((data=fis.read(buffer))!=-1){
              // fos.write(bytes, 0, data);
//错误加密   这样buffer中的每一个字节并没有改变
              /* for(byte b:buffer){
                   //强转
                   b=(byte)(b^5);
               }
               fos.write(buffer, 0, data);*/

//正确加密
                for(int i=0;i<data;i++){
                    buffer[i]=(byte)(buffer[i]^5);
               }
               fos.write(buffer, 0, data);
           }
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           if(fis!=null){
               try {
                   fis.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if(fos!=null){
               try {
                   fos.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }

   }
    @Test
    public void test2(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("hpuMimi.png");
            fos = new FileOutputStream("hpuJiemi.png");

            byte[] buffer = new byte[20];
            int data;
            while((data=fis.read(buffer))!=-1){
                for(int i=0;i<data;i++){
                    buffer[i]=(byte)(buffer[i]^5);
                }
                fos.write(buffer, 0, data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
