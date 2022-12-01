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
	//�������飬һ��label��һ��Thread,
	//����һ�������������������������
	String[] pageTitle=new String[3];
	URI[] pageLink=new URI[3];
	JLabel label=new JLabel();
	int current=0;
	 Thread go;
	 
	//���캯��
	public MultithReadingDemo() {
		super("��ҳת��");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout lay=new FlowLayout();
		setLayout(lay);
		setLocation(300,300);
		add(label);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().createImage("Image/hpu.png"));
		
		//��ʼ��
		pageTitle=new String[] {
				"�Ա�",
				"����",
				"CSDN"
		};
		/*
		 * pageLink=new URI[] { "www.taobao.com", "www.jingdong.com", "www.csdn.con" };
		 */
		//������վ���ӵĳ�ʼ��
		//getURL()����������
		
		pageLink[0]=getURI("http://www.taobao.com");
		pageLink[1]=getURI("http://www.jingdong.com");
		pageLink[2]=getURI("https://www.csdn.net/");
		//ʵ����һ����ť
		JButton visitButton=new JButton("Visit Tite");
		add(visitButton);
		visitButton.addActionListener(this);
		//��ʹ��start������Ҫ��д
		start();	
	}
	public URI getURI(String uriText) {
		
		//getURL(String),����һ�������ַ��Ϊ������Ȼ�󷵻�һ����ʾ�õ�ַ��URL���������Ϊ�������ַ���������Ч�ĵ�ַ���򷵻�null;
		
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
			go.start();//�����߳̿�ʼ
		}
		
	}
	public void run() {
		
		//��ǩ���ݡ�����ͣ��ʱ�䡢���ٵ�ǰ���е��߳�
		
		//���ٵ�ǰ�̣߳����Ա��̶߳���go �����Լ��̶߳���thisThread���Ƿ���ͬ
		//�����ͬ�����ʵ�ְ�ť��ѭ������
		Thread thisThread=Thread.currentThread();
		while(go==thisThread) {
			//ѭ����
			//��ǩ����ҲҪ�仯���������������仯
				current++;
			if(current>2) {
				current=0;
			}
			label.setText(pageTitle[current]);
			//ÿִ��һ�Σ���Ҫ����ˢ�±�ǩ�е�text
			repaint();
			try {
				//���߳���ͣһ�룬
				Thread.sleep(1000);
			}catch(InterruptedException e){
				//do nothing 
			}
			
		}
	}
	public void actionPerformed(ActionEvent e) {
	
		//��ʾ����Ӧ�ó���ļ���������滷��
		Desktop desktop=Desktop.getDesktop();
		if(pageLink[current]!=null) {
			try {
				desktop.browse(pageLink[current]);
				//go=null��ζ�ŵ����°�ť��label���ݲ��ڱ仯����ʵ��ʱwhileѭ����go��thisThread�Ѿ����ȣ��߳̽���
				
				go=null;
				
				/*
				 * public static void exit(int status)��ֹ��ǰ�������е� Java �������
				 * ��������״̬�룻���ݹ������� 0��״̬���ʾ�쳣��ֹ��
				 *  �÷������� Runtime ���е� exit �������÷�����Զ�����������ء�
				 * ���� System.exit(n) ʵ���ϵ�Ч�ڵ��ã�Runtime.getRuntime().exit(n)
				 * ������ status - �˳�״̬��
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
