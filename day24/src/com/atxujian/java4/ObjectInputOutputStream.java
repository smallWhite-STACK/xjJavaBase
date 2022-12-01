package com.atxujian.java4;

import org.junit.Test;

import java.io.*;


/**
 * @author xujian
 * @create 2020-03-13 15:58
 */
//搞序列化test1  与   反序列化test2
//对于对象流，可以操作对象，使用的方法为writeObject   readObject

public class ObjectInputOutputStream {

@Test
    public void test1(){

    //这属于字节流的范畴，为了不让看得到的文件的内容（会有乱码），所以我故意把后缀名改为不可读的
    ObjectOutputStream oos = null;
    try {
        oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
        oos.writeObject(new String("I love China!!!"));
        oos.flush();
        oos.writeInt(40000);
        oos.flush();

        oos.writeObject(new Person("徐健",20));
        oos.flush();

        oos.writeObject(new Person("徐大大",21,new Acount(4500.00)));
        oos.flush();


    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if(oos!=null){
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
  }
  @Test
    public void test2() throws IOException, ClassNotFoundException {
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));

      //这与数据流相似，依然按照序列化时的顺序反序列化
      String o = (String )ois.readObject();
      int i = ois.readInt();
      Object o1 = ois.readObject();
      Object o2 = ois.readObject();
      System.out.println(o);
      System.out.println(i);
      System.out.println(o1);
      System.out.println(o2);
      ois.close();
  }

}
