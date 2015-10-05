/*********************************************************************************
* (Decimal to binary) Write a recursive method that converts a decimal number    *
* into a binary number as a string. The method header is:                        *
*                                                                                *
* public static String dec2Bin(int value)                                        *
*                                                                                *
* Write a test program that prompts the user to enter a decimal number and       *
* displays its binary equivalent.                                                *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_18_21 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a decimal number
		System.out.print("Enter a decimal number: ");
		int value = input.nextInt();

		// Display the value's binary equivalent
		System.out.println("The binary equivalent of " 
			+ value + " is " + dec2Bin(value));
	}

	/** Methods converts a decimal number
	  * into a binary number as a string */
	public static String dec2Bin(int value) {
		String result = "";
		return dec2Bin(value, result);
	}

	/** Recursive helper method */
	public static String dec2Bin(int value, String result) {
		if (value / 2 == 0) // Base case
			return (value % 2) + result;
		else
			return dec2Bin(value / 2, (value % 2) + result); // Recursive call
	}
}