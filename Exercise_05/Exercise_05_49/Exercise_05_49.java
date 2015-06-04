/*
(Count vowels and consonants) Assume letters A, E, I, O, and U as the vowels.
Write a program that prompts the user to enter a string and displays the number
of vowels and consonants in the string.
*/
import java.util.Scanner;

public class Exercise_05_49 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a string
		System.out.print("Enter a string: ");
		String string = input.nextLine();

		int vowels, 					// Count the number of vowels
			 consonants;				// Count the number of consonants
		vowels = consonants = 0;	// Initialize accumulators to 0

		// Count the number of vowels and consonants
		for (int i = 0; i < string.length(); i++) {
			if (Character.isLetter(string.charAt(i))) {
				if (Character.toUpperCase(string.charAt(i)) == 'A' ||
					 Character.toUpperCase(string.charAt(i)) == 'E' ||
					 Character.toUpperCase(string.charAt(i)) == 'I' ||
					 Character.toUpperCase(string.charAt(i)) == 'O' ||
					 Character.toUpperCase(string.charAt(i)) == 'U') {
					vowels++;
				}
				else
					consonants++;
			}

		// Display results
		System.out.println("The number of vowels is " + vowels);
		System.out.println("The number of consonants is " + consonants);
	}
}