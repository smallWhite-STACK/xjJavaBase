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
		super("找素数");
		setSize(500,500);
		setLocation(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		BorderLayout lay1=new BorderLayout();
		setLayout(lay1);
		
		
		//实例化
		lable=new JLabel("quatity:");
		field=new JTextField("400",3);//“400”指的是指定的文本，10是JTextField指定的列数
		button=new JButton("Please");
		//加入监听
		button.addActionListener(this);
		JPanel pane=new JPanel();
		
		pane.add(lable);
		pane.add(field);
		pane.add(button);
		add(pane,BorderLayout.NORTH);
		
		area=new JTextArea();
		//line wrap：自动换行
		//设置文本区的换行策略。如果设置为 true，
		//则当行的长度大于所分配的宽度时，将换行。如果设置为 false，则始终不换行。
		//当策略更改时，将激发 PropertyChange 事件（"lineWrap"）。此属性默认为 false。 
		area.setLineWrap(true);
		scroll=new JScrollPane(area);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll,BorderLayout.CENTER);

	}
	
	//重写ActionListener接口的方法actionPerformed();
	public void actionPerformed(ActionEvent e) {
		
		button.setEnabled(false);
		//调用线程
		//①通过调用Thread构造函数创建线程化类对象
		//②对象调用start（）方法启动线程
		//所以对go进行初始化
		if(go==null) {
			//如果go==null表示该线程没有创建
			go=new Thread(this);
			go.start();
			/*当调用线程对象的start()方法（t.start();），
			线程即进入就绪状态。处于就绪状态的线程，只是说明此线程已经做好了准备，随时等待CPU调度执行，
			并不是说执行了t.start()此线程立即就会执行。
			*/
		}
	}
	//重写run()方法
	public void run() {
		//Integer.parseInt中输入的字符串只能是整数，不能带小数点！
		//quantity决定了文本框中素数的个数
		int quantity=Integer.parseInt(field.getText());
		int numPrimes=0;//作为一个循环参数
		int candidate=2;//素数从二开始
		
		/*public void append(String str)将给定文本追加到文档结尾。如果模型为 null 或者字符串为 null 或空，
		 * 则不执行任何操作。 虽然大多数 Swing 方法不是线程安全的，但此方法是线程安全的
		 	*/
		area.append("First "+quantity+" primes :");
		//此处设置输出到400个素数
		while(numPrimes<quantity) {
			//isPrime()方法，candidate当作实参传递进去说明，遍历的是candidate
			if(isPrime(candidate)) {
				
				//既然append是将参数str加入到文本 末尾，说明是按顺序将一个个素数加入进去
				
				area.append(candidate+" ");//空格是每一个数字之间的间隔
				numPrimes++;
				
			}
			candidate++;
		}
		area.append("一共"+numPrimes+"个素数");
		area.append("直到"+candidate+"才产生400个素数");	
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