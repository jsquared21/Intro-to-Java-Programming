/*********************************************************************************
* (Use ArrayList) Write a program that creates an ArrayList and adds a Loan      *
* object, a Date object, a string, and a Circle object to the list, and use a    *
* loop to display all the elements in the list by invoking the object’s          *
* toString() method.                                                             *
*********************************************************************************/
import java.util.ArrayList;
import java.util.Date;

public class Exercise_11_06 {
	// Main method
	public static void main(String[] args) {
		// Create an array list of objects
		ArrayList<Object> o = new ArrayList<Object>();
		o.add(new Loan());		
		o.add(new Date());		
		o.add(new String("String class"));	
		o.add(new Circle());	

		// Display all the elements in the list by 
		// invoking the object’s toString() method
		for (int i = 0; i < o.size(); i++) {
			System.out.println((o.get(i)).toString());
		}
	}
}