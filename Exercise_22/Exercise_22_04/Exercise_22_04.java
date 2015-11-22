/*********************************************************************************
* (Pattern matching) Write a program that prompts the user to enter two strings  *
* and tests whether the second string is a substring of the first string. (Don’t *
* use the indexOf method in the String class.) Analyze the time complexity of    *
* your algorithm.                                                                *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_22_04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter two strings
		System.out.print("Enter a string s1: ");
		String s1 = input.nextLine();
		System.out.print("Enter a string s2: ");
		String s2 = input.nextLine();

		int index = -1; // Index of sub string
		int count = 0; // Count matching characters
		boolean matched = false; 

		// tests whether the second string 
		// is a substring of the first string
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(count)){
				count = 0;
			}

			if (s1.charAt(i) == s2.charAt(count)) {
				if (count == 0) 
					index = i;	 
				count++;
			}

			if (count == s2.length()) {
				matched = true;
				break;
			}
		}

		// Display result
		if (matched)
			System.out.println("matched at index " + index);
		else
			System.out.println("\"" + s2 + 
				"\" is not a substring of \"" + s1 + "\""+ ".");
	}
}