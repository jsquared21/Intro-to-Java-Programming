/*
(Occurrences of a specified character) Write a method that finds the number of
occurrences of a specified character in a string using the following header:

public static int count(String str, char a)

For example, count("Welcome", 'e') returns 2. Write a test program that
prompts the user to enter a string followed by a character and displays the number
of occurrences of the character in the string.
*/
import java.util.Scanner;

public class Exercise_06_23 {
	/** Main Method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Create a Scanner

		// Prompt the user to enter a string followed by a character
		System.out.print(
			"Enter a string followed by a character e.g. Welcome, e : " );
		String string = input.nextLine();

		// Extract character and substring
		int k = string.indexOf(", ");
		String str = string.substring(0, k);
		char ch = string.charAt(k + 2);

		// Display the nubmer of occurrences of the character in the string
		System.out.println(
			"The number of occurrences of \"" + ch + "\" in \'" + str + "\" is: " +
			count(str, ch));

	}

	/** Method count */
	public static int count(String str, char a) {
		int count = 0; // Initialize count to 0

		// Count the number of occurrences of the character a in the string str
		for (int i = 0; i < str.length(); i++) {
			if (a == str.charAt(i))
				count++;
		}
		return count;
	}
}
