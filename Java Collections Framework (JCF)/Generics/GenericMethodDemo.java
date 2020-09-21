package Generics;

public class GenericMethodDemo {

	// Determine if the contents of two arrays are the same.
		static <T, V extends T > boolean arraysEqual(T[] x, V[] y) {
		// If array lengths differ, then the arrays differ.
		if(x.length != y.length) 
			return false;
		for(int i=0; i < x.length; i++)
		if(x[i] != y[i]) 
			return false; // arrays differ
		return true; // contents of arrays are equivalent
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer nums[] = { 1, 2, 3, 4, 5 };
		Integer nums2[] = { 1, 2, 3, 4, 5 };
		Integer nums3[] = { 1, 2, 7, 4, 5 };
		Integer nums4[] = { 1, 2, 7, 4, 5, 6 };
		if(arraysEqual(nums, nums))
			System.out.println("nums equals nums");
		if(arraysEqual(nums, nums2))
			System.out.println("nums equals nums2");
		if(arraysEqual(nums, nums3))
			System.out.println("nums equals nums3");
		if(arraysEqual(nums, nums4))
			System.out.println("nums equals nums4");
		// Create an array of Doubles
		Character dvals[] = { 'A', 'B'};
//			 This won't compile because nums and dvals are not of the same type.
				 if(arraysEqual(nums2, dvals))
					 System.out.println("nums equals dvals");
				 else
					 System.out.println("nums not equals dvals");
		System.out.println("Class is: "+nums2.getClass().getName());
	}
	

	

}
