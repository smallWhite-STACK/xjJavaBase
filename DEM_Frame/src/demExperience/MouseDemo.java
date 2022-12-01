package demExperience;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//������¼��������������ӿ�
//MouseListner:ר�ż������İ��¡��ɿ�����������¼�
//MouseMotionListener��ר�ż��������������ƶ��� �϶������¼�
public class MouseDemo extends JFrame implements MouseMotionListener{

	JPanel p;
	int x,y;
	public MouseDemo() {
		super("��ͼ����");
		//��ʼ��
		p=new JPanel();
		p.add(new JButton("Painting"));
		add(p);
		this.setSize(1000,500);
		this.setLocation(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//�������¼�,ע���ǽ�������������������
		p.addMouseMotionListener(this);
	}
	//MouseMotionListener��������������
	//����ƶ���mouseMoved
	//����϶���mouseDragged
	public void paint(Graphics g) {
		g.setColor(Color.red);
		//��һ��ʵ��Բ(��ʵ����Բ )
		g.fillOval(x,y,10,10);
	}
	public void mouseMoved(MouseEvent e) {
		
	}
	public void mouseDragged(MouseEvent e) {
		//��ȡ��ǰ����
		 x=e.getX();
		 y=e.getY();
		//�ػ���repaint()����paint()
		this.repaint();
	}
	public static void main(String[] args) {
		MouseDemo mouse=new MouseDemo();
	}
}
