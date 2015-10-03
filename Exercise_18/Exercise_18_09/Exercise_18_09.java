/*********************************************************************************
* (Print the characters in a string reversely) Write a recursive method that     *
* displays a string reversely on the console using the following header:         *  
*                                                                                *
* public static void reverseDisplay(String value)                                *
*                                                                                *
* For example, reverseDisplay("abcd") displays dcba. Write a test program that   *
* prompts the user to enter a string and displays its reversal.                  *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_18_09 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a string
		System.out.print("Enter a string: ");
		String value = input.next();

		// Display the value reversely
		reverseDisplay(value);
	}

	/** Method displays the characters in a string reversely */
	private static void reverseDisplay(String value) {
		if (value.length() == 1) // Base case
			System.out.println(value);
		else {
			System.out.print(value.charAt(value.length() - 1));
			reverseDisplay(value.substring(0, value.length() - 1)); // Recursive call
		}
	}
}