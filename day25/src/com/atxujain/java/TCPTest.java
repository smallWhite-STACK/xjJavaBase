package com.atxujain.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xujian
 * @create 2020-03-14 21:05
 */
/*基于TCP的Socket编程
* 三个例题  2与3在exer包下
*
* 1.客户端发送内容给服务端，服务端将内容打印到控制台上。
2.客户端发送文件给服务端，服务端将文件保存在本地。
3.从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给 客户端。并关闭相应的连接。
*/
public class TCPTest {

    //1.客户端发送内容给服务端，服务端将内容打印到控制台上。
    //客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        try {
            //四个步骤
            //1.创建Socket（初始化）
        /*注意ID与端口号都是写服务器的，这里特殊，因为我们的服务端也是我们本身
        注意，端口号范围1024~49151
        */
            InetAddress address = InetAddress.getByName("127.0.0.1");
            socket = new Socket(address, 3307);

            //2.打开连接到Socket的输入/输出流 （这里我们输出）
            os = socket.getOutputStream();

            //3.按照一定的协议对Socket进行读写操作
            os.write("你好，我是客服mm".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭Socket(流与Socket都要关闭)
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*服务端*/
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //四个步骤
            //1.调用ServerSocket,创建服务器端套接字，并绑定指定指定端口
            serverSocket = new ServerSocket(3307);

            //2.监听连接请求
            socket = serverSocket.accept();

            //3.获取输入/输出流，开始网络数据的发送接收(这里是输入)
            is = socket.getInputStream();

            //方式一:缺陷，这是针对字节流的，要是有汉字，会出现乱码
       /* byte[] bytes = new byte[1024];
        int data;
        while((data=is.read())!=-1){
            String s = new String(bytes, 0, data);*/
            //方式二:ByteArrayInputStream
            baos = new ByteArrayOutputStream();
            byte[] bytes1 = new byte[5];
            int data1;
            while((data1=is.read(bytes1))!=-1){
                baos.write(bytes1, 0, data1);
            }
            String string = baos.toString();
            System.out.println(string);
            System.out.println(socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭ServerSocket与Socket的对象
            if(baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        }

    }
