package demExperience;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class DemColorNoThree extends JFrame{

	JTextField text;
	JLabel label;
	public DemColorNoThree() {
		super("�����ڲ����ʵ��");
		setSize(500,100);
		setLocation(250,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().createImage("image/�ܱ�.png"));
		//ʵ����
				label=new JLabel("�����ı�������������");
				text=new JTextField(80);
				BorderLayout lay=new BorderLayout();
				setLayout(lay);

				//������
				add(label,BorderLayout.NORTH);
				add(text,BorderLayout.SOUTH);		
		
		
				setVisible(true);
				
		text.addKeyListener(new KeyAdapter()
				{
			public void keyTyped(KeyEvent e) {
				//�õ�����һ��һ���ַ�
				char key=e.getKeyChar();
				//��ʱ���Ѿ���ȡ��text�ϵ��ı������ǽ�����JLabel�Ķ���label����ʾ����
				label.setText("Your pressed    "+key);
			}
				});
	}
	public static void main(String[] args) {
		DemColorNoThree three=new DemColorNoThree();
	}
	
}
