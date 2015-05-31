/*
(Convert pounds into kilograms) Write a program that converts pounds into kilograms.
The program prompts the user to enter a number in pounds, converts it
to kilograms, and displays the result. One pound is 0.454 kilograms.
*/
import java.util.Scanner;

public class Exercise_02_04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 	// Create new Scanner object
		final double KILOGRAMS_PER_POUND = 0.454;	// Create constant value

		// Prompt user to enter the number of pounds
		System.out.print("Enter a number in pounds: ");
		double pounds = input.nextDouble();

		// Convert pounds into kilograms
		double kilograms = pounds * KILOGRAMS_PER_POUND;

		// Display the results
		System.out.println(pounds + " pounds is " + kilograms + " kilograms");
	}
}