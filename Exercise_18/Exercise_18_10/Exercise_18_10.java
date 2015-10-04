/*********************************************************************************
* (Occurrences of a specified character in a string) Write a recursive method    *
* that finds the number of occurrences of a specified letter in a string using   *
* the following method header:                                                   *
*                                                                                *
* public static int count(String str, char a)                                    *
*                                                                                *
* For example, count("Welcome", 'e') returns 2. Write a test program that        *
* prompts the user to enter a string and a character, and displays the number of *
* occurrences for the character in the string                                    *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_18_10 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a string and a character
		System.out.print("Enter a string and a character: ");
		String[] str = input.nextLine().split("[ ]");

		// Display the number of occurences for the character in the string
		System.out.println("The number of occurences of the character \'" 
			+ str[1] + "\' in the string \"" + str[0] + "\" is " + 
			count(str[0], str[1].charAt(0)));
	}

	/** Method counts the number of occurrences 
	  * of a specified character in a string */
	public static int count(String str, char a) {
		int index = 0;
		int count = 0;
		return count(str, a, index, count);
	}

	/** Helpler count method */
	private static int count(String str, char a, int i, int count) {
		if (i == str.length())
			return count;
		else if (str.charAt(i) == a)
			return count(str, a, ++i, ++count);
		else
			return count(str, a, ++i, count);
	}
}