/*
(Sort three numbers) Write a method with the following header to display three
numbers in increasing order:
public static void displaySortedNumbers(
double num1, double num2, double num3)
Write a test program that prompts the user to enter three numbers and invokes the
method to display them in increasing order.
*/
import java.util.Scanner;

public class Exercise_06_05 {
	/** Main Method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Create Scanner

		// Prompt the user to enter three numbers
		System.out.print("Enter three numbers: ");
		double number1 = input.nextDouble();
		double number2 = input.nextDouble();
		double number3 = input.nextDouble();

		// Display numbers in increasing order
		displaySortedNumbers(number1, number2, number3);
	}

	/** displaySortedNumbers Method displays three numbers in increasing order */
	public static void displaySortedNumbers(
		double num1, double num2, double num3) {
		double temp; // Hold number to swap
		
		if (num2 < num1 && num2 < num3){
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		else if (num3 < num1 && num3 < num2) {
			temp = num1; 
			num1 = num3;
			num3 = temp;
		}
		if (num3 < num2) {
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		
		// Display result
		System.out.println(num1 + " " + num2 + " " + num3);
	}
}