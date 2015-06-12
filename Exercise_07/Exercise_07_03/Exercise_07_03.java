/*
(Count occurrence of numbers) Write a program that reads the integers between 1
and 100 and counts the occurrences of each. Assume the input ends with 0.
Note that if a number occurs more than one time, the plural word “times” is used
in the output.
*/
import java.util.Scanner;

public class Exercise_07_03 {
	/** Main Method */
	public static void main(String[] args) {
		int[] counts = new int[100]; // Counts the occurrences of numbers

		// Prompt the user to enter integers between 1 and 100
		System.out.print("Enter the integers between 1 and 100: ");

		// Count occurrence of numbers
		count(counts);

		// Display results
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] > 0)
				System.out.println((i + 1) + " occurs " + counts[i] +
					" time" + (counts[i] > 1 ? "s" : ""));
		}
	}

	/** Method count reads integers between 1 and 100 
	*   and counts the occurrences of each */
	public static void count(int[] counts){
		Scanner input = new Scanner(System.in);
		int num; // holds user input
		do {
			num = input.nextInt();
			if (num >= 1 && num <= 100)	
				counts[num - 1]++;
		} while (num != 0);
	}
}
