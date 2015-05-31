/*
(Financial application: monetary units) Rewrite Listing 2.10, ComputeChange.
java, to fix the possible loss of accuracy when converting a float value to an int
value. Read the input as a string such as "11.56". Your program should extract
the dollar amount before the decimal point and the cents after the decimal amount
using the indexOf and substring methods.
*/
import java.util.Scanner;

public class Exercise_04_26 {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Receive the amount
		System.out.print("Enter an amount, for example 11.56: ");
		String amount = input.nextLine();

		// Extract number of dollars
		String numberOfOneDollars = amount.substring(0, amount.indexOf('.'));

		// Extract cents
		int cents = Integer.parseInt(amount.substring(amount.indexOf('.') + 1));

		// Find the number of quarters
		int numberOfQuarters = cents / 25;
		cents %= 25;

		// Find the number of dimes
		int numberOfDimes = cents / 10;
		cents %= 10;

		// Find the number of nickels
		int numberOfNickels = cents / 5;
		cents %= 5;

		// Display results
		System.out.println("Your amount " + amount + " consists of\n " 
			+ numberOfOneDollars + " dollars\n " 
			+ numberOfQuarters + " quarters\n "
			+ numberOfDimes + " dimes\n "
			+ numberOfNickels + " nickels\n "
			+ cents + " pennies\n "
			);
	}
}