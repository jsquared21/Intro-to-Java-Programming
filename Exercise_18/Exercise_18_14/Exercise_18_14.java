/*********************************************************************************
* (Find the number of uppercase letters in a string) Write a recursive method to *
* return the number of uppercase letters in a string. Write a test program that  *
* prompts the user to enter a string and displays the number of uppercase        *
* letters in the string.                                                         *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_18_14 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
	
		// Prompt the user to enter a string
		System.out.print("Enter a string: ");
		String str = input.nextLine();

		// Display the number of uppercase letters in the string
		System.out.println("There are " + countUppercase(str) 
			+ " uppercase letters in \"" + str + "\".");
	}

	/** Method counts the uppercase letters in a string */
	public static int countUppercase(String str) {
		int count = 0;
		int index = str.length() - 1;
		return countUppercase(str, index, count);
	}

	/** Helper method */
	private static int countUppercase(String str, int index, int count) {
		if (index < 0) // Base case
			return count;
		else if (Character.isUpperCase(str.charAt(index))) 
			return countUppercase(str, index - 1, count + 1); // Recursive call
		else
			return countUppercase(str, index - 1, count); // Recursive call
	}
}