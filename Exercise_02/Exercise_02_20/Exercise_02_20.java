/*
(Financial application: calculate interest) If you know the balance and the annual
percentage interest rate, you can compute the interest on the next monthly payment
using the following formula:
interest = balance * (annualInterestRate/1200)
Write a program that reads the balance and the annual percentage interest rate and
displays the interest for the next month.
*/
import java.util.Scanner;

public class Exercise_02_20 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a balance and
		// the annual percentage interest rate
		System.out.print("Enter balance and interest rate (e.g., 3 for 3%): ");
		double balance = input.nextDouble();
		double annualInterestRate = input.nextDouble();

		// Calculate the interest
		double interest = balance * (annualInterestRate / 1200);

		// Display result
		System.out.println("The interest is " + interest);
	}
}