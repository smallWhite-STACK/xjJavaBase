package demExperience;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

//ʹ������������ķ�ʽע�����
//��ʱ������Ҫȥ����һ���ڲ���ButtonListener�Լ��ڹ��캯����ʵ��������ʼ����

//The serializable class DemColorChangeTwo does not declare a static final serialVersionUID field of type long
//�����л�����DemColorChangeTwoû����������Ϊlong�ľ�̬final serialVersionUID�ֶ�


//����actionPerformed��action��Сд

public class DemColorChangeTwo extends JFrame{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel p;
	JButton btred,btblack,btwhite;

	public DemColorChangeTwo() {
		super("��ɫ�仯");
		p=new JPanel();
		
		//���֣�FlowLayout

		 FlowLayout fot=new FlowLayout(FlowLayout.CENTER,10,15);
		   p.setLayout(fot);
		 
		/*
		 * ���֣�BorderLayout BorderLayout bot=new BorderLayout(); p.setLayout(bot);
		 */
		
		btred=new JButton("��ɫ����");
		btblack=new JButton("��ɫ����");
		btwhite=new JButton("��ɫ����");
		//Ҫ��ʹ��BorderLayout���ֵĻ��𣬻���Ҫ����λ��
		/*
		 * p.add(btred); p.add(btblack); p.add(btwhite);
		 * ��Ҫ��Ϊ
		 * p.add(btred,BorderLayout.EAST);p.add(btblack,BorderLayout.NORTH);p.add(btwhite,BorderLayout.WEST);
		 * ��btred�Ⱥ������          ���� BorderLayout.���򣨴�д��
		 */
		p.add(btred,BorderLayout.EAST);
		p.add(btblack,BorderLayout.NORTH);
		p.add(btwhite,BorderLayout.WEST);
		this.add(p);
		this.setSize(500,600);
		this.setLocation(200,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ʹ������������ķ�ʽע����� �Ƚ�  ��ʹ���ڲ�����ע������Ĳ�ͬ
		//�¼���һ����GUI�����. AddActionListener(��ʼ��һ������{����ActionListener})
		/*
		 * btred.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { //��ʱҲʡȥ��if��䣬��Ϊ����Object.getSource()ȥ��ȡ�¼�Դ
		 * p.setBackground(Color.red); } }); btblack.addActionListener(new
		 * ActionListener() { public void actionPerformed(ActionEvent e) {
		 * p.setBackground(Color.black); }
		 * 
		 * }); btwhite.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { p.setBackground(Color.white); } });
		 */
		
		
		/*
		 * //�ڶ��������ڲ���
		 * 
		 * ActionListener act=new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { if(e.getSource()==btred) {
		 * p.setBackground(Color.red); }else if(e.getSource()==btblack) {
		 * p.setBackground(Color.black); }else if(e.getSource()==btwhite) {
		 * p.setBackground(Color.white); } } };//�˴��ķֺ�
		 * 
		 * btred.addActionListener(act); btblack.addActionListener(act);
		 * btwhite.addActionListener(act);
		 */
		
		
		//������ʹ��lambda��ʽ
		//��lambda�У������ƶϳ����͸������Ĳ������࣬����ActionListener����ʽ�ӿ�����һ��������
		//�÷�������һ��ActionEvent������Ϊ��Ψһ�Ĳ�������˸Ķ�����������Ժ��ԡ�
		ActionListener ac=(e)->{
			if(e.getSource()==btred) {
				 p.setBackground(Color.red); 
				 }else if(e.getSource()==btblack) {
				 p.setBackground(Color.black);
				 }else if(e.getSource()==btwhite) {
				 p.setBackground(Color.white);
				 }
		};
		 btred.addActionListener(ac);
		 btblack.addActionListener(ac);
		 btwhite.addActionListener(ac);
		
	}
	public static void main(String[] args) {
		DemColorChangeTwo a=new DemColorChangeTwo();
	}
	
}

