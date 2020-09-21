package SetPrograms;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> auto = new HashSet<>();
		
		// adding elements inside a hashset
		
		auto.add("BMW");
		auto.add("Jeep");
		auto.add("Maruti Suzuki");
		auto.add("Jaguar");
		auto.add("Porche");
		auto.add("Toyota");
		
		
		// printing elements inside a hashset
		System.out.println("Elements inside my hashset: "+auto);
		
		auto.remove("Toyota");
		
		System.out.println("Traversal using iterator: ");
		
		Iterator<String> itr = auto.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("Set contains Toyota? "+auto.contains("Toyota"));
		
		HashSet<String> auto2 = new HashSet<>();
		
		auto2.add("Mini Cooper");
		auto2.add("Mclaren");
		auto2.add("Tesla");
		auto2.add("Lexus");
		auto2.add("Lamborghini");
		auto2.add("Jaguar");
		
		System.out.println("Elements inside 2nd set: "+auto2);
		
		// Union, intersection, difference
		
//		auto.retainAll(auto2);
//		
//		System.out.println("Intersection of two sets: "+auto);
//		
//		auto.addAll(auto2);
//		
//		System.out.println("Union of two sets: "+auto);
		
		auto2.removeAll(auto);
		
		System.out.println("Difference of two sets: "+auto2);
		
	}

}
