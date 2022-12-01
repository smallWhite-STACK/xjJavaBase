package demExperience;
import java.awt.*;

import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import javax.swing.*;

public class MultithReadingDemo extends JFrame implements ActionListener,Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//两个数组，一个label，一个Thread,
	//设置一个变量，用来当作数组的索引
	String[] pageTitle=new String[3];
	URI[] pageLink=new URI[3];
	JLabel label=new JLabel();
	int current=0;
	 Thread go;
	 
	//构造函数
	public MultithReadingDemo() {
		super("网页转载");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout lay=new FlowLayout();
		setLayout(lay);
		setLocation(300,300);
		add(label);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().createImage("Image/hpu.png"));
		
		//初始化
		pageTitle=new String[] {
				"淘宝",
				"京东",
				"CSDN"
		};
		/*
		 * pageLink=new URI[] { "www.taobao.com", "www.jingdong.com", "www.csdn.con" };
		 */
		//对于网站链接的初始化
		//getURL()方法在下面
		
		pageLink[0]=getURI("http://www.taobao.com");
		pageLink[1]=getURI("http://www.jingdong.com");
		pageLink[2]=getURI("https://www.csdn.net/");
		//实例化一个按钮
		JButton visitButton=new JButton("Visit Tite");
		add(visitButton);
		visitButton.addActionListener(this);
		//类使用start（）需要重写
		start();	
	}
	public URI getURI(String uriText) {
		
		//getURL(String),接受一个网络地址作为参数，然后返回一个表示该地址的URL对象，如果作为参数的字符串不是有效的地址，则返回null;
		
		URI pageURI=null;
		try {
		pageURI=new URI(uriText);
		}catch(URISyntaxException e) {
			//nothing
		}
		return(pageURI);
	}
	
	public void start() {
		
		if(go==null) {
			go=new Thread(this);
			go.start();//导致线程开始
		}
		
	}
	public void run() {
		
		//标签内容、运行停顿时间、跟踪当前运行的线程
		
		//跟踪当前线程，并对比线程对象go 与其自己线程对象thisThread看是否相同
		//如果想同则可以实现按钮的循环功能
		Thread thisThread=Thread.currentThread();
		while(go==thisThread) {
			//循环体
			//标签内容也要变化，所以数组索引变化
				current++;
			if(current>2) {
				current=0;
			}
			label.setText(pageTitle[current]);
			//每执行一次，需要重新刷新标签中的text
			repaint();
			try {
				//让线程暂停一秒，
				Thread.sleep(1000);
			}catch(InterruptedException e){
				//do nothing 
			}
			
		}
	}
	public void actionPerformed(ActionEvent e) {
	
		//表示运行应用程序的计算机的桌面环境
		Desktop desktop=Desktop.getDesktop();
		if(pageLink[current]!=null) {
			try {
				desktop.browse(pageLink[current]);
				//go=null意味着当按下按钮后，label内容不在变化，其实此时while循环中go与thisThread已经不等，线程结束
				
				go=null;
				
				/*
				 * public static void exit(int status)终止当前正在运行的 Java 虚拟机。
				 * 参数用作状态码；根据惯例，非 0的状态码表示异常终止。
				 *  该方法调用 Runtime 类中的 exit 方法。该方法永远不会正常返回。
				 * 调用 System.exit(n) 实际上等效于调用：Runtime.getRuntime().exit(n)
				 * 参数： status - 退出状态。
				 */

				System.exit(0);
			}catch(IOException ex) {
				//do nothing
			}
		}
	}
	
	public static void main(String[] args) {
		
		MultithReadingDemo demo=new MultithReadingDemo();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
