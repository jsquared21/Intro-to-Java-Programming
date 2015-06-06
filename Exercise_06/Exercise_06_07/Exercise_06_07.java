/*
(Financial application: compute the future investment value) Write a method that
computes future investment value at a given interest rate for a specified number
of years. The future investment is determined using the formula in Programming
Exercise 2.21.

Use the following method header:

public static double futureInvestmentValue(
	double investmentAmount, double monthlyInterestRate, int years)

For example, futureInvestmentValue(10000, 0.05/12, 5) returns
12833.59.

Write a test program that prompts the user to enter the investment amount (e.g.,
1000) and the interest rate (e.g., 9%) and prints a table that displays future value
for the years from 1 to 30,
*/
import java.util.Scanner;

public class Exercise_06_07 {
	/** Main Method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Create a Scanner
		final int NUMBER_OF_YEARS = 30; // Number of years to display

		// Prompt the user to enter the investment amount and interest rate
		System.out.print("\nThe amount invested: ");
		double amount = input.nextDouble();
		System.out.print("Annual interest rate: ");
		double annualInterestRate = input.nextDouble();

		// Get monthly interest rate
		double monthlyInterestRate = annualInterestRate / 1200;

		// Print a table that displays future value for the years from 1 to 30
		System.out.println("Years     Future Value"); // Table header
		for (int years = 1; years <= NUMBER_OF_YEARS; years++) {
			System.out.printf("%-10d", years);
			System.out.printf("%11.2f\n", 
				futureInvestmentValue(amount, monthlyInterestRate, years));
		}
	}

	/** Method futureInvestmentValue computes future investement value */
	public static double futureInvestmentValue(
		double investmentAmount, double monthlyInterestRate, int years) {
		return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
	}
}