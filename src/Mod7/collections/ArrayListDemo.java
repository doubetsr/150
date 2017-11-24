package collections;
import java.util.*;

/**
 * Demonstrate the use of ArrayList
 * 
 * @author Sherri Harms
 *
 */
public class ArrayListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create an array list that can hold any type of object
		ArrayList list = new ArrayList();
		
		// Put different types of data into it
		list.add(1);
		list.add(new Integer(2));
		list.add(2.5);
		list.add("three");
		
		// Show all the data
		for (int i=0; i<list.size(); i++) {
			Object obj = list.get(i);
			if (obj instanceof Integer) {
				Integer n = (Integer)obj;
				System.out.println(n.intValue());
			} else if (obj instanceof Double){
				Double n = (Double)obj;
			System.out.println(n.doubleValue());
		} else if (obj instanceof String)
			System.out.println((String)obj);
		}
		
		// We can limit the data to be one single type
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		// Add some elements in
		
		// Nope, you can't do this
		//arr.add("one");
		arr.add(1);
		arr.add(new Integer(2));
//		arr.add(2.5);
		
		// Show all the data
		for (Integer n : arr)
			System.out.println(n.intValue());
	}

}
