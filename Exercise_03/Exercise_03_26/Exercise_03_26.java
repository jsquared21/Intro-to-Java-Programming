/*
(Use the &&, || and ^ operators) Write a program that prompts the user to enter
an integer and determines whether it is divisible by 5 and 6, whether it is divisible
by 5 or 6, and whether it is divisible by 5 or 6, but not both. Here is a sample run
of this program:
*/
import java.util.Scanner;

public class Exercise_03_26 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	// Create Scanner object

		// Prompt user to an integer
		System.out.print("Enter an integer: ");
		int number = input.nextInt();

		// Determine whether it is divisible by 5 and 6
		// Display results
		System.out.println("Is 10 divisible by 5 and 6? " +
			((number % 5 == 0) && (number % 6 == 0)));
		System.out.println("Is 10 divisible by 5 or 6? " +
			((number % 5 == 0) || (number % 6 == 0)));
		System.out.println("Is 10 divisible by 5 of 6, but not both? " +
			((number % 5 == 0) ^ (number % 6 == 0)));
	}
}