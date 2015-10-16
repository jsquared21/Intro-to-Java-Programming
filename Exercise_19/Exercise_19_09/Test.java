import java.util.*;

public class Test {
	public static void main(String[] args) {
	 	// Create a  list of Integers
	 	Integer[] intArray = {new Integer(2), new Integer(4),
	 	new Integer(3)};
	 	ArrayList<Integer> intList = 
	 		new ArrayList<>(Arrays.asList(intArray));
	 	
	 	// Create a list of Doubles
	 	Double[] doubleArray = {new Double(3.4), new Double(1.3),
	 	new Double(-22.1)};
	 	ArrayList<Double> doubleList = 
	 		new ArrayList<>(Arrays.asList(doubleArray));
	 		
	 	// Create a list of Characters
	 	Character[] charArray = {new Character('a'),
	 	new Character('J'), new Character('r')};
	 	ArrayList<Character> charList = 
	 		new ArrayList<>(Arrays.asList(charArray));
	 	
	 	// Create a list of Strings
	 	String[] stringArray = {"Tom", "Susan", "Kim"};
	 	ArrayList<String> stringList = 
	 		new ArrayList<>(Arrays.asList(stringArray));
	 	
	 	// Sort the lists
	 	Exercise_19_09.sort(intList);
	 	Exercise_19_09.sort(doubleList);
	 	Exercise_19_09.sort(charList);
	 	Exercise_19_09.sort(stringList);
	 
	 	// Display the sorted lists
	 	System.out.println("Sorted Integer objects: " + intList);
	 	System.out.println("Sorted Double objects: " + doubleList);
	 	System.out.println("Sorted Character objects: " + charList);
	 	System.out.println("Sorted String objects: " + stringList);
	}
}