package ArraylistPrograms;

public class ArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = new String[5]; // size is static 
		str[0] = "Facebook";
		str[1] = "Amazon";
		str[2] = "Apple";
		str[3] = "Google";
		str[4] = "Tesla";
		str[5] = "Netflix";
		
		System.out.println("List of companies are: ");
		for(int i = 0 ; i< str.length; i++) {
				System.out.println(str[i]);
		}

	}

}
