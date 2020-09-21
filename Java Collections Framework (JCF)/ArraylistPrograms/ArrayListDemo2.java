package ArraylistPrograms;
import java.util.ArrayList;
import java.util.ListIterator;
public class ArrayListDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers=new ArrayList<Integer>();

        ArrayList<String>company=new ArrayList<String>();


        numbers.add(10);

        numbers.add(20);

        numbers.add(30);

        numbers.add(40);


        company.add("Facebook");

        company.add("Amazon");

        company.add("Tesla");

        company.add("Google");

        company.add("Flipkart");

        company.add("NCU");
        


        System.out.println("Elements inside numbers are:");

        for(int i: numbers) {

            System.out.println(i);

        }


            System.out.println("Elements inside company are:");

            //traversal using list Iterator

            ListIterator<String> obj=company.listIterator();

            while(obj.hasNext()) {

                System.out.println(obj.next());

            }


            //ListIterator<String> object=company.listIterator();

            //Adding element while traversal

            System.out.println("Elements inside company are(updated):");

//            while(obj.hasPrevious())
//            		obj.previous();
//            
            
            ListIterator<String> obj2 = company.listIterator();

            obj2.next();
            
//            obj.set("Netflix");
            
//            company.set(index, element)

            obj2.set("Microsoft");

            while(obj2.hasNext()) {


                System.out.println(obj2.next());
            }
         
            ListIterator<String> obj3 = company.listIterator();
            
            
            System.out.println("Updated list of companies: ");
            while(obj3.hasNext())
            		System.out.println(obj3.next());
            
            

//            System.out.println("ArrayList Backward Traversal: ");
//
//            while(obj.hasPrevious()) {
//
//                System.out.println(obj.previous());
//
//            }
//
//            System.out.println("size of numbers"+numbers.size());
//
//            // remove an element from numbers from index
//
//            System.out.println("After removing element");
//
//            numbers.remove(0);
//
//            for(int i: numbers) {
//
//                System.out.println(i);
//
//            }
//
//            // removing through value
//
//            System.out.println("After removing element");
//
//            numbers.remove(new Integer(30));
//
//            for(int i: numbers) {
//
//                System.out.println(i);
//
//            }
//
//
//            System.out.println("size of numbers"+numbers.size());

	}

}
