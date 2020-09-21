package StackPrograms;

import java.util.Scanner;
import java.util.Stack;

public class StackReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sentence: ");
		String str = sc.nextLine();
		
		System.out.println("Entered sentence is: "+str);
		
		// "Mary had a little lamb." --> single string
		
		String[] words = str.split(" ");
		Stack<String> stack = new Stack<>();
		
		for(int i = 0; i < words.length; i++) {
			String temp = words[i];
			if(temp.endsWith(".")) {
				stack.push(temp.substring(0, temp.length()-1));
				break;
			}
			else {
				stack.push(temp);
			}	
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		System.out.println(".");
	}

}
