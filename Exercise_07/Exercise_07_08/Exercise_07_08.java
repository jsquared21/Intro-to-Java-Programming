/************************************************************************************
* (Average an array) Write two overloaded methods that return the average of an     *
* array with the following headers:                                                 *
* public static int average(int[] array)                                            *
* public static double average(double[] array)                                      *
* Write a test program that prompts the user to enter ten double values, invokes    *
* this method, and displays the average value.                                      *
*************************************************************************************/
import java.util.Scanner;

public class Exercise_07_08 {
	/** Main method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double[] values = new double[10]; // Array of length 10

		// Prompt the user to enter ten double values
		System.out.print("Enter ten values of double type: ");
		for (int i = 0; i < values.length; i++) {
			values[i] = input.nextDouble();
		}

		// Display the average value
		System.out.println("The average value: " + average(values));
	}

	/* Overloaded method average accepts an integer array and returns its average */
	public static int average(int[] array) {
		int average = 0; 
		for (int i: array)
			average += i;	// Add indexed value to average
		return average / array.length;
	}   

	/* Overloaded method average accepts an double array and returns its average */
	public static double average(double[] array) {
		double average = 0; 
		for (double i: array)
			average += i; // Add indexed value to average
		return average / array.length;
	}
}