package MapPrograms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer,String> map = new HashMap<>();
		
		// Insert elements inside Map
		map.put(102, "India");
		map.put(103, "Taiwan");
		map.put(101, "Germany");
		map.put(104, "United States");
		map.put(105, "England");
		map.put(108, "France");
		map.put(110, "Canada");
		map.put(106, "Russia");
		map.put(204, "Mexico");
		map.put(99, "Japan");
		map.put(150, "Vatican City");
		map.put(210, "Dubai");
		
		map.putIfAbsent(204, "Singapore");
		
		System.out.println("Value of key 99 is: "+map.get(99));
		
		System.out.println("Remove value: "+map.remove(150));
		
		System.out.println("Elements inside HashMap: "+map);
		
		HashMap<String, String> map2 = new HashMap<>();
		
		map2.put("Microsoft", "Windows 10");
		map2.put("Apple", "iPhone");
		map2.put("Samsung", "Galaxy Note");
		map2.put("Asus", "ROG Phone");
		map2.put("Intel", "i5 processor");
		map2.put("AMD", "Ryzen 5");
		map2.put("Samsung", "S 10");
		
		System.out.println("Elements inside 2nd HashMap: "+map2);
		
		// Accessing elements inside Map
		
		System.out.println("Key/Value Mapping of map2: "+map2.entrySet());
		
		System.out.println("Keys insdie map2 are: "+map2.keySet());
		
		System.out.println("Values inside map2 are:"+map2.values());
		
		
//		Iterator<Integer>
		// Traversal using for each loop
		for(Entry<String, String> entry: map2.entrySet()) {
			System.out.println(entry+", ");
		}
		
		for(String keys: map2.keySet()) {
			System.out.println(keys+", ");
		}
		for(String values: map.values()) {
			System.out.println(values+", ");
		}
		
		// Traversal using iterator
		
		Iterator<Entry<String, String>> itr = map2.entrySet().iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
