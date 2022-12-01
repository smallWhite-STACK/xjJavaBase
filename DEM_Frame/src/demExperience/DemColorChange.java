//�����¼�Event

package demExperience;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemColorChange extends JFrame {
	
	//��������
	JPanel p;
	JButton btred,btyellow,btblue;
	public DemColorChange() {
		super("ColorChange");
	//��ʼ������
		p=new JPanel();
		btred=new JButton("red");
		btyellow=new JButton("yellow");
		btblue=new JButton("blue");
		//���button��panel��
		p.add(btred);
		p.add(btyellow);
		p.add(btblue);
	//number1
		//�����������󣬾��ǵ����ڲ���ButtonListener
		//ButtonListener������һ���ڲ���
		ButtonListener lis=new ButtonListener();
	//number2
		//��ʼ����������
		//addActionListener
		btred.addActionListener(lis);
		btyellow.addActionListener(lis);
		btblue.addActionListener(lis);
		this.add(p);
		this.setSize(1500,1000);
		this.setLocation(20,20);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//number3
		//�ڲ���    ��
		//��Ϊ��������ӿ�ActionListener ���Ĵ�������actionPerformed(ActionEvent e)
	
	public class ButtonListener implements ActionListener{
	//number4
		//��д��Ϊ������actionPerformed(ActionEvent e)
		
		public void actionPerformed(ActionEvent e) {
			
	//number5	
			//��ȡ�¼�Դ����
			//Object getSource(),��EventObject��̳еķ��������ڷ����¼�Դ�Ķ���
			Object source=e.getSource();
			
			if(source==btred) {
				//������屳����ɫ
				//ע����ɫ��Ҫȥ����
				
				p.setBackground(Color.red);
			}else if(source==btyellow) {
				p.setBackground(Color.yellow);
			}else if(source==btblue){
				p.setBackground(Color.blue);
			}	
		}
	}
	public static void main(String[] args) {
		DemColorChange d=new DemColorChange();
		
		
		
		
	}
}