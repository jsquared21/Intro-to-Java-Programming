/*
(Financial application: loan amortization schedule) The monthly payment for a
given loan pays the principal and the interest. The monthly interest is computed
by multiplying the monthly interest rate and the balance (the remaining principal).
The principal paid for the month is therefore the monthly payment minus
the monthly interest. Write a program that lets the user enter the loan amount,
number of years, and interest rate and displays the amortization schedule for the
loan.
*/
import java.util.Scanner;

public class Exercise_05_22 {
	public static void main(String[] args) {
		// Create Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter the loan amount,
		// the number of years and the annual interest rate
		System.out.print("Loan Amount: ");
		double loanAmount = input.nextDouble();
		System.out.print("Number of Years: ");
		int years = input.nextInt();
		System.out.print("Annual Interest Rate: ");
		double annualRate = input.nextDouble();

		// Calculate monthly interest rate
		double monthlyRate = annualRate / 1200;

		// Calculat montly payment
		double monthlyPayment = loanAmount * monthlyRate / (1 - 1 / 
										Math.pow(1 + monthlyRate, years * 12));

		// Display montly payment
		System.out.printf("Monthly Payment: %.2f\n", monthlyPayment);

		// Display total payment
		System.out.printf("Total Payment: %.2f\n", (monthlyPayment * 12) * years);

		// Create amortization schedule
		double balance = loanAmount,
				 principal, interest;
		System.out.println("Payment#     Interest     Principal     Balance");
		for (int i = 1; i <= years * 12; i++) {
			interest = monthlyRate * balance;
			principal = monthlyPayment - interest;
			balance = balance - principal;
			System.out.printf("%-13d%-13.2f%-13.2f%.2f\n", i, interest,
				principal, balance);
		}
	}
}