package demExperience;
import java.awt.*;

import javax.swing.*;

;	
public class EasyFrame extends JFrame{

	//第一个面板
	JPanel p1;
	JLabel l1;
	JTextField t1;
	//第二个面板
	JPanel p2;
	ButtonGroup group;
	JCheckBox box1;
	JCheckBox box2;
	JCheckBox box3;
	JCheckBox box4;
	JCheckBox box5;
	//第三个面板
	JPanel p3;
	JComboBox combo1;
	JComboBox combo2;
	
	/*
	 * setLayout
	 * setLocation//
	 * setSize
	 * setVisible
	 * setDefauleCloseOperation
	 */	public EasyFrame() {
		super("My_Frame");
		
		//全局布局
		setSize(1000,600);
		GridLayout gridlay=new GridLayout(4,1,2,2);//注意格网布局的四个参数（行，列，水平间距，垂直间距）
		setLayout(gridlay);
		//第一个面
		//注意先设置面的布局，然后要将所有要素加入面中，然后将面的加入整体的布局
		p1=new JPanel();
		FlowLayout flowlay=new FlowLayout(FlowLayout.LEFT,10,10);//注意FloeLayout布局的三个参数（对齐方式，水平间距，垂直间距）
		//设置面p1的布局setLayout
		p1.setLayout(flowlay);
		l1=new JLabel("Please your name:");
		t1=new JTextField(20);//注意JTextField后面有一个属性代表可以容纳的字符长度
		
		//p1.setLayout(flowlay);//其实先对面板内容初始化或者先设置面板布局并没有影响
		
		p1.add(l1);
		p1.add(t1);
		add(p1);
		
		//设置第二个面
		p2=new JPanel();
		/*
		 * GridLayout gridlay2=new GridLayout(2,3,5,5); p2.setLayout(gridlay2);
		 */
		group=new ButtonGroup();
		box1=new JCheckBox("大学生");
		box2=new JCheckBox("中学生");
		box3=new JCheckBox("小学生");
		box4=new JCheckBox("老板");
		box5=new JCheckBox("上班族");
		
		group.add(box1);
		group.add(box2);
		group.add(box3);
		group.add(box4);
		group.add(box5);
		//好像直接把一个ButtonGroup加入面板中是错误的p2.add(group);
		p2.add(box1);
		p2.add(box2);
		p2.add(box3);
		p2.add(box4);
		p2.add(box5);
		add(p2);
		
		//设置第三个面板
		p3=new JPanel();
		GridLayout gridlay3=new GridLayout(2,1,5,5);
		combo1=new JComboBox();
		combo1.addItem("20岁以下");
		combo1.addItem("20~30岁");
		combo1.addItem("30~45岁");
		combo1.addItem("45岁以上");
		combo2=new JComboBox();
		combo2.setEditable(true);
		/*
		 * combo2.setEditable(true); combo2.setEditable(true);
		 * 没啥用
		 */
		p3.setLayout(gridlay3);
		p3.add(combo1);
		p3.add(combo2);
		add(p3);
		
		//最后
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().createImage("Image/hpu.png"));//import java.awt.Toolkit//工具栏
	}
	 public static void main(String[] args) {
		 EasyFrame e=new EasyFrame();
		 
	 }
	
}
