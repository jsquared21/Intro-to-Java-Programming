/*
(Convert Celsius to Fahrenheit) Write a program that reads a Celsius degree in
a double value from the console, then converts it to Fahrenheit and displays the
result. The formula for the conversion is as follows:
fahrenheit = (9 / 5) * celsius + 32
*/
import java.util.Scanner;

public class Exercise_02_01 {
	public static void main(String[] args) {
		// Create new Scanner object
		Scanner input = new Scanner(System.in);

		// Prompt user to input a double
		System.out.print("Enter a degree in Celsius: ");
		double celsius = input.nextDouble();

		// Convert Celsius to Fahrenheit
		double fahrenheit = 9.0 / 5 * celsius + 32;

		// Display results
		System.out.println(celsius + " Celsius is " + fahrenheit
			+ " Fahrenheit"); 
	}
}
