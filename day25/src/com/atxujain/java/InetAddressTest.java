package com.atxujain.java;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author xujian
 * @create 2020-03-14 21:57
 */
/*讲一下：
1.InetAddress的两个初始化方式 调用静态函数
2.获取本机IP地址的方法
2.使用InetAddress的常用方法:获取域名   获取主机的IP地址

* */
public class InetAddressTest {

    @Test
    public void test() throws UnknownHostException {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        System.out.println(address);  ///127.0.0.1

       InetAddress address1 = InetAddress.getByName("www.atguigu.com");
       System.out.println(address1);//www.atguigu.com/183.218.12.243

        InetAddress address2 = InetAddress.getLocalHost();
        System.out.println(address2);   //  联网时：DESKTOP-7BJ18P1/192.168.43.239
                                        //没有联网时：DESKTOP-7BJ18P1/127.0.0.1
        String hostName = address1.getHostName();
        System.out.println(hostName);    //www.atguigu.com


         String hostAddress = address1.getHostAddress();
         System.out.println(hostAddress);//183.218.12.243


        System.out.println(address2.getHostName());  //本机的域名
        System.out.println(address2.getHostAddress());  //127.0.0.1

    }
}
