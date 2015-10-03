/*********************************************************************************
* (Print the digits in an integer reversely) Write a recursive method that       *
* displays an int value reversely on the console using the following header:     *
*                                                                                *
* public static void reverseDisplay(int value)                                   *
*                                                                                *
* For example, reverseDisplay(12345) displays 54321. Write a test program that   *
* prompts the user to enter an integer and displays its reversal.                *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_18_08 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter an integer
		System.out.print("Enter an integer: ");
		int value = input.nextInt();

		// Display value reversely
		reverseDisplay(value);
	}

	/** Method displays an int value reversely */
	private static void reverseDisplay(int value) {
		if (value < 10) // Base case
			System.out.println(value);
		else { 
			System.out.print(value % 10);
			reverseDisplay(value / 10); // Recursive call
		}
	}
}