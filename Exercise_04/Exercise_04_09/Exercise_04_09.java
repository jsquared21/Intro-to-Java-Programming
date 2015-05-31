/*
(Find the Unicode of a character) Write a program that receives a character and
displays its Unicode.
*/
import java.util.Scanner;

public class Exercise_04_09 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a character
		System.out.print("Enter a character: ");
		String s = input.nextLine();
		char ch = s.charAt(0);

		// Display Unicode of character
		System.out.println((int)ch);
	}
}