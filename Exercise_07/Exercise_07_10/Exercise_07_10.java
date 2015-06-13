/*********************************************************************************
* (Find the index of the smallest element) Write a method that returns the index *
* of the smallest element in an array of integers. If the number of such elements* 
* is greater than 1, return the smallest index. Use the following header:        *
* public static int indexOfSmallestElement(double[] array)                       *
* Write a test program that prompts the user to enter ten numbers, invokes this  *
* method to return the index of the smallest element, and displays the index.    *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_07_10 {
	/** Main method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] numbers = new double[10]; // Create an array of length ten

		// Prompt the user to enter ten numbers
		System.out.print("Enter ten numbers: ");
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = input.nextDouble();

		// Display the smallest value
		System.out.println("The minimum number is " + 
			numbers[indexOfSmallestElement(numbers)] + " index " +
			indexOfSmallestElement(numbers));
	}

	/** Method indexOfSmallestElement returns the index of  
	*   the smallest element in an array of integers */
	public static int indexOfSmallestElement(double[] array) {
		if (array.length <= 1)
			return 0;
		
		double min = array[0];
		int minimumIndex = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
				minimumIndex = i;
			}
		}
		return minimumIndex;
	}
}