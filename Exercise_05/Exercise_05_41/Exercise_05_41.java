/*
(Occurrence of max numbers) Write a program that reads integers, finds the largest
of them, and counts its occurrences. Assume that the input ends with number
0. Suppose that you entered 3 5 2 5 5 5 0; the program finds that the largest
is 5 and the occurrence count for 5 is 4.
(Hint: Maintain two variables, max and count. max stores the current max number,
and count stores its occurrences. Initially, assign the first number to max
and 1 to count. Compare each subsequent number with max. If the number is
greater than max, assign it to max and reset count to 1. If the number is equal to
max, increment count by 1.)
*/
import java.util.Scanner;

public class Exercise_05_41 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter number
		System.out.print("Enter numbers: ");
		int max = input.nextInt();	// Assign the first number to max
		int count = 1;					// Assign 1 to count
		int number;						// Holds future inputs

		// Assume that the input ends with number 0
		while (number > 0) {
			number = input.nextInt();
			if (number > max) {
				max = number;
				count = 1;
			}
			if (number == max)
				count++;
		} 

		// Display to results
		System.out.println("The largest number is " + max);
		System.out.println(
			"The occurrence count of the largest number is " + count);
	}
}