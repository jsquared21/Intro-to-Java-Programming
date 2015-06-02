/*
(Financial application: compound value) Suppose you save $100 each month
into a savings account with the annual interest rate 5%. So, the monthly interest
rate is 0.05 / 12 = 0.00417. After the first month, the value in the account becomes

					100 * (1 + 0.00417) = 100.417

After the second month, the value in the account becomes

					(100 + 100.417) * (1 + 0.00417) = 201.252

After the third month, the value in the account becomes

					(100 + 201.252) * (1 + 0.00417) = 302.507

and so on.
Write a program that prompts the user to enter an amount (e.g., 100), the annual
interest rate (e.g., 5), and the number of months (e.g., 6) and displays the amount
in the savings account after the given month.
*/
import java.util.Scanner;

public class Exercise_05_30 {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter an amount, the 
		// annual interest rate and the number of months
		System.out.print("Enter an amount (e.g., 100): ");
		double amount = input.nextDouble();
		System.out.print("Enter the annual interest rate (e.g., 5): ");
		double annualInterestRate = input.nextDouble();
		System.out.print("Enter the number of months (e.g., 6): ");
		int months = input.nextInt();

		// Compute monthly interest rate
		double monthlyInterestRate = annualInterestRate / 1200;

		// Compute amount in the savings account after the given month
		double compoundValue = 0; // Accumulates compount value
		for (int m = 1; m <= months; m++) {
			compoundValue = (amount + compoundValue) * (1 + monthlyInterestRate);
		}

		// Display result
		System.out.printf(
			"Amount in savings account after " + 
			months + " months: $%.2f\n", compoundValue);
	}
}