/*
(Palindrome number) Write a program that prompts the user to enter a three-digit
integer and determines whether it is a palindrome number. A number is palindrome
if it reads the same from right to left and from left to right.
*/
import java.util.Scanner;

public class Exercise_03_12 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a three-digit integer
		System.out.print("Enter a three-digit integer: ");
		int number = input.nextInt();

		// Test for palindrome
		int digit1 = (int)(number / 100);
		int remaining = number % 100;
		int digit3 = (int)(remaining % 10);

		// Display result
		System.out.println(
			number + ((digit1 == digit3) ? " is a " : " is not a ") + "palindrome");
	}
}