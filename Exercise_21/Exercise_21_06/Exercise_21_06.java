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
		Map<Integer, Integer> map = new HashMap<>(); // Stores results

		// Prompt the user to enter a number of integers
		System.out.println("Enter a number of integers." 
			+ "\nInput ends when the input is 0:");

		int key;
		while ((key = input.nextInt()) != 0) {
			if (!map.containsKey(key)) {
				map.put(key, 1);
			}
			else {
				int frequency = map.get(key);
				frequency++;
				map.put(key, frequency);
			}
		}

		// Find the maximum occurrence
		int max = Collections.max(map.values());

		// Display the integers that have the most occurences
		System.out.print("The most occurrences integers are: ");
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				System.out.print(entry.getKey() + " ");
			}
		}
		System.out.println();
	}
}