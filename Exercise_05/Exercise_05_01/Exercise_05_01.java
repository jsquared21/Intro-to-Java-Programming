/*
(Count positive and negative numbers and compute the average of numbers) Write
a program that reads an unspecified number of integers, determines how many
positive and negative values have been read, and computes the total and average of
the input values (not counting zeros). Your program ends with the input 0. Display
the average as a floating-point number.
*/
import java.util.Scanner;

public class Exercise_05_01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int positives = 0; 	// Count the number of positive numbers
		int negatives = 0; 	// Count the number of negative numbers
		int count = 0;			// Count all numbers
		double total = 0;		// Accumulate a totol


		// Promopt the user to enter an integer or 0 to exit
		System.out.print("Enter an integer, the input ends if it is 0: ");
		int number = input.nextInt();

		if (number == 0) {	// Test for sentinel value
			System.out.println("No numbers are entered except 0");
			System.exit(1);
		}

		while (number != 0) {// Test for sentinel value
			if (number > 0)
				positives++;	// Increase positives
			else
				negatives++;	// Increase negatives
			total += number;	// Accumulate total
			count++;				// Increase the count
			number = input.nextInt();
		}

		// Calculate the average
		double average = total / count;

		// Display results
		System.out.println(
			"The number of positive is " + positives +
			"\nThe number of negatives is " + negatives +
			"\nThe total is total " + total +
			"\nThe average is " + average);
	}
}