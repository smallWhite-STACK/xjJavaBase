package demExperience;
import javax.swing.*;
//JTable���
//ȱ�ݣ��õ��Ŀ���е�ÿ������ֵ�����Ա�����


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
					"��","��","ѧ��","20"
				},
				{
					//row2
					"��","˧��","ѧ��","21"
				},
				{
					//row2
					"��","˧��","ѧ��","21"
				},
				{
					//row2
					"��","˧��","ѧ��","21"
				},
				{
					//row2
					"��","˧��","ѧ��","21"
				},
				{
					//row2
					"��","˧��","ѧ��","21"
				},
				{
					//row2
					"��","˧��","ѧ��","21"
				},
				{
					//row2
					"��","˧��","ѧ��","21"
				},
				{
					//row2
					"��","˧��","ѧ��","21"
				},
				{
					//row3
					"��","��","��ʦ","50"
				}
		};
		
		JTable table=new JTable(tableDate,columeLables);
		JScrollPane scroll=new JScrollPane(table);
		
	    //JTable����ķ���(��������ӿڸ߶�)setFillsViewportHeight(boolean);
		table.setFillsViewportHeight(true);
		//����ʹ���ռ��ͼ���û���������п��õĸ߶�
		
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
