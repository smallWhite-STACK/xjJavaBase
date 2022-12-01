package demExperience;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;



/*�˴�ʵ����������button1��x��y����õ��ı���λ��
 * ����ʹ�����´���
 * x=x+5;
 * y=y+5;
 * ����ʹ�÷�����setLocation(x+5,y);
 * �̳нӿں�ǵõ��������
 * 
*/
public class KeyDemo extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//KeyEvent�¼�
	//�ӿڣ�KeyListener
	private JPanel panel;
	private JButton button1;
	//FlowLayout flow;
	
	
	
	public KeyDemo() {
		super("�����¼�");
		
		//��ʼ��
		panel=new JPanel();
		button1=new JButton("�÷�������ư�ť���ƶ�����");
		//flow=new FlowLayout();
		
		//�������
		//panel.setLayout(flow);
		panel.add(button1);
		this.add(panel);
		this.setSize(600, 200);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		button1.addKeyListener(this);//�ǵõ���import java.awt.event.KeyListener
		
		
	}
	
	//��дKeyListener������������1.keyTyped(�û����̵��¼�������)  2.keyPressed�����¼��̵��¼��������� 
	//3.keyReleased���ɿ����̵��¼���������
	//��Ϊ��չ�ӿ�ʱ���������д�ӿ��е����з�������ʹ���ã�ҲҪ��д
	
	
	public void keyTyped(KeyEvent e) {
		//
	}
	public void keyPressed(KeyEvent e) {
		
		//�Ȼ�ȡ�û����µ��Ǽ������ĸ����ܼ�
		//��ȡ���̰�����ֵ��      getKeyCode()
		//��ȡ���̰����ϵ��ַ���getKeyChar()
		//�����e������Ǽ����¼�
				//��ȡ������ֵ
				int key=e.getKeyCode();
				//��ȡ��ǰҪ�������󣨰�ť��������
				int x=button1.getX();
				int y=button1.getY();
				int value1=e.getKeyChar();
				System.out.println(value1+"X������ "+x+"Y������"+y);
				//����
				//KeyEvent.VK_RIGHT
				//KeyEvent.VK_UP              ����
				//KeyEvent.VK_LEFT
				//KeyEvent.VK_DOWN            �ӷ�
				if(key==KeyEvent.VK_RIGHT) {
					button1.setLocation(x+5, y);
	//��Ȼ��Ҫ�ƶ���ť������Ҫ��ȡ����ǰ�����꣬Ȼ������������Ҽ�����һ���ļ��ֵ���ƶ�������
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
