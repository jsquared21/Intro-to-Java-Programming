/*
(Financial application: monetary units) Rewrite Listing 2.10, ComputeChange
.java, to fix the possible loss of accuracy when converting a double value to an
int value. Enter the input as an integer whose last two digits represent the cents.
For example, the input 1156 represents 11 dollars and 56 cents.
*/
import java.util.Scanner;

public class Exercise_02_22 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Receive the amount
		System.out.print(
			"Enter an amount as integer, for example 1156 for 11.56: ");
		int amount = input.nextInt();

		int remainingAmount = amount;

		// Find the number of one dollars
		int numberOfOneDollars = remainingAmount / 100;
		remainingAmount %= 100;

		// Find the number of quarters in the remaining amount
		int numberOfQuarters = remainingAmount / 25;
		remainingAmount %= 25;

		// Find the number of dimes in the remaining amount
		int numberOfDimes = remainingAmount / 10;
		remainingAmount %= 10;

		// Find the number of nickels in the remaining amount
		int numberOfNickels = remainingAmount / 5;
		remainingAmount %= 5;

		// Find the number of pennies in the remaining amoung
		int numberOfPennies = remainingAmount;

		// Display results
		System.out.println("Your amount " + amount / 100.0 + " consists of");
		System.out.println(" " + numberOfOneDollars + " dollars");
		System.out.println(" " + numberOfQuarters + " quarters");
		System.out.println(" " + numberOfDimes + " dimes");
		System.out.println(" " + numberOfNickels + " nickels");
		System.out.println(" " + numberOfPennies + " pennies");
	}
}