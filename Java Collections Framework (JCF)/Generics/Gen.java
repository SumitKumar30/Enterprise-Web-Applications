package Generics;

public class Gen<T> {
	T ob; 	// declare an object of type T
	// Pass the constructor a reference to an object of type T.
	Gen(T o) {
		ob = o;
	}
	// Return ob.
	T getob() {
		return ob;
	}
	// Show type of T.
	void showType() {
			System.out.println("Type of T is " + ob.getClass().getName());
	}
}
