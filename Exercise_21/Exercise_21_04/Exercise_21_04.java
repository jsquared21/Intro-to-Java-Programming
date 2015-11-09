/*********************************************************************************
* (Count consonants and vowels) Write a program that prompts the user to enter a *
* text file name and displays the number of vowels and consonants in the file.   *
* Use a set to store the vowels A, E, I, O, and U.                               *
*********************************************************************************/
import java.util.*;
import java.io.*;

public class Exercise_21_04 {
	public static void main(String[] args) throws Exception {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a text file name
		System.out.print("Enter a text file name: ");
		String fileName = input.next();

		// Check if file exists
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("The file " + fileName + " does not exist.");
			System.exit(1);
		}

		// Create a set to store vowels
		Set<Character> set = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
		int vowels = 0; // Counts the number of vowels
		int consonants = 0; // Counts the number of consonants

		// Count the number of vowels and consonants in the file
		try ( // Create an input file
			Scanner inputFile = new Scanner(file);
		) {
			while (inputFile.hasNext()) {
				String line = inputFile.nextLine();
				for (int i = 0; i < line.length(); i++) {
					if (set.contains(Character.toUpperCase(line.charAt(i))))
						vowels++;
					else if (Character.isLetter(line.charAt(i)))
						consonants++;
				}
			}
		}

		// Display the number of vowels and consonants in the file
		System.out.println("The file " + fileName + " has " + vowels + 
			" vowels and " + consonants + " consonants.");
	}
}