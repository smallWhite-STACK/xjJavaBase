package com.atxujian.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*test:关于类加载器的加载
* test1:配置文件的加载*/
/**
 * @author xujian
 * @create 2020-03-18 17:07
 */
public class ClassLoaderTest {
    @Test
    public void test(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);                        //sun.misc.Launcher$AppClassLoader@18b4aac2
        //调用系统类加载器的getParent():获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);                       //sun.misc.Launcher$ExtClassLoader@452b3a41
        //调用扩展类加载器的getParent()无法获取引导类加载器
        //引导类加载器主要负责的加载java的核心类库，无法加载自定义类的
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);                       //null

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);                       //null
    }

    @Test  //加载配置问价
    public void test1() throws IOException {
        //关于Properties
        //方式一：
        Properties pos = new Properties();
        // 此时默认的配置文集的位置是在模块下,但是路径是可以修改的
        //因为我们是在test单元下，所以我们新建一个Properties是在模块下面新建
        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        //FileInputStream fileInputStream = new FileInputStream("src\\jdbc1.properties");
        pos.load(fileInputStream);

        //使用getProperty的方法
        String user = pos.getProperty("user");
        String password = pos.getProperty("password");

        System.out.println(user+": "+password);
    }

    @Test
    public void test2() throws IOException {
        //方式二：用类加载器及其方法getResourceAsStream
        Properties pos = new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        // 此时默认的配置文集的位置是在src下
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pos.load(is);

        //使用getProperty的方法
        String user = pos.getProperty("user");
        String password = pos.getProperty("password");

        System.out.println(user+": "+password);


    }
}
