package demExperience;
import javax.swing.*;//���
import javax.swing.event.*;//������
import java.awt.*;//���磺����


//���裺
/*
 * 1.���ô��¿��
 *   ��һ������Ϊ�Ŀ飺ʹ��GridLayout����
 *   ���ñ������������һ��ʵ�������ɫ����ActionListener�ӿڣ��������ChangeListener�ӿ�
 * ע�����ϴ�ʵ�鲻һ����
 * 
 * 
 * 
 * */

public class ColorSliders extends JFrame {
	//ChangeListener��ֻ��һ������stateChanged(ChangeEvent e)
	//����һ����ɫ������
	ColorPanel canvas;//ColorPanel��һ���ⲿ��
	JPanel p1;
	JPanel p2;
	JPanel p3;
	
	//�������ڵ���ɫֵ�Ļ������
	JSlider red;
	JSlider green;
	JSlider blue;
	//������ǩ
	JLabel redred;
	JLabel greengreen;
	JLabel blueblue;
	
	public ColorSliders() {
		super("��ɫ�Զ�����");
		
		//�Զ�����г�ʼ��
		canvas=new ColorPanel();
		red=new JSlider(SwingConstants.HORIZONTAL, 0,255,255);//JSlider��������������Сֵ�����ֵ����ʼֵ����Ĭ�ϣ�0��100��50��
		//���ÿ̶������ŵĻ��Ǻ��ŵ�
		//SwingConstants.VERTICAL SwingConstants.HORIZONTAL  Constants:����  vertical ��  horizontal
		green=new JSlider(0,255,0);
		blue=new JSlider(0,255,0);
		//����������
		GridLayout grid=new GridLayout(5,1,10,30);
		//FlowLayout grid=new FlowLayout(FlowLayout.CENTER,10,10);
		this.setSize(500,500);
		this.setLayout(grid);
		
		//�Ƚ�������ͱ�ǩ��ʼ��
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		
		
		redred=new JLabel("��");
		greengreen=new JLabel("��");
		blueblue=new JLabel("��");
		
		
		Bubu bu=new Bubu();
		//��һ��
		//����ǰ���д����������ӡ��ʼ�12.13��
		red.setMajorTickSpacing(50);//����JSlider��Ҫ��ʾ�����̶ȼ��setMajorTickSpacing
		red.setMinorTickSpacing(10);//����JSlider��Ҫ��ʾ����С�̶ȼ��setMinorTickSpacing
		red.setPaintTicks(true);    //Ҫ�������̶ȣ�(����setMajorTickSpacing��setMinorTickSpacing�Ŀ̶���)setPaintTicks ��������Ϊ true�� 
		red.setPaintLabels(true);  //��ʾsetMajorTickSpacing���õĵ���ֵ
		/*
		 * public void setPaintLabels(boolean b)ȷ���Ƿ��ڻ����ϻ��Ʊ�ǩ��
		 * �˷���Ҳ��Ϊ������һ����ǩ�������û�б�ǩ���������̶ȼ��Ϊ > 0���������һ�������̶ȱ�Ǵ����б�ǩ�ı�׼��ǩ��ͨ������
		 * createStandardLabels����Ȼ��ͨ������ setLabelTable �ڻ��������ñ�ǩ��
		 * Ĭ������£�������Ϊ false��
		 * ������ b - �Ƿ���Ʊ�ǩ
		 */

		//����Ҫ���Ƕ�ÿһ��JSlider���ϼ�����ChangeListener
		red.addChangeListener(bu);
		
		GridLayout grid1=new GridLayout(1,2);
		p1.setLayout(grid1);
		p1.add(redred);
		p1.add(red);
		add(p1);
		
		//�ڶ���
		//����Ҫ���Ƕ�ÿһ��JSlider���ϼ�����ChangeListener
		green.addChangeListener(bu);
		green.setMajorTickSpacing(50);
		green.setMinorTickSpacing(10);
		green.setPaintTicks(true);
		green.setPaintLabels(true);
		
		
		
		GridLayout grid2=new GridLayout(1,2,0,0);
		p2.setLayout(grid2);
		p2.add(greengreen);
		p2.add(green);
		add(p2);
		
		//������
		//����Ҫ���Ƕ�ÿһ��JSlider���ϼ�����ChangeListener
		blue.addChangeListener(bu);
		blue.setMajorTickSpacing(50);
		blue.setMinorTickSpacing(10);
		blue.setPaintTicks(true);
		blue.setPaintLabels(true);
		
		
		
		
		GridLayout grid3=new GridLayout(1,2,0,0);
		p3.setLayout(grid3);
		p3.add(blueblue);
		p3.add(blue);
		add(p3);
		
		//���İ�
		
		/*
		 * GridLayout grid4=new GridLayout(1,1,100,100); canvas.setLayout(grid4);
		 */
		add(canvas);
		//������ɫ���ĳ�ʼɫ�����ڹ��캯��ColorChange�����ã���������������Ĺ��캯����
		//setBackground(green);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public class Bubu implements ChangeListener{  
		public void stateChanged(ChangeEvent e) {
			//��һ��ʵ�飺Object f=e.getSource();
			//��ʵ����˼Ϊ�����飺JSlider������ȡJSlider��Դͷ�����ҷ���һ������ΪJSlider������
		JSlider source=(JSlider) e.getSource();
		
		if(source.getValueIsAdjusting()!=true) {
			//��������ʵ��Ӧ���ڿ�ʼ�϶�����ʱ������������Ϊ true�������϶�����ʱ��Ϊ false��
			//�� valueIsAdjusting Ϊ true ʱ������ģ�Ͳ������ ChangeEvent��
			//Color����Java.awt.Color;
			//getValue��JSlider�ķ�����int javax.swing.JSlider.getValue()
			Color current=new Color(red.getValue(),
					green.getValue(),
					blue.getValue());
			//changeColor�������ⲿ���ж��壬�������ķ���ֵ��Color��Ķ���
			canvas.changeColor(current);
			//repaint�������ػ�������,���ޣ�����ɫ��岻���£�ֻ��Ϊ��ʼɫ��void java.awt.Component����ɣ�.repaint()
			canvas.repaint();	
		}
	}
}
	
	
	
	public static void main(String[] args) {
		ColorSliders kk=new ColorSliders();
		
	}
}

class ColorPanel extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Color backGround; //java.awt.color���и���ɫ�ռ�colorspace
    ColorPanel(){
    	//Ĭ����ɫΪ��ɫ
    backGround=Color.red;
}
    //Graphics���ڣ�    java.awt.Graphics����ͼѧ����
    //Graphics2D���ڣ�java.awt.Graphics2D       ��
		public void paintComponent(Graphics comp) {
		    Graphics2D comp2D=(Graphics2D)comp; 
		    comp2D.setColor(backGround);
		    //ע��fillRect��void java.awt.Graphics.fillRect(int x, int y, int width, int height)
		    //getSize:�� Dimension �������ʽ��������Ĵ�С��
		    //���Խ���getSize().width   ==   ����.������������getSize().width������getWidth() ��getHight()
		    //����ָ�����εı߿򡣾��ε����Ե���ұ�Ե�ֱ�λ�� x �� x + width���ϱ�Ե���±�Ե�ֱ�λ�� y �� y + height��ʹ��ͼ�������ĵĵ�ǰ��ɫ���Ƹþ��Ρ�
		    comp2D.fillRect(0, 0, getSize().width,getSize().height);
		    // comp2D.fillRect(0, 0, getWidth(),getHeight());
		}
		//δ���������:û��ΪColorPanel���Ͷ���changeColor(Color)����
		// Unresolved compilation problem:The method changeColor(Color) is undefined for the type ColorPanel

		void changeColor(Color newBackGround) {
			  backGround=newBackGround;
		}
}
			
