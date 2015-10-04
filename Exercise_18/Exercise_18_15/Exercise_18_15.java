/**********************************************************************************
* (Occurrences of a specified character in a string) Rewrite Programming Exercise *
* 18.10 using a helper method to pass the substring high index to the method.     *
* The helper method header is:                                                    *
*                                                                                 *
* public static int count(String str, char a, int high)                           *
**********************************************************************************/
import java.util.Scanner;

public class Exercise_18_15 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a string and a character
		System.out.print("Enter a string and a character: ");
		String[] str = input.nextLine().split("[ ]");

		// Display the number of times the character occurs in the string
		System.out.println("The character \'" + str[1] + "\' occurs " +
			count(str[0], str[1].charAt(0)) + " times in \"" + str[0] + "\".");
	}

	/** Method counts the number of occurrences 
	  * of a specified character in a string */
	public static int count(String str, char a) {
		return count(str, a, str.length() - 1);
	}

	/** Helper melthod used to pass the substring high index */
	private static int count(String str, char a, int high) {
		if (high < 0) // Base case
			return 0;
		else if (str.charAt(high) ==  a) {
			return 1 + count(str, a, high - 1); // Recursive call
		}
		else
			return count(str, a, high - 1); // Recursive call
	}
}