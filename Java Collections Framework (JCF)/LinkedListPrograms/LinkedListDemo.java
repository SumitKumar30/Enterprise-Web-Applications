package LinkedListPrograms;
import java.util.LinkedList;
import java.util.ListIterator;
public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> list = new LinkedList<>();
		LinkedList<String> staff = new LinkedList<>();
		
		ListIterator<String> iterator = staff.listIterator();
		
		iterator.add("Tom");
		iterator.add("Diana");
		iterator.add("Harry");
		
		iterator = staff.listIterator();
		
		if(iterator.next().equals("Tom")){
			iterator.remove();
		}
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		list.add("Mr. Robot");
		list.add("Friends");
		list.add("Breaking Bad");
		list.add("GOT");
		list.add("Money Heist");
		list.add("Gotham");
		
		System.out.println(list);
		
		ListIterator<String> itr = list.listIterator();
//		itr.next();
		itr.add("Peaky Blinders");
		itr.add("Ricky & Morty");
//		itr.set("Supernatural");
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("Linked list in reverse order:");
		while(itr.hasPrevious()) {
			System.out.println(itr.previous());
		}
		
		list.remove(2);
		System.out.println(list);
		
//		list.clear();
		
//		list.removeAll(list);
		
		
		
		
	}

}
