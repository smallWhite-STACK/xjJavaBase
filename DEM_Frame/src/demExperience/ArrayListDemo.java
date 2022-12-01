package demExperience;
import java.awt.Point;
import java.util.*;



//在数组结构中存储对象
/*
*z两种方式：（ArrayList）数组列表 与    哈希映射
*他们两个都是类，用于存放信息
*
*
*数组列表:可以实现数组的所有功能，而且没有数组大小的限制。
*         存储同一类对象   或     具有共同超类的对象的数据结构
*在java.util包中
*ArrayList servants=new ArrayList(x);
*x可以不写，若是x不为零，则其含义只是一个容量的提示，而并非数组的大小被确定
*
*
*
*泛型：(语言特性)
*创建ArrayList时，需要知道列表存储的类   或   超类
*记得：要在构造函数中使用<   >
*
*
*add("ObjectName")
*add(int)
*remove(int)
*remove(ObjectName)
*size()       //int a=targets.size();
*get(int)     //返回ObjectName
*indexOf("ObjetName")  //返回索引值int
*
*/
//数组列表ArrayList

public class ArrayListDemo {
//Java编译器不允许Point或其子类之外的任何其他类添加到数组列表中
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
				//让第一列显示数字
				if(row==1) {
					System.out.print(column+" ");
				}
				//让每一个坐标之间都隔开
				     System.out.print(" ");
				
				//创建一个索引的点对象
				     //其实row代表的时列，这个地方row与column可以换位置
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
		//创建点对象，把他们加入targets中
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
