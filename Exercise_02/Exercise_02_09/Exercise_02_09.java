/*
(Physics: acceleration) Average acceleration is defined as the change of velocity
divided by the time taken to make the change, as shown in the following formula:
                                  v1 - v0
                             a = ---------
                                     t
Write a program that prompts the user to enter the starting velocity v0 in meters/
second, the ending velocity v1 in meters/second, and the time span t in seconds,
and displays the average acceleration.
*/
import java.util.Scanner;

public class Exercise_02_09 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	// Create a Scanner object

		// Prompt the user to enter the starting velocity v0 in meters/second.
		// The ending velocity v1 in meters/second, and the time span t in seconds.
		System.out.print("Enter v0, v1 and t: ");
		double v0 = input.nextDouble();
		double v1 = input.nextDouble();
		double t = input.nextDouble();

		// Calculate the average acceleration
		double a = (v1 - v0) / t;

		// Display result
		System.out.println("The average acceleration is " + a);
	}
}