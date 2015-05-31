/*
(Find the character of an ASCII code) Write a program that receives an ASCII code
(an integer between 0 and 127) and displays its character.
*/
import java.util.Scanner;

public class Exercise_04_08 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter an ASCII code
		// (an integer between 0 and 127)
		System.out.print("Enter an ASCII code: ");
		int i = input.nextInt();

		// Display ASCII code as character
		System.out.println((char)i);
	}
}