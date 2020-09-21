package Generics;

public class GeneralClass<Z> {
		// declare generic class objects
		
		// T can be of any type --> Wrapper object / User defined object
		private Z data;
		
//		GeneralClass(T data){
//			this.data = data;
//		}
		
		void setData(Z data) {
			this.data = data;
		}
		
		// return any type of value 
		Z getData(){
			return this.data;
		}
}
