package Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Initialize a List 
		List<Integer> list = new ArrayList<>();
//		List<String> list2 = new ArrayList<>();
		list.add(100);
		list.add(180);
		list.add(200);
		list.add(300);
		list.add(500);
//		list.a
		int x = list.get(1);
		
		System.out.println("List values are: "+list);
		
//		list.add("Generics");
		
		List list2 = new ArrayList(); // This syntax was followed till Java 5
		list2.add(new Integer(800));
		list2.add(new Double(10.85));
		list2.add("This is not Type Safe");
		list2.add(new Boolean(true));
		list2.add(new Character('A'));
		
		int value = (Integer)list2.get(0); // Integer object 
		
		double value2 = (Double)list2.get(1);
		
		String str = (String)list2.get(2);
		
		System.out.println("The list elements are: "+list2);
	}

}
