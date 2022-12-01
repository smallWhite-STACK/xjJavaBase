package demExperience;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//在鼠标事件中有两个监听接口
//MouseListner:专门监听鼠标的按下、松开、点击三个事件
//MouseMotionListener：专门监听鼠标用于鼠标移动、 拖动两个事件
public class MouseDemo extends JFrame implements MouseMotionListener{

	JPanel p;
	int x,y;
	public MouseDemo() {
		super("画图功能");
		//初始化
		p=new JPanel();
		p.add(new JButton("Painting"));
		add(p);
		this.setSize(1000,500);
		this.setLocation(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//添加鼠标事件,注意是将监听器加在面板对象上
		p.addMouseMotionListener(this);
	}
	//MouseMotionListener中有两个方法：
	//鼠标移动：mouseMoved
	//鼠标拖动：mouseDragged
	public void paint(Graphics g) {
		g.setColor(Color.red);
		//画一个实心圆(其实是椭圆 )
		g.fillOval(x,y,10,10);
	}
	public void mouseMoved(MouseEvent e) {
		
	}
	public void mouseDragged(MouseEvent e) {
		//获取当前坐标
		 x=e.getX();
		 y=e.getY();
		//重画，repaint()触发paint()
		this.repaint();
	}
	public static void main(String[] args) {
		MouseDemo mouse=new MouseDemo();
	}
}
