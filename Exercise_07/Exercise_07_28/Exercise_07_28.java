/*********************************************************************************
* (Math: combinations) Write a program that prompts the user to enter 10 integers*
* and displays all combinations of picking two numbers from the 10.              *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_07_28 {
	/** Main method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Create a Scanner
		int[] numbers = new int[10]; // Create an array of length ten

		// Prompt the user to enter 10 integers
		System.out.print("Enter ten numbers: ");
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = input.nextInt();

		// Display all combinations
		printCombinations(numbers);
	}

	/** printCombinations displays all combinations  
	*   of picking two numbers from the array */
	public static void printCombinations(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (i != j)
					System.out.println(numbers[i] + " " + numbers[j]);
			}
		}
	}
}