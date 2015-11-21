/*********************************************************************************
* (Pattern matching) Write a program that prompts the user to enter two strings  *
* and tests whether the second string is a substring of the first string.        *
* Suppose the neighboring characters in the string are distinct. (Don’t use the  *
* indexOf method in the String class.) Analyze the time complexity of your       *
* algorithm. Your algorithm needs to be at least O(n) time.                      *
*********************************************************************************/
import java.util.*;

public class Exercise_22_03 {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter two strings
		System.out.print("Enter a string s1: ");
		String s1 = input.nextLine();
		System.out.print("Enter a string s2: ");
		String s2 = input.nextLine();

		int index = -1; // Stores index of s2 as a substring of s1
		int count = 0;  // Count matches

		// tests whether the second string is a substring of the first string
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(0) && count == 0) {
				index = i;
				count++;
			}
			else if (s1.charAt(i) == s2.charAt(count)) {
				count++;
			}
			else {
				count = 0;
				index = -1;
			}

			if (count == s2.length())
				break;
		}

		// Display results
		if (index > 1)
			System.out.println("matched at index " + index);
		else
			System.out.println("string2 is not a substring of string1");
	}

/*********************************************************************************
* 	Analyze the time complexity of the program:                                   *
* 	1 single loop = 1;                                                            *
*  4 simple statements = 4                                                       *
*  T(n) = (c + c + c + c) * n                                                    *
*  T(n) = 4c * n;                                                                *
* 	T(n) = O(n) Linear time;                                                      *
*********************************************************************************/
}