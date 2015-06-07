/*
(Check password) Some websites impose certain rules for passwords. Write a
method that checks whether a string is a valid password. Suppose the password
rules are as follows:
■ A password must have at least eight characters.
■ A password consists of only letters and digits.
■ A password must contain at least two digits.
Write a program that prompts the user to enter a password and displays Valid
Password if the rules are followed or Invalid Password otherwise.
*/
import java.util.Scanner;

public class Exercise_06_18 {
	/** Main Method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Create a Scanner

		// Prompt the user to enter a password
		System.out.print("Enter a password: ");
		String password = input.nextLine();

		// Display Valid Password if rules are followed, Invalid Password otherwise
		System.out.println(
			(isValidPassword(password) ? "Valid " : "Invalid ") + "Password");
	}

	/** Method isPasswordVaild tests whether a string is a valid password */
	public static boolean isValidPassword(String password) {
		final int LENGTH_OF_VALID_PASSWORD = 8;	// Valid length of password
	   final int MINIMUM_NUMBER_OF_DIGITS = 2;	// Minimum digits it must contain

		boolean validPassword = 
			isLengthValid(password, LENGTH_OF_VALID_PASSWORD) && 
			isOnlyLettersAndDigits(password) &&
			hasNDigits(password, MINIMUM_NUMBER_OF_DIGITS);

		return validPassword;
	}

	/** Method isLengthValid tests whether a string is a valid length */
	public static boolean isLengthValid(String password, int validLength) {
		return password.length() >= validLength;
	}

	/** Method isOnlyLettersAndDigits tests if a string contains only letters
	 and digits */
	public static boolean isOnlyLettersAndDigits(String password) {
		for (int i = 0; i < password.length(); i++) {
			if (!Character.isLetterOrDigit(password.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/** Method hasNDigits tests if a string contains at least n digits */
	public static boolean hasNDigits(String password, int n) {
		int numberOfDigits = 0;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				numberOfDigits++;
			}
			if (numberOfDigits >= n) {
				return true;
			}
		}
		return false;
	}
}