package demExperience;
import java.util.*;
public class TraverseArrayList {
//ArrayListµÄ±éÀú
	
	public TraverseArrayList() {
		
		ArrayList<String> arrays=new ArrayList<String>() ;
		arrays.add(0,"ss");
		arrays.add(1,"ww");
		arrays.add(2,"ee");
		arrays.add(3,"tt");
		arrays.add(4,"mm");
		for(String array:arrays) {
			System.out.println(array);
		}
	}
	public static void main(String[] args) {
		TraverseArrayList de=new TraverseArrayList();
	}
}
