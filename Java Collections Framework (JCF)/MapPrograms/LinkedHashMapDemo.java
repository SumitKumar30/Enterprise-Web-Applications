package MapPrograms;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LinkedHashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedHashMap<String,Integer> link = new LinkedHashMap<>();
		
		link.put("Venus", 2);
		link.put("Mercury", 1);
		link.put("Jupiter", 5);
		link.put("Mars", 4);
		link.put("Earth", 3);
		link.put("Saturn", 6);
		
		System.out.println("Elements inside Linked Hash Map are: "+link);
		
		System.out.println("Elements inside Map Entry Set: "+link.entrySet());
		
		System.out.println("Planet names are: "+link.keySet());
		
		System.out.println("Position of each planet is: "+link.values());
		
		for(Entry<String, Integer> entry: link.entrySet()) {
			System.out.println(entry+", ");
		}
		
		System.out.println("Traversal using iterator: ");
		
		Iterator<Entry<String, Integer>> itr = link.entrySet().iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
