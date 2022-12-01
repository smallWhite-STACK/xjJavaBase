package com.atxujian.exer;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xujian
 * @create 2020-03-15 7:44
 */

/*2.客户端发送文件给服务端，服务端将文件保存在本地。*/
public class TCPProblemNubTwo {

    @Test
    public void client() throws IOException {
        //按照四步走
        //1.创建Socket对象
        Socket socket = new Socket("127.0.0.1", 3307);
        //2.调用相关的输入输出流（这里我们要输入流）
        OutputStream os = socket.getOutputStream();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("hpu.png"));
        //3.使用相关的方法读入流
        byte[] bytes = new byte[1024];
        int data;
        while((data=bis.read(bytes))!=-1){
            os.write(bytes, 0, data);
        }
        //4.关闭资源
        bis.close();
        os.close();
        socket.close();

    }

    @Test
    public void server() throws IOException {
        //四步走
        //1.创建ServerSocket的对象
        ServerSocket serverSocket = new ServerSocket(3307);
        //2使用accept()方法
        Socket accept = serverSocket.accept();
        //3.按照一定的网络协议，调用输入输出流
        InputStream is = accept.getInputStream();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("hpu2.png"));
        byte[] bytes = new byte[1024];
        int data;
        while((data=is.read(bytes))!=-1){
            bos.write(bytes, 0, data);
        }
        System.out.println(accept.getInetAddress().getHostName());
        //4关闭资源
        is.close();
        bos.close();
        accept.close();
        serverSocket.close();
    }
}
