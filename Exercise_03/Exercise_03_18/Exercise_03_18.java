/*
(Cost of shipping) A shipping company uses the following function to calculate
the cost (in dollars) of shipping based on the weight of the package (in
pounds).
							
							 3.5, if 0 < w < = 1
			     c(w) =  5.5, if 1 < w < = 3
							 8.5, if 3 < w < = 10
							 10.5, if 10 < w < = 20

Write a program that prompts the user to enter the weight of the package and
display the shipping cost. If the weight is greater than 50, display a message “the
package cannot be shipped.”
*/
import java.util.Scanner;

public class Exercise_03_18 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter the weight of the package
		System.out.print("Enter the weight of the package: ");
		double weight = input.nextDouble();

		// Calculate cost of shipping
		if (weight > 50)
			System.out.println("The package cannot be shipped.");
		else
		{
			double costPerPound; 
			if (weight > 0 && weight <= 1)
				costPerPound = 3.5;
			else if (weight <= 3)
				costPerPound = 5.5;
			else if (weight <= 10)
				costPerPound = 8.5;
			else //if (weight <= 20)
				costPerPound = 10.5;
			System.out.println("Shipping cost of package is $" +
				costPerPound * weight);
		}
	}
}