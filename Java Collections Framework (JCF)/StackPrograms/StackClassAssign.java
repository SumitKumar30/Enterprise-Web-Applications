package StackPrograms;
import java.util.Scanner;
import java.util.Stack;
public class StackClassAssign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:");
		String str = new String();
		str = sc.nextLine();
		System.out.println("Entered string: "+str);
		Stack<String> s = new Stack<String>();
//		String[] fs = str.split(".");
		String[] fs = str.split(" ");
		System.out.println("Reversed string is: ");
		int i = 0;
		do {
			while(i < fs.length) {
				String string = fs[i];
				i = i+1;
				if(string.endsWith(".")) {
					s.push(string.substring(0, string.length()-1));
					break;
				}
				else {
					s.push(string);
				}
			}
			while(!s.isEmpty()) {
				if(s.size() == 1)		
					System.out.print(s.pop());
				else
					System.out.print(s.pop()+" ");
			}
			System.out.print("."+" ");
		}while(i < fs.length);
		
		
	}

}
