/*********************************************************************************
* (NumberFormatException) Listing 6.8 implements the hex2Dec(String hexString)   *
* method, which converts a hex string into a decimal number. Implement the       *
* hex2Dec  method to throw a NumberFormatException if the string is not a hex    *
* string.                                                                        *
*********************************************************************************/
import java.util.Scanner;

public class Hex2Dec {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a string
		System.out.print("Enter a hex number: ");
		String hex = input.nextLine();

		// Handle NumberFormatException
		try {
			System.out.println("The decimal value for hex number "
				+ hex + " is " + hexToDecimal(hex.toUpperCase()));
		}
		catch (NumberFormatException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/** Converts a hex string into a decimal number and throws a 
	  * NumberFormatException if the string is not a hex string */
	public static int hexToDecimal(String hex) throws NumberFormatException {
		int decimalValue = 0;
		for (int i = 0; i < hex.length(); i++) {
			if (!(hex.charAt(i) >= '0' && hex.charAt(i) <= '9') ||
				 !(hex.charAt(i) >= 'A' && hex.charAt(i) <= 'F'))
				throw new NumberFormatException("String is not a hex string");
			char hexChar = hex.charAt(i);
			decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
		}

		return decimalValue;
	}

	public static int hexCharToDecimal(char ch) {
		if (ch >= 'A' && ch <= 'F')
			return 10 + ch - 'A';
		else // ch is '0', '1', ..., or '9'
			return ch - '0';
	}
}