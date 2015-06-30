/*********************************************************************************
* (Algebra: 2 * 2 linear equations) Design a class named LinearEquation for a    *
* 2 * 2 system of linear equations:                                              *
*                                                                                *
*  ax + by = e, cx + dy = f; x = (ed - bf) / (ad - bc) y = (af - ec) / (ad - bc) *
*                                                                                *
* The class contains:                                                            *
* ■ Private data fields a, b, c, d, e, and f.                                    *
* ■ A constructor with the arguments for a, b, c, d, e, and f.                   *
* ■ Six getter methods for a, b, c, d, e, and f.                                 *
* ■ A method named isSolvable() that returns true if ad - bc is not 0.           *
* ■ Methods getX() and getY() that return the solution for the equation.         *
*                                                                                *
* Draw the UML diagram for the class and then implement the class. Write a test  *
* program that prompts the user to enter a, b, c, d, e, and f and displays the   *
* result. If ad - bc is 0, report that “The equation has no solution.” See       *
* Programming Exercise 3.3 for sample runs.                                      *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_09_11 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);

		
		// Prompt the user to enter a, b, c, d, e, and f
		System.out.print("Enter a, b, c, d, e, f: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double d = input.nextDouble();
		double e = input.nextDouble();
		double f = input.nextDouble();

		// Create a LinearEquation object
		LinearEquation linearEquation = new LinearEquation(a, b, c, d, e, f);
		
		// Display results
		if (linearEquation.isSolvable()) {
			System.out.println("x is " + linearEquation.getX() +
				" and y is " + linearEquation.getY());
		}
		else
			System.out.println("The equation has no solution.");
	}
}