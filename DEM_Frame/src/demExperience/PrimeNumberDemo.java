package demExperience;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PrimeNumberDemo extends JFrame implements Runnable,ActionListener {

	Thread go;
	private JLabel lable;
	private JTextField field;
	private JButton button;
	private JTextArea area;
	private JScrollPane scroll;
	
	public PrimeNumberDemo() {
		super("������");
		setSize(500,500);
		setLocation(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		BorderLayout lay1=new BorderLayout();
		setLayout(lay1);
		
		
		//ʵ����
		lable=new JLabel("quatity:");
		field=new JTextField("400",3);//��400��ָ����ָ�����ı���10��JTextFieldָ��������
		button=new JButton("Please");
		//�������
		button.addActionListener(this);
		JPanel pane=new JPanel();
		
		pane.add(lable);
		pane.add(field);
		pane.add(button);
		add(pane,BorderLayout.NORTH);
		
		area=new JTextArea();
		//line wrap���Զ�����
		//�����ı����Ļ��в��ԡ��������Ϊ true��
		//���еĳ��ȴ���������Ŀ��ʱ�������С��������Ϊ false����ʼ�ղ����С�
		//�����Ը���ʱ�������� PropertyChange �¼���"lineWrap"����������Ĭ��Ϊ false�� 
		area.setLineWrap(true);
		scroll=new JScrollPane(area);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll,BorderLayout.CENTER);

	}
	
	//��дActionListener�ӿڵķ���actionPerformed();
	public void actionPerformed(ActionEvent e) {
		
		button.setEnabled(false);
		//�����߳�
		//��ͨ������Thread���캯�������̻߳������
		//�ڶ������start�������������߳�
		//���Զ�go���г�ʼ��
		if(go==null) {
			//���go==null��ʾ���߳�û�д���
			go=new Thread(this);
			go.start();
			/*�������̶߳����start()������t.start();����
			�̼߳��������״̬�����ھ���״̬���̣߳�ֻ��˵�����߳��Ѿ�������׼������ʱ�ȴ�CPU����ִ�У�
			������˵ִ����t.start()���߳������ͻ�ִ�С�
			*/
		}
	}
	//��дrun()����
	public void run() {
		//Integer.parseInt��������ַ���ֻ�������������ܴ�С���㣡
		//quantity�������ı����������ĸ���
		int quantity=Integer.parseInt(field.getText());
		int numPrimes=0;//��Ϊһ��ѭ������
		int candidate=2;//�����Ӷ���ʼ
		
		/*public void append(String str)�������ı�׷�ӵ��ĵ���β�����ģ��Ϊ null �����ַ���Ϊ null ��գ�
		 * ��ִ���κβ����� ��Ȼ����� Swing ���������̰߳�ȫ�ģ����˷������̰߳�ȫ��
		 	*/
		area.append("First "+quantity+" primes :");
		//�˴����������400������
		while(numPrimes<quantity) {
			//isPrime()������candidate����ʵ�δ��ݽ�ȥ˵������������candidate
			if(isPrime(candidate)) {
				
				//��Ȼappend�ǽ�����str���뵽�ı� ĩβ��˵���ǰ�˳��һ�������������ȥ
				
				area.append(candidate+" ");//�ո���ÿһ������֮��ļ��
				numPrimes++;
				
			}
			candidate++;
		}
		area.append("һ��"+numPrimes+"������");
		area.append("ֱ��"+candidate+"�Ų���400������");	
	}
	public static boolean isPrime(int checkNumber) {
		double root=Math.sqrt(checkNumber);
		for(int i=2;i<root;i++) {
			if(checkNumber%i==0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		PrimeNumberDemo demo=new PrimeNumberDemo();
	}
}