/*********************************************************************************
* (Decimal to hex) Write a recursive method that converts a decimal number into  *
* a hex number as a string. The method header is:                                *
*                                                                                *
* public static String dec2Hex(int value)                                        *
*                                                                                *
* Write a test program that prompts the user to enter a decimal number and       *
* displays its hex equivalent.                                                   *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_18_22 {
	/** Main method */
	public static void main(String[] args) {
		// Create a scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a decimal number
		System.out.print("Enter a decimal number: ");
		int value = input.nextInt();

		// Display the value's hex equivalent
		System.out.println("The hex equivalent of "
			+ value + " is " + dec2Hex(value)); 
	}

	/** Method converts a decimal number 
	  * into a hex number as string */
	public static String dec2Hex(int value) {
		String result = "";
		return dec2Hex(value, result);
	}

	/** Recursive helper method */
	public static String dec2Hex(int value, String result) {
		int r = value % 16; // Remainder
		String remainder = r >= 10 ? 
			String.valueOf((char)('A' + r % 10)) : String.valueOf(r);
			
		if (value / 16 == 0) // Base case
			return remainder + result;
		else
			return dec2Hex(value / 16, remainder + result); // Recursive call
	}
}