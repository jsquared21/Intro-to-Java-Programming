/*********************************************************************************
* (Maximum consecutive increasingly ordered substring) Write a program that      *
* prompts the user to enter a string and displays the maximum consecutive        *
* increasingly ordered substring. Analyze the time complexity of your program.   *
*********************************************************************************/
import java.util.*;

public class Exercise_22_01 {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		LinkedList<Character> max = new LinkedList<>();
		LinkedList<Character> list = new LinkedList<>();

		// Prompt the user to enter a string
		System.out.print("Enter a string: ");
		String string = input.nextLine(); 

		// Find the maximum consecutive increasingly ordered substring
		for (int i = 0; i < string.length(); i++) { 		// single loop
			if (list.size() > 1 && string.charAt(i) <= list.getLast() && 
				list.contains(string.charAt(i))) {
				list.clear(); // Simple statement
			}

			list.add(string.charAt(i)); // Simple statement

			if (list.size() > max.size()) { // Simple statement
				max.clear();
				max.addAll(list);
			}
		}

		// Display the maximum consecutive 
		// increasingly ordered substring
		for (Character ch: max) { // single loop
			System.out.print(ch); // Simple statement
		}
		System.out.println();
	}

/*********************************************************************************
* 	Analyze the time complexity of your program:                                  *  
* 	1 single loop * 3 simple statements = 3;                                      *
* 	1 single loop * 1 simple statement = 1;                                       * 
*                                                                                *  
* 	T(n) = O(n) Linear time;                                                      * 
*********************************************************************************/ 
}