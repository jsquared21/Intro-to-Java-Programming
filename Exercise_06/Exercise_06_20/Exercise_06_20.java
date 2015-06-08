/*
(Count the letters in a string) Write a method that counts the number of letters in
a string using the following header:
public static int countLetters(String s)
Write a test program that prompts the user to enter a string and displays the number
of letters in the string.
*/
import java.util.Scanner;

public class Exercise_06_20 {
	/** Main Method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Create a Scanner

		// Prompt the user to enter a string
		System.out.print("Enter a string: ");
		String string = input.nextLine();

		// Display the number of letters in the string
		System.out.println(
			"The number of letters in the string \"" + 
			string + "\": " + countLetters(string));
	}

	/** Method countLetters counts the number of letters in a string */
	public static int countLetters(String s) {
		int numberOfLetters = 0; // Counts the number of letters
		for (int i = 0; i < s.length(); i++) {
			// Test if character is a letter
			if (Character.isLetter(s.charAt(i)))
				numberOfLetters++; // Increment the number of letters
		}
		return numberOfLetters;
	}
}