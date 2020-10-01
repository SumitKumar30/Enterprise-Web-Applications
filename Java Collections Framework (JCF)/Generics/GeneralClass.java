package Generics;

public class GeneralClass<T> {
		// declare generic class objects
		
		// T can be of any type --> Wrapper object / User defined object
		private T data;
		
//		GeneralClass(T data){
//			this.data = data;
//		}
		
		void setData(T data) {
			this.data = data;
		}
		
		// return any type of value 
		T getData(){
			return this.data;
		}
}
