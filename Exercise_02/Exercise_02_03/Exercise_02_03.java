/*
(Convert feet into meters) Write a program that reads a number in feet, converts it
to meters, and displays the result. One foot is 0.305 meter. Here is a sample run:
*/
import java.util.Scanner;

public class Exercise_02_03 {
	public static void main(String[] args) {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);

		// Create constant value
		final double METERS_PER_FOOT = 0.305;

		// Prompt user to enter a number in feet
		System.out.print("Enter a value for feet: ");
		double feet = input.nextDouble();

		// Convert feet into meters
		double meters = feet * METERS_PER_FOOT;

		// Display results
		System.out.println(feet + " feet is " + meters + " meters");
	}
}