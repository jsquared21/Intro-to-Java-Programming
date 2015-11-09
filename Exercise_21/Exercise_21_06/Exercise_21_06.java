/**********************************************************************************
* (Count the occurrences of numbers entered) Write a program that reads an        *
* unspecified number of integers and finds the one that has the most occurrences. *
* The input ends when the input is 0. For example, if you entered 2 3 40 3 5 4 –3 *
* 3 3 2 0, the number 3 occurred most often. If not one but several numbers have  *
* the most occurrences, all of them should be reported. For example, since 9 and  *
* 3 appear twice in the list 9 30 3 9 3 2 4, both occurrences should be reported. *
**********************************************************************************/
import java.util.*;

public class Exercise_21_06 {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Create a list and two sets
		List<Integer> list = new LinkedList<>();	// Stores all integers
		TreeSet<Integer> set = new TreeSet<>();	// Stores nonduplicate integers
		Set<Integer> results = new HashSet<>();	// Stores results

		// Prompt the user to enter a number of integers
		System.out.println("Enter a number of integers." 
			+ "\nInput ends when the input is 0:");

		int integer;
		while ((integer = input.nextInt()) != 0) {
			list.add(integer);
			set.add(integer);
		}

		// Find the maximum occurrence
		int max = 0;
		for (Integer i: set) {
			int frequency = Collections.frequency(list, i);
			if (frequency > max)
				max = frequency;
		}

		// Add integers with the most occurrences to list
		for (Integer i: set) {
			if (Collections.frequency(list, i) == max)
				results.add(i);
		}

		// Display the integers that have the most occurences
		if (results.size() > 1) {
			System.out.println("The integers that have the most occurrences are: " 
				+ results);
		}
		else
			System.out.println("The integer that has the most occurrences is: " 
				+ results);

	}
}