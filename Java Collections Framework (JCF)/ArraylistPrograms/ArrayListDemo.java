// 1. Create 2. Traverse 3. Insert 4. Remove 5. Search 6. Sort
package ArraylistPrograms;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creation
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<String> list2 = new ArrayList<String>();
		
//		ArrayList list3 = new ArrayList(); // General list 
		
		// Adding elements in the ArrayList
		
		list1.add(100);
		list1.add(200);
		list1.add(300);
		list1.add(400);
		list1.add(500);
		list1.add(2, 5000);
		
//		list3.add("Hello");ITIIII
//		list3.add(2000);
//		list3.add(100.23);
//		list3.add(false);
		
//		System.out.println(list3);
		
		
		list2.add("Facebook");
		list2.add("Amazon");
		list2.add("Tesla");
		list2.add("Google");
		list2.add("Flipkart");
		list2.add(1, "NCU");		
		
		System.out.println("Elements inside ArrayList 1");
		for(int values: list1) {
				System.out.println(values);
		}
		
		System.out.println("Elements inside ArrayList 2");
//		for(String data: list2) {
//			System.out.println(data);
//		}
		
		// Traversal using an Iterator
//		Iterator<String> itr = list2.iterator();
//		while(itr.hasNext()){
//			System.out.println(itr.next());
//		}
		
		// Traversal using a ListIterator
		ListIterator<String> listItr = list2.listIterator();
		listItr.next();
		listItr.set("Microsoft");
		while(listItr.hasNext()) {
			System.out.println(listItr.next());
		}
		
		System.out.println("ArrayList Backward Traversal: ");
		while(listItr.hasPrevious()) {
			System.out.println(listItr.previous());
		}
		
		
		list2.remove(2);
		
		System.out.println("Elements updated inside ArrayList 2");
		for(String data: list2) {
			System.out.println(data);
		}
		
		list1.remove(1);		// removes element at index 1
		list1.remove(new Integer(5000));		// removes element by its value --> 5000
		System.out.println("Elements updated inside ArrayList 1");
		for(int values: list1) {
				System.out.println(values);
		}
		
		System.out.println("Size of ArrayList 1 is: "+list1.size());
		
	}

}
