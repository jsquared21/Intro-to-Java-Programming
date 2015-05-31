/*
(Financial: compare costs) Suppose you shop for rice in two different packages.
You would like to write a program to compare the cost. The program prompts the
user to enter the weight and price of the each package and displays the one with
the better price.
*/
import java.util.Scanner;

public class Exercise_03_33 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	// Create Scanner object

		// Prompt the user to enter the weight and price of each package
		System.out.print("Enter weight and price for package 1: ");
		double weight1 = input.nextDouble();
		double price1 = input.nextDouble();
		System.out.print("Enter weight and price for package 2: ");
		double weight2 = input.nextDouble();
		double price2 = input.nextDouble();

		if (price1 / weight1 < price2 / weight2)
			System.out.println("Package 1 has a better price.");
		else if (price1 / weight1 > price2 / weight2)
			System.out.println("Package 2 has a better price.");
		else
			System.out.println("Two packages have the same price.");
	}
}