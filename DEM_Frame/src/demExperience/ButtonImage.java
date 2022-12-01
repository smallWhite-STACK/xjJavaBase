package demExperience;

import java.awt.*;

import javax.swing.*;

public class ButtonImage extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//����һ��JToolbar����ʢ�Ź��ܼ�
	JToolBar j1;
	
	ImageIcon i1;
	ImageIcon i2;
	ImageIcon i3;
	JButton b1;
	JButton b2;
	JButton b3;
	//JTextArea ��һ����ʾ���ı��Ķ�������
	/*
	 * java.awt.TextArea ������������ rows �� columns����������������ȷ����ѡ��С�� JTextArea ����Щ������ָʾ
	 * viewport ����ѡ��С�� �� viewport �����õ� JScrollPane ����ƥ���� java.awt.TextArea �ṩ�Ĺ��ܡ�
	 * JTextArea ������ʾ�����ı��������ѡ��С���Ա��� JScrollPane �ڲ�������������� rows �� columns ��ֵ���� 0��
	 * ���ظ������ѡ��С����������ͬ���� viewport ����ѡ��С��
	 */
	JTextArea text;
	JScrollPane scroll;//Ҫ��JTextArea�Ķ�����Ϊ����
	BorderLayout border;

	public ButtonImage() {
		super("����ͼ��");
		
		j1=new JToolBar();
		//ImageIcon�����õ�ͼƬ��ʽֻ����gif,png,jpeg;
		i1=new ImageIcon("Image/�ܱ�.png");
		b1=new JButton(i1);
		
		i2=new ImageIcon("Image/�ܱ�.png");
		b2=new JButton(i2);
		
		i3=new ImageIcon("Image/�ܱ�.png");
		b3=new JButton(i3);
		
		j1.add(b1);
		j1.add(b2);
		j1.add(b3);
		
		//text��scroll���ɷָ�
		text=new JTextArea(100,400);
		scroll=new JScrollPane(); 
		scroll.setViewportView(text);
		
		border=new BorderLayout();
		setLayout(border);
		add(j1,BorderLayout.NORTH);
		//add(scroll,BorderLayout.CENTER);
		
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//������setHorizontalScrollBarPolicy��setVerticalScrollBarPolicy
		//JScrollPane.VERTICAL_SCROLLBAR_ALWAYS�����ǳ��֣�
		//JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED���Զ����֣�
		//JScrollPane.HORIZONTAL_SCROLLBAR_NEVER���������أ�
		add(scroll);
		setLookAndFeel();
		setSize(1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception exc){
			//ignore error
		}
	}
	public static void main(String[] args) {
		ButtonImage obj=new ButtonImage();
	}
}
/*
 * java.lang.NullPointerException���ֵļ���ԭ��
 * 
 * 1���ַ�������δ��ʼ�� 
 * 2���ӿ����͵Ķ���û���þ�������ʼ�������磺 Map map // �ᱨ�� Map map = new Map();
 * �򲻻ᱨ����
 *  3����һ�������ֵΪ��ʱ����û���ж�Ϊ�յ������
 *   4���ַ��������ֵıȽϣ����ֿ�����һ���ַ�����Enum��Ԫ�أ����»�����쳣
 * String str = null; if��str.equals����Test������{
 * ����Ĵ��뽫���ᱻ��������Ϊ���׳�java.lang.NullPointerException�쳣�� }
 * 5������ʹ��String.valueOf������������toString����
 * �����������Ҫ������ַ�����ʾ��ʽʱ�������ʹ�øö����toString�����������Ķ�������õ���null��
 * NullPointerException����׳���ʹ�þ�̬String.valueOf�������÷��������׳��κ��쳣����ӡ"null"
 * 6��class�����������ͣ� Ĭ�� class = null; �����ڵ���class�з�����ʱ��ϵͳֻ�ܸ������ָ���쳣�� ����ʵ�����ͺ��ˣ�class
 * = new Class(); 
 * 7������null�������ķ���ֵ��Ҫ�����Ϊһ������ͣ����������顣
 * ���������Ҫ����null��ʱ����ܱ�����಻��Ҫ��NullPointerException
 * 
 * 
 * �������������������������������� ��Ȩ����������ΪCSDN�������˴�����ԭ�����£���ѭ CC 4.0 BY-SA
 * ��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
 * ԭ�����ӣ�https://blog.csdn.net/qq_44543508/article/details/94589868
 */