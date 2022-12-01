package demExperience;

import java.awt.*;

import javax.swing.*;

public class ButtonImage extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//建立一个JToolbar用来盛放功能键
	JToolBar j1;
	
	ImageIcon i1;
	ImageIcon i2;
	ImageIcon i3;
	JButton b1;
	JButton b2;
	JButton b3;
	//JTextArea 是一个显示纯文本的多行区域。
	/*
	 * java.awt.TextArea 具有两个属性 rows 和 columns，这两个属性用来确定首选大小。 JTextArea 用这些属性来指示
	 * viewport 的首选大小， 此 viewport 被放置到 JScrollPane 中以匹配由 java.awt.TextArea 提供的功能。
	 * JTextArea 具有显示所有文本所需的首选大小，以便在 JScrollPane 内部正常工作。如果 rows 或 columns 的值等于 0，
	 * 则沿该轴的首选大小将用于沿相同轴上 viewport 的首选大小。
	 */
	JTextArea text;
	JScrollPane scroll;//要将JTextArea的对象作为参数
	BorderLayout border;

	public ButtonImage() {
		super("按键图标");
		
		j1=new JToolBar();
		//ImageIcon中设置的图片格式只能是gif,png,jpeg;
		i1=new ImageIcon("Image/周边.png");
		b1=new JButton(i1);
		
		i2=new ImageIcon("Image/周边.png");
		b2=new JButton(i2);
		
		i3=new ImageIcon("Image/周边.png");
		b3=new JButton(i3);
		
		j1.add(b1);
		j1.add(b2);
		j1.add(b3);
		
		//text与scroll不可分割
		text=new JTextArea(100,400);
		scroll=new JScrollPane(); 
		scroll.setViewportView(text);
		
		border=new BorderLayout();
		setLayout(border);
		add(j1,BorderLayout.NORTH);
		//add(scroll,BorderLayout.CENTER);
		
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//方法：setHorizontalScrollBarPolicy与setVerticalScrollBarPolicy
		//JScrollPane.VERTICAL_SCROLLBAR_ALWAYS（总是出现）
		//JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED（自动出现）
		//JScrollPane.HORIZONTAL_SCROLLBAR_NEVER（总是隐藏）
		add(scroll);
		setLookAndFeel();
		setSize(1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception exc){
			//ignore error
		}
	}
	public static void main(String[] args) {
		ButtonImage obj=new ButtonImage();
	}
}
/*
 * java.lang.NullPointerException出现的几种原因：
 * 
 * 1、字符串变量未初始化 
 * 2、接口类型的对象没有用具体的类初始化，比如： Map map // 会报错 Map map = new Map();
 * 则不会报错了
 *  3、当一个对象的值为空时，你没有判断为空的情况。
 *   4、字符串与文字的比较，文字可以是一个字符串或Enum的元素，如下会出现异常
 * String str = null; if（str.equals（“Test”））{
 * 这里的代码将不会被触发，因为会抛出java.lang.NullPointerException异常。 }
 * 5、优先使用String.valueOf（）方法代替toString（）
 * 当程序代码需要对象的字符串表示形式时，请避免使用该对象的toString方法。如果你的对象的引用等于null，
 * NullPointerException则会抛出，使用静态String.valueOf方法，该方法不会抛出任何异常并打印"null"
 * 6、class被声明了类型， 默认 class = null; 这样在调用class中方法的时候系统只能给你个空指针异常， 给其实例化就好了：class
 * = new Class(); 
 * 7、返回null，方法的返回值不要定义成为一般的类型，而是用数组。
 * 这样如果想要返回null的时候就能避免许多不必要的NullPointerException
 * 
 * 
 * ———————————————— 版权声明：本文为CSDN博主「宜春」的原创文章，遵循 CC 4.0 BY-SA
 * 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_44543508/article/details/94589868
 */