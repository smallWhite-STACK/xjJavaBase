package demExperience;
import javax.swing.*;
//JTable组件
//缺陷：得到的框架中的每个表格的值都可以被更改


public class TableTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableTest() {
		super("Table");
		String[] columeLables= {
				"First Name",
				"Last Name",
				"Job",
				"Age"
		};
		Object[][] tableDate= {
				{
					//row1
					"徐","健","学生","20"
				},
				{
					//row2
					"王","帅飞","学生","21"
				},
				{
					//row2
					"王","帅飞","学生","21"
				},
				{
					//row2
					"王","帅飞","学生","21"
				},
				{
					//row2
					"王","帅飞","学生","21"
				},
				{
					//row2
					"王","帅飞","学生","21"
				},
				{
					//row2
					"王","帅飞","学生","21"
				},
				{
					//row2
					"王","帅飞","学生","21"
				},
				{
					//row2
					"王","帅飞","学生","21"
				},
				{
					//row3
					"张","三","老师","50"
				}
		};
		
		JTable table=new JTable(tableDate,columeLables);
		JScrollPane scroll=new JScrollPane(table);
		
	    //JTable对象的方法(设置填充视口高度)setFillsViewportHeight(boolean);
		table.setFillsViewportHeight(true);
		//可以使表格占用图形用户界面的所有可用的高度
		
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll);
		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		TableTest test1=new TableTest();
		
		
	}
	
	
}
