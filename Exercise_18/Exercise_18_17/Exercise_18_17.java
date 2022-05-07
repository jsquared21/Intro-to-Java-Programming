/*********************************************************************************
* (Occurrences of a specified character in an array) Write a recursive method    *
* that finds the number of occurrences of a specified character in an array. You *
* need to define the following two methods. The second one is a recursive helper * 
* method.                                                                        *
*                                                                                *
* public static int count(char[] chars, char ch)                                 *
* public static int count(char[] chars, char ch, int high)                       *
*                                                                                *
* Write a test program that prompts the user to enter a list of characters in    *
* one line, and a character, and displays the number of occurrences of the       * 
* character in the list.                                                         *
*                                                                                *
* Sample Run                                                                     *
* Enter a string: Welcome to Java                                                *
* Enter a character: e                                                           *
* e appears 2 times                                                              *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_18_17 {
	// Main method
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a string
		System.out.print("Enter a string: ");
		String str = input.nextLine();
		
		// Convert string into array of characters
		char[] chars = new char[str.length()];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = str.charAt(i);
		}

		// Prompt the user to enter a character
		System.out.print("Enter a character: ");
		char ch = input.next().charAt(0);

		// Display the number of occurrences of the character
		System.out.print(ch + " appears " + count(chars, ch) + " times");
	}

	// Method counts the occurrences of a character in an array
	public static int count(char[] chars, char ch) {
		return count(chars, ch, chars.length - 1);
	}

	// Recursive helper method
	public static int count(char[] chars, char ch, int high) {
		if (high < 0) { // Base case
			return 0;
		} else if (chars[high] == ch) {
			return 1 + count(chars, ch, high - 1); // Recursive call
		} else {
			return count(chars, ch, high - 1); // Recursive call
		}
	}
}
