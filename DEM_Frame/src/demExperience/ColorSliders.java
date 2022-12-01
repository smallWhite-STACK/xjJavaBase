package demExperience;
import javax.swing.*;//框架
import javax.swing.event.*;//监听器
import java.awt.*;//比如：布局


//步骤：
/*
 * 1.设置大致框架
 *   将一个面板分为四块：使用GridLayout布局
 *   设置变更监听器（上一个实验关于颜色的是ActionListener接口）：这次是ChangeListener接口
 * 注意与上次实验不一样：
 * 
 * 
 * 
 * */

public class ColorSliders extends JFrame {
	//ChangeListener中只有一个方法stateChanged(ChangeEvent e)
	//创建一个颜色面板对象
	ColorPanel canvas;//ColorPanel是一个外部类
	JPanel p1;
	JPanel p2;
	JPanel p3;
	
	//创建关于调颜色值的滑块对象
	JSlider red;
	JSlider green;
	JSlider blue;
	//三个标签
	JLabel redred;
	JLabel greengreen;
	JLabel blueblue;
	
	public ColorSliders() {
		super("颜色自定义器");
		
		//对对象进行初始化
		canvas=new ColorPanel();
		red=new JSlider(SwingConstants.HORIZONTAL, 0,255,255);//JSlider有三个参数（最小值，最大值，初始值），默认（0，100，50）
		//设置刻度是竖着的还是横着的
		//SwingConstants.VERTICAL SwingConstants.HORIZONTAL  Constants:常量  vertical 与  horizontal
		green=new JSlider(0,255,0);
		blue=new JSlider(0,255,0);
		//定义整体格局
		GridLayout grid=new GridLayout(5,1,10,30);
		//FlowLayout grid=new FlowLayout(FlowLayout.CENTER,10,10);
		this.setSize(500,500);
		this.setLayout(grid);
		
		//先将各个面和标签初始化
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		
		
		redred=new JLabel("红");
		greengreen=new JLabel("绿");
		blueblue=new JLabel("蓝");
		
		
		Bubu bu=new Bubu();
		//第一版
		//下列前四行代码的作用在印象笔记12.13有
		red.setMajorTickSpacing(50);//设置JSlider的要显示的主刻度间隔setMajorTickSpacing
		red.setMinorTickSpacing(10);//设置JSlider的要显示的最小刻度间隔setMinorTickSpacing
		red.setPaintTicks(true);    //要绘制主刻度，(包括setMajorTickSpacing与setMinorTickSpacing的刻度条)setPaintTicks 必须设置为 true。 
		red.setPaintLabels(true);  //显示setMajorTickSpacing设置的的数值
		/*
		 * public void setPaintLabels(boolean b)确定是否在滑块上绘制标签。
		 * 此方法也将为您设置一个标签表。如果还没有标签表，并且主刻度间隔为 > 0，则会生成一个在主刻度标记处带有标签的标准标签表（通过调用
		 * createStandardLabels）。然后通过调用 setLabelTable 在滑块上设置标签表。
		 * 默认情况下，此属性为 false。
		 * 参数： b - 是否绘制标签
		 */

		//最重要的是对每一个JSlider加上监听器ChangeListener
		red.addChangeListener(bu);
		
		GridLayout grid1=new GridLayout(1,2);
		p1.setLayout(grid1);
		p1.add(redred);
		p1.add(red);
		add(p1);
		
		//第二版
		//最重要的是对每一个JSlider加上监听器ChangeListener
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
		
		//第三版
		//最重要的是对每一个JSlider加上监听器ChangeListener
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
		
		//第四版
		
		/*
		 * GridLayout grid4=new GridLayout(1,1,100,100); canvas.setLayout(grid4);
		 */
		add(canvas);
		//对于颜色面板的初始色必须在构造函数ColorChange中设置，不可设置在主类的构造函数中
		//setBackground(green);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public class Bubu implements ChangeListener{  
		public void stateChanged(ChangeEvent e) {
			//上一个实验：Object f=e.getSource();
			//本实验意思为：滑块：JSlider，仅获取JSlider的源头，并且返回一个类型为JSlider的类型
		JSlider source=(JSlider) e.getSource();
		
		if(source.getValueIsAdjusting()!=true) {
			//滑块的外观实现应该在开始拖动滑块时将此属性设置为 true，并在拖动结束时设为 false。
			//当 valueIsAdjusting 为 true 时，滑块模型不会产生 ChangeEvent。
			//Color类在Java.awt.Color;
			//getValue是JSlider的方法：int javax.swing.JSlider.getValue()
			Color current=new Color(red.getValue(),
					green.getValue(),
					blue.getValue());
			//changeColor方法在外部类中定义，而且它的返回值是Color类的对象
			canvas.changeColor(current);
			//repaint方法（重绘此组件）,若无，则颜色面板不更新，只能为初始色：void java.awt.Component（组成）.repaint()
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
	
	
	Color backGround; //java.awt.color中有个颜色空间colorspace
    ColorPanel(){
    	//默背景色为黑色
    backGround=Color.red;
}
    //Graphics类在：    java.awt.Graphics（制图学）中
    //Graphics2D类在：java.awt.Graphics2D       中
		public void paintComponent(Graphics comp) {
		    Graphics2D comp2D=(Graphics2D)comp; 
		    comp2D.setColor(backGround);
		    //注意fillRect：void java.awt.Graphics.fillRect(int x, int y, int width, int height)
		    //getSize:以 Dimension 对象的形式返回组件的大小。
		    //可以解释getSize().width   ==   对象.方法，在这里getSize().width可以用getWidth() 与getHight()
		    //绘制指定矩形的边框。矩形的左边缘和右边缘分别位于 x 和 x + width。上边缘和下边缘分别位于 y 和 y + height。使用图形上下文的当前颜色绘制该矩形。
		    comp2D.fillRect(0, 0, getSize().width,getSize().height);
		    // comp2D.fillRect(0, 0, getWidth(),getHeight());
		}
		//未编译的问题:没有为ColorPanel类型定义changeColor(Color)方法
		// Unresolved compilation problem:The method changeColor(Color) is undefined for the type ColorPanel

		void changeColor(Color newBackGround) {
			  backGround=newBackGround;
		}
}
			
