/*********************************************************************************
* (Sum ArrayList) Write the following method that returns the sum of all numbers *
* in an ArrayList:                                                               *
*                                                                                *
* public static double sum(ArrayList<Double> list)                               *
*                                                                                *
* Write a test program that prompts the user to enter 5 numbers, stores them in  *
* an array list, and displays their sum.                                         *
*********************************************************************************/
import java.util.Scanner;
import java.util.ArrayList;

public class Exercise_11_12 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Create an ArrayList
		ArrayList<Double> list = new ArrayList<Double>();

		// Prompt the user to enter 5 numbers
		System.out.print("Enter 5 numbers: ");
		for (int i = 0; i < 5; i++) {
			list.add(input.nextDouble());
		}

		// Display the sum of the list
		System.out.println("Sum of list: " + sum(list));
	}

	/** Returns the sum of all numbers in an ArrayList */
	public static double sum(ArrayList<Double> list) {
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}
}