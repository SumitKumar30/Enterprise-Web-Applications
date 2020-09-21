package QueuePrograms;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
public class QueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. LinkedList 2. Priority Queue
		
		Queue<String> queueL = new LinkedList<String>(); 
		
		// inserting elements into Queue
		queueL.add("Apple");
		queueL.add("Samsung");
		queueL.add("OnePlus");
		queueL.add("Asus");
		queueL.add("Nokia");
		queueL.add("RealMe");
		
		System.out.println("Elements inside the queue: "+queueL);
		
		System.out.println("Element at the front: "+queueL.peek());
		
		queueL.remove();
		
		System.out.println("Updated Queue Elements: "+queueL);
		
		queueL.poll();
		
		System.out.println("Updated Queue Elements: "+queueL);
		
		queueL.add("Motorola");
		
		System.out.println("Inserted one more element: "+queueL);
		
		// Iterator --> Queue traversal
		
		queueL.offer("Huawie");
		
		System.out.println("Updated again: "+queueL);
		
		System.out.println("Element at the front now: "+queueL.element());
		
		Iterator<String> itr = queueL.iterator();
		
		System.out.println("Iterating over the queue: ");
		
		itr.next();
		itr.remove();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		

	}

}
