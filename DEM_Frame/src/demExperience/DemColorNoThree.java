package demExperience;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class DemColorNoThree extends JFrame{

	JTextField text;
	JLabel label;
	public DemColorNoThree() {
		super("匿名内部类的实例");
		setSize(500,100);
		setLocation(250,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().createImage("image/周边.png"));
		//实例化
				label=new JLabel("请在文本框中输入内容");
				text=new JTextField(80);
				BorderLayout lay=new BorderLayout();
				setLayout(lay);

				//加入框架
				add(label,BorderLayout.NORTH);
				add(text,BorderLayout.SOUTH);		
		
		
				setVisible(true);
				
		text.addKeyListener(new KeyAdapter()
				{
			public void keyTyped(KeyEvent e) {
				//得到的是一个一个字符
				char key=e.getKeyChar();
				//这时候已经获取在text上的文本，我们将其在JLabel的对象label中显示出来
				label.setText("Your pressed    "+key);
			}
				});
	}
	public static void main(String[] args) {
		DemColorNoThree three=new DemColorNoThree();
	}
	
}
