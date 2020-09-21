package StackPrograms;

import java.util.Iterator;
import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<>();
		stack.push("Elon Musk");
		stack.push("Mukesh Ambani");
		stack.push("Nikola Tesla");
		stack.push("Mark Zuckerburg");
		stack.push("Steve Jobs");
		stack.push("Narendra Modi");
		
//		for(String str: stack) {
//			System.out.println(str);
//		}
		
		System.out.println(stack);
		
		stack.pop();
		
		System.out.println(stack);
		
		System.out.println(stack.peek());
		
//		while(!(stack.isEmpty())) {
//			stack.pop();
//		}
//		
		System.out.println("size of my stack is: "+ stack.size());
		
		Iterator<String> itr = stack.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		
	}

}
