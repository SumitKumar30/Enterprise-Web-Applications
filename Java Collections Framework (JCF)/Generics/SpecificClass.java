package Generics;

public class SpecificClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralClass<Integer> obj = new GeneralClass<>();
		
		obj.setData(new Integer(100));
		
		GeneralClass<String> obj2 = new GeneralClass<>();
		
		obj2.setData(new String("This is Generics"));
		
//		GeneralClass<Double> obj3 = new GeneralClass<>(new Double(45.85));
		
//		GeneralClass<Boolean> obj4 = new GeneralClass<>(new Boolean(true));
		
		System.out.println("Integer value is: "+obj.getData());
		
		System.out.println("String value is: "+obj2.getData());
//		System.out.println("Double value is: "+obj3.getData());
//		System.out.println("Boolean value is: "+obj4.getData());
 	}

}
