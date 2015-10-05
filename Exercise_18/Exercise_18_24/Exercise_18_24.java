/*********************************************************************************
* (Hex to decimal) Write a recursive method that parses a hex number as a string *
* into a decimal integer. The method header is:                                  *
*                                                                                *
* public static int hex2Dec(String hexString)                                    *
*                                                                                *
* Write a test program that prompts the user to enter a hex string and displays  *
* its decimal equivalent.                                                        *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_18_24 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a hex string
		System.out.print("Enter a hex string: ");
		String hexString = input.next();

		// Display the decimal equivalent of the hex string
		System.out.println("The decimal equivalent of "
			+ hexString + " is " + hex2Dec(hexString));
	}

	/** Method parses a hex number as 
	  * string into a decimal integer */
	public static int hex2Dec(String hexString) {
		int result = 0;
		int index = 0;
		int n = hexString.length() - 1;
		return hex2Dec(hexString, index, n, result);
	}

	/** Recursive helper method */
	public static int hex2Dec(String hexString, int index, int n, int result) {
		int dec = 0; // Decimal conversion
		if (hexString.charAt(index) >= 'A' && 
			 hexString.charAt(index) <= 'F') {
			dec = (hexString.charAt(index) - 'A') + 10;
		}
		else {
			dec = Integer.parseInt(String.valueOf(hexString.charAt(index)));
		}
		dec *= (int)Math.pow(16, n);

		if (n == 0) // Base Case
			return result + dec;
		else 	// Recursive call
			return hex2Dec(hexString, index + 1, n - 1, dec + result);
	}
}