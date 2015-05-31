/*
(Check substring) Write a program that prompts the user to enter two strings and
reports whether the second string is a substring of the first string.
*/
import java.util.Scanner;

public class Exercise_04_22 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter two strings
		System.out.print("Enter string s1: ");
		String string1 = input.nextLine();
		System.out.print("Enter string s2: ");
		String string2 = input.nextLine();

		// Display wheater the second string
		// is a substring of the frist string
		System.out.println(
			string2 + ((string1.contains(string2)) ? " is " : " is not ") + 
			"a substring of " + string1);
	}
}