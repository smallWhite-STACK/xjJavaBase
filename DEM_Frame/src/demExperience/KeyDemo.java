package demExperience;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;



/*此次实验中在利用button1的x、y坐标得到改变后的位置
 * 不能使用以下代码
 * x=x+5;
 * y=y+5;
 * 必须使用方法：setLocation(x+5,y);
 * 继承接口后记得导入包与类
 * 
*/
public class KeyDemo extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//KeyEvent事件
	//接口：KeyListener
	private JPanel panel;
	private JButton button1;
	//FlowLayout flow;
	
	
	
	public KeyDemo() {
		super("键盘事件");
		
		//初始化
		panel=new JPanel();
		button1=new JButton("用方向键控制按钮的移动方向");
		//flow=new FlowLayout();
		
		//设置面板
		//panel.setLayout(flow);
		panel.add(button1);
		this.add(panel);
		this.setSize(600, 200);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		button1.addKeyListener(this);//记得导包import java.awt.event.KeyListener
		
		
	}
	
	//重写KeyListener的三个方法：1.keyTyped(敲击键盘的事件处理方法)  2.keyPressed（按下键盘的事件处理方法） 
	//3.keyReleased（松开键盘的事件处理方法）
	//因为扩展接口时，类必须重写接口中的所有方法，即使不用，也要重写
	
	
	public void keyTyped(KeyEvent e) {
		//
	}
	public void keyPressed(KeyEvent e) {
		
		//先获取用户按下的是键盘上哪个功能键
		//获取键盘按键码值：      getKeyCode()
		//获取键盘按键上的字符：getKeyChar()
		//这里的e代表的是键盘事件
				//获取按键码值
				int key=e.getKeyCode();
				//获取当前要操作对象（按钮）的坐标
				int x=button1.getX();
				int y=button1.getY();
				int value1=e.getKeyChar();
				System.out.println(value1+"X的坐标 "+x+"Y的坐标"+y);
				//操作
				//KeyEvent.VK_RIGHT
				//KeyEvent.VK_UP              减法
				//KeyEvent.VK_LEFT
				//KeyEvent.VK_DOWN            加法
				if(key==KeyEvent.VK_RIGHT) {
					button1.setLocation(x+5, y);
	//既然是要移动按钮，首先要获取他当前的坐标，然后根据上下左右键给其一定的间隔值，移动其坐标
				}else if(key==KeyEvent.VK_UP){
					button1.setLocation(x, y-5);
				}else if(key==KeyEvent.VK_LEFT){
					button1.setLocation(x-5, y);
				}else if(key==KeyEvent.VK_DOWN){
					button1.setLocation(x, y+5);
				}
		}
	public void keyReleased(KeyEvent e) {
			//
		}
	
	
	public static void main(String[] args) {
		KeyDemo key=new KeyDemo();
		
	}
	
}
