package QueuePrograms;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create a Pirority Queue Object
		
		PriorityQueue<Integer> pqueue = new PriorityQueue<>();
		PriorityQueue<String> squeue = new PriorityQueue<>();
		
		// Insert elements into Priority Queue
		
		pqueue.add(999);
		pqueue.add(584);
		pqueue.add(108);
		pqueue.add(855);
		pqueue.add(120);
		
		squeue.add("John");
		squeue.add("Ram");
		squeue.add("Harry");
		squeue.add("Anuj");
		squeue.add("Kartik");
		squeue.add("Anjali");
		
		System.out.println("Elements inside String PQ: "+squeue);
		
		// Print elements in dictionary order
		
		System.out.println("Elements in dictionary order are: ");
		
		while(!squeue.isEmpty()) {
			System.out.print(squeue.remove()+" ");
		}
		
		System.out.println();
		// print elements
		
		System.out.println("Elements inside priority queue are: "+pqueue);
		
		// using the peek() method
		int number = pqueue.peek();
		
		System.out.println("The head of the queue contains: "+ number);
		
		// remove elements from priority queue
		System.out.println("Element removed is: "+pqueue.poll());
		
		// Iteration over the priority queue
		Iterator<Integer> itr = pqueue.iterator();
		
		System.out.println("Iterating over the updated queue: ");
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
			
		}
		
		

	}

}
