package SetPrograms;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashSet<Integer> link = new LinkedHashSet<>();
		
		link.add(21);
		link.add(25);
		link.add(30);
		link.add(33);
		link.add(35);
		
		System.out.println("Elements inside LinkedHashSet are: "+link);
		
		Iterator<Integer> itr = link.iterator();
		
		System.out.println("Traversal through iterator: ");
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
