package demExperience;
import java.awt.*;

import javax.swing.*;

;	
public class EasyFrame extends JFrame{

	//��һ�����
	JPanel p1;
	JLabel l1;
	JTextField t1;
	//�ڶ������
	JPanel p2;
	ButtonGroup group;
	JCheckBox box1;
	JCheckBox box2;
	JCheckBox box3;
	JCheckBox box4;
	JCheckBox box5;
	//���������
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
		
		//ȫ�ֲ���
		setSize(1000,600);
		GridLayout gridlay=new GridLayout(4,1,2,2);//ע��������ֵ��ĸ��������У��У�ˮƽ��࣬��ֱ��ࣩ
		setLayout(gridlay);
		//��һ����
		//ע����������Ĳ��֣�Ȼ��Ҫ������Ҫ�ؼ������У�Ȼ����ļ�������Ĳ���
		p1=new JPanel();
		FlowLayout flowlay=new FlowLayout(FlowLayout.LEFT,10,10);//ע��FloeLayout���ֵ��������������뷽ʽ��ˮƽ��࣬��ֱ��ࣩ
		//������p1�Ĳ���setLayout
		p1.setLayout(flowlay);
		l1=new JLabel("Please your name:");
		t1=new JTextField(20);//ע��JTextField������һ�����Դ���������ɵ��ַ�����
		
		//p1.setLayout(flowlay);//��ʵ�ȶ�������ݳ�ʼ��������������岼�ֲ�û��Ӱ��
		
		p1.add(l1);
		p1.add(t1);
		add(p1);
		
		//���õڶ�����
		p2=new JPanel();
		/*
		 * GridLayout gridlay2=new GridLayout(2,3,5,5); p2.setLayout(gridlay2);
		 */
		group=new ButtonGroup();
		box1=new JCheckBox("��ѧ��");
		box2=new JCheckBox("��ѧ��");
		box3=new JCheckBox("Сѧ��");
		box4=new JCheckBox("�ϰ�");
		box5=new JCheckBox("�ϰ���");
		
		group.add(box1);
		group.add(box2);
		group.add(box3);
		group.add(box4);
		group.add(box5);
		//����ֱ�Ӱ�һ��ButtonGroup����������Ǵ����p2.add(group);
		p2.add(box1);
		p2.add(box2);
		p2.add(box3);
		p2.add(box4);
		p2.add(box5);
		add(p2);
		
		//���õ��������
		p3=new JPanel();
		GridLayout gridlay3=new GridLayout(2,1,5,5);
		combo1=new JComboBox();
		combo1.addItem("20������");
		combo1.addItem("20~30��");
		combo1.addItem("30~45��");
		combo1.addItem("45������");
		combo2=new JComboBox();
		combo2.setEditable(true);
		/*
		 * combo2.setEditable(true); combo2.setEditable(true);
		 * ûɶ��
		 */
		p3.setLayout(gridlay3);
		p3.add(combo1);
		p3.add(combo2);
		add(p3);
		
		//���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().createImage("Image/hpu.png"));//import java.awt.Toolkit//������
	}
	 public static void main(String[] args) {
		 EasyFrame e=new EasyFrame();
		 
	 }
	
}
