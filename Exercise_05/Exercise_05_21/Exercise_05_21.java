/*
(Financial application: compare loans with various interest rates) Write a program
that lets the user enter the loan amount and loan period in number of years
and displays the monthly and total payments for each interest rate starting from
5% to 8%, with an increment of 1/8.
*/
import java.util.Scanner;

public class Exercise_05_21 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter the loan amount and
		// loan period in number of years
		System.out.print("Loan Amount: ");
		double loanAmount = input.nextDouble();
		System.out.print("Number of Years: ");
		int numberOfYears = input.nextInt();


		// Display table header
		System.out.println(
			"Interest Rate    Monthly Payment    Total Payment");
		
		// Display table with interest rates
		for (double i = 5.0; i <= 8; i += 0.125) {
			System.out.printf("%-5.3f", i);
			System.out.print("%           ");
			double monthlyInterestRate = i / 1200;
			double monthlyPayment = loanAmount * monthlyInterestRate / (1
				- 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
			System.out.printf("%-19.2f", monthlyPayment);
			System.out.printf("%-8.2f\n",(monthlyPayment * 12) * numberOfYears);
		}
	}
}