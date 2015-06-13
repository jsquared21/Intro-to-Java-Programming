/*********************************************************************************
* (Find the smallest element) Write a method that finds the smallest element in  *
* an array of double values using the following header:                          *
* public static double min(double[] array)                                       *
* Write a test program that prompts the user to enter ten numbers, invokes this  *
* method to return the minimum value, and displays the minimum value.            *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_07_09 {
	/** Main method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Create a Scanner
		double[] numbers = new double[10]; // Create array of length 10

		// Prompt the user to enter ten numbers
		System.out.print("Enter ten numbers: ");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextDouble();
		}

		// Display the minimum value
		System.out.println("The minimum number is: " + min(numbers));
	}

	/** Method min returns the smallest element in an array of double values */
	public static double min(double[] array) {
		double min = array[0];	// The minimum value
		for (double i: array) {
			if (i < min)
				min = i;
		}
		return min;
	}
}