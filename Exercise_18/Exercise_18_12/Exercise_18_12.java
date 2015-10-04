/*********************************************************************************
* (Print the characters in a string reversely) Rewrite Programming Exercise 18.9 *
* using a helper method to pass the substring high index to the method. The      *
* helper method header is:                                                       *
*                                                                                *
* public static void reverseDisplay(String value, int high)                      *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_18_12 {
	/** Main method */
	public static void main(String[] args) {
		// Create a scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a string
		System.out.print("Enter a string: ");
		String value = input.next();

		// Print the string in reverse
		reverseDisplay(value);
		System.out.println();
	}

	/** Method prints the characters in a string reversely */
	public static void reverseDisplay(String value) {
		reverseDisplay(value, value.length() - 1 );
	}

	/** Helper method */
	private static void reverseDisplay(String value, int high) {
		if (high >= 0) {
			System.out.print(value.charAt(high));
			reverseDisplay(value, high - 1);
		}
	}
}
