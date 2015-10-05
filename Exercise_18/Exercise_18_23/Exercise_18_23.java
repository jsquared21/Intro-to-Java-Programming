/*********************************************************************************
* (Binary to decimal) Write a recursive method that parses a binary number as a  *
* string into a decimal integer. The method header is:                           *
*                                                                                *
* public static int bin2Dec(String binaryString)                                 *
*                                                                                *
* Write a test program that prompts the user to enter a binary string and        *
* displays its decimal equivalent.                                               *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_18_23 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a binary string
		System.out.print("Enter a binary string: ");
		String binaryString = input.next();

		// Display the decimal equivalent
		System.out.println("The decimal equivalent of " 
			+ binaryString + " is " + bin2Dec(binaryString));
	}

	/** Method parses a binary number as 
	  * a string into a decimal integer */
	public static int bin2Dec(String binaryString) {
		int index = 0;
		int n = binaryString.length() - 1;
		int result = 0;
		return bin2Dec(binaryString, index, n, result);
	}

	/** Recursive helper method */
	public static int bin2Dec(String binaryString, int index, int n, int result) {
		result += (Integer.parseInt(binaryString.charAt(index) + "") * 
				(int)Math.pow(2, n));
		if (n == 0) // Base case
			return result;
		else
			return bin2Dec(binaryString, index + 1, n - 1, result); // Recursive call
	}
}