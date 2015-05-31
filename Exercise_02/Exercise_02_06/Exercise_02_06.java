/*
(Sum the digits in an integer) Write a program that reads an integer between 0 and
1000 and adds all the digits in the integer. For example, if an integer is 932, the
sum of all its digits is 14.
Hint: Use the % operator to extract digits, and use the / operator to remove the
extracted digit. For instance, 932 % 10 = 2 and 932 / 10 = 93.
*/
import java.util.Scanner;

public class Exercise_02_06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		// Create new Scanner object

		// Prompt the user to enter a number between 0 and 1000.
		System.out.print("Enter a number between 0 and 1000: ");
		int number = input.nextInt();

		// Compute the sum of the digits in the integer.
		int lessThan10 = number % 10;		// Extract the digit less than 10
		number /= 10;							// Remove the extracted digit
		int tens = number % 10;				// Extract the digit between 10 to 99
		number /= 10;							// Remove the extracted digit
		int hundreds = number % 10;		// Extract the digit between 100 to 999
		number /= 10;							// Remove the extracted digit
		int sum = hundreds + tens + lessThan10;	

		// Display results
		System.out.println("The sum of the digits is " + sum);
	}
}