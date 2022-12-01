package demExperience;
import java.awt.Point;
import java.util.*;



//������ṹ�д洢����
/*
*z���ַ�ʽ����ArrayList�������б� ��    ��ϣӳ��
*�������������࣬���ڴ����Ϣ
*
*
*�����б�:����ʵ����������й��ܣ�����û�������С�����ơ�
*         �洢ͬһ�����   ��     ���й�ͬ����Ķ�������ݽṹ
*��java.util����
*ArrayList servants=new ArrayList(x);
*x���Բ�д������x��Ϊ�㣬���京��ֻ��һ����������ʾ������������Ĵ�С��ȷ��
*
*
*
*���ͣ�(��������)
*����ArrayListʱ����Ҫ֪���б�洢����   ��   ����
*�ǵã�Ҫ�ڹ��캯����ʹ��<   >
*
*
*add("ObjectName")
*add(int)
*remove(int)
*remove(ObjectName)
*size()       //int a=targets.size();
*get(int)     //����ObjectName
*indexOf("ObjetName")  //��������ֵint
*
*/
//�����б�ArrayList

public class ArrayListDemo {
//Java������������Point��������֮����κ���������ӵ������б���
	ArrayList<Point> targets=new ArrayList<Point>();
	//showMap_____createTargets_____shoot
	
	public ArrayListDemo() {
		createTargets();
		showMap();
		shoot(5,6);
		shoot(5,9);
		shoot(1,1);
		showMap();
		
		
	}
	
	//showMap
	public void showMap() {
		int column;
		int row;
		System.out.println("\n   1  2  3  4  5  6  7  8  9");
		for( column=1;column<10;column++) {
			for(row=1;row<10;row++) {
				//�õ�һ����ʾ����
				if(row==1) {
					System.out.print(column+" ");
				}
				//��ÿһ������֮�䶼����
				     System.out.print(" ");
				
				//����һ�������ĵ����
				     //��ʵrow�����ʱ�У�����ط�row��column���Ի�λ��
				Point pot=new Point(row,column);
				if(targets.indexOf(pot)>-1) {
					System.out.print("X");
				}else {
					System.out.print("*");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private void createTargets() {
		//��������󣬰����Ǽ���targets��
		Point p1=new Point(5,9);
		targets.add(p1);
		Point p2=new Point(4,5);
		targets.add(p2);
		Point p3=new Point(9,2);
		targets.add(p3);
		int a=targets.size();
		System.out.println(a);
	}
	private void shoot(int x,int y) {
		Point shot=new Point(x,y);
		System.out.println("Firing at+("+x+" "+y+")+...");
		if(targets.indexOf(shot)>-1) {
			System.out.println("niu");
			targets.remove(shot);
			
		}else {
			System.out.println("-----------");
		}

	}
	
	public static void main(String[] args) {
		ArrayListDemo x1=new ArrayListDemo();
	}

}
