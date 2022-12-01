package com.atxujian.exer;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xujian
 * @create 2020-03-15 7:45
 */
/*3.从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给 客户端。并关闭相应的连接。*/
public class TCPProblemNubThree {
    @Test
    public void client() throws IOException {
        //按照四步走
        //1.创建Socket对象
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
        //2.调用相关的输入输出流（这里我们要输入流）
        OutputStream os = socket.getOutputStream();
        FileInputStream bis = new FileInputStream("hpu.png");
        //3.使用相关的方法读入流
        byte[] bytes = new byte[1024];
        int data;
        while((data=bis.read(bytes))!=-1){
            os.write(bytes, 0, data);
        }
        socket.shutdownOutput();

        //4.接受服务器返回的消息到控制台
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bytes1 = new byte[1024];
        int data1;
        while((data1=is.read(bytes1))!=-1){
            bos.write(bytes1, 0, data1);
        }
        System.out.println(bos.toString());
        //5.关闭资源
        bis.close();
        is.close();
        os.close();
        socket.close();

    }

    @Test
    public void server() throws IOException {
        //四步走
        //1.创建ServerSocket的对象
        ServerSocket serverSocket = new ServerSocket(9090);
        //2使用accept()方法
        Socket accept = serverSocket.accept();
        //3.按照一定的网络协议，调用输入输出流
        InputStream is = accept.getInputStream();
        FileOutputStream bos = new FileOutputStream("hpu1.png");
        byte[] bytes = new byte[1024];
        int data;
        while((data=is.read(bytes))!=-1){
            bos.write(bytes, 0, data);
        }

        System.out.println("图片传输完成");
        //4.服务端反馈信息给客户端
        OutputStream os = accept.getOutputStream();
        os.write("你好，亲爱的客户端，我已经收到你的请求".getBytes());
        //5关闭资源
        is.close();
        bos.close();
        accept.close();
        serverSocket.close();
        os.close();
    }

}
