/*
(Financial application: compound value) Suppose you save $100 each month
into a savings account with the annual interest rate 5%. Thus, the monthly interest
rate is 0.05/12 = 0.00417. After the first month, the value in the account
becomes
100 * (1 + 0.00417) = 100.417
After the second month, the value in the account becomes
(100 + 100.417) * (1 + 0.00417) = 201.252
After the third month, the value in the account becomes
(100 + 201.252) * (1 + 0.00417) = 302.507
and so on.
Write a program that prompts the user to enter a monthly saving amount and
displays the account value after the sixth month. (In Exercise 5.30, you will use a
loop to simplify the code and display the account value for any month.)
*/
import java.util.Scanner;

public class Exercise_02_13 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	// Create a new Scanner object.
		final double MONTHLY_INTEREST_RATE = 0.00417;	// Initialize constant value

		// Prompt the user to enter a montly saving amount
		System.out.print("Enter the monthly saving amount: ");
		double savingAmount = input.nextDouble();

		// Compute first month account value
		double total = 100 * (1 + MONTHLY_INTEREST_RATE);
		// Compute second month account value
		total = (100 + total) * (1 + MONTHLY_INTEREST_RATE);
		// Compute third month account value
		total = (100 + total) * (1 + MONTHLY_INTEREST_RATE);
		// Compute forth month account value
		total = (100 + total) * (1 + MONTHLY_INTEREST_RATE);
		// Compute fifth month account value
		total = (100 + total) * (1 + MONTHLY_INTEREST_RATE);
		// Compute sixth month account value
		total = (100 + total) * (1 + MONTHLY_INTEREST_RATE);

		// Display result
		System.out.println("After the sixth month, the account value is " + total);
	}
}