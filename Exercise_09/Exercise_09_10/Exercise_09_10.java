/*********************************************************************************
* (Algebra: quadratic equations) Design a class named QuadraticEquation for      *
* a quadratic equation ax2 + bx + x = 0. The class contains:                     *
* ■ Private data fields a, b, and c that represent three coefficients.           *
* ■ A constructor for the arguments for a, b, and c.                             *
* ■ Three getter methods for a, b, and c.                                        *
* ■ A method named getDiscriminant() that returns the discriminant, which is     *
*   b2 - 4ac.                                                                    *
* ■ The methods named getRoot1() and getRoot2() for returning two roots of the   *
*   equation                                                                     *
*           r1 = (-b + √(b^2 - 4ac)) / 2a and r2 = (-b - √(b2 - 4ac)) / 2a       *
*                                                                                *
* These methods are useful only if the discriminant is nonnegative. Let these    *
* methods return 0 if the discriminant is negative.                              *
* Draw the UML diagram for the class and then implement the class. Write a test  *
* program that prompts the user to enter values for a, b, and c and displays the *
* result based on the discriminant. If the discriminant is positive, display the *
* two roots. If the discriminant is 0, display the one root. Otherwise, display  *
* “The equation has no roots.” See Programming Exercise 3.1 for sample runs.     *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_09_10 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter values for a, b, and c
		System.out.print("Enter a, b, c: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();

		// Create a QuadraticEquation object
		QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);

		// Compute the real roots of the quadriatic equation if any.
		System.out.print("The equation has ");
		if (quadraticEquation.getDiscriminant() < 0)
			System.out.println("no real roots");
		else if (quadraticEquation.getDiscriminant() > 0) {
			System.out.println("two roots " + quadraticEquation.getRoot1() + 
				" and " + quadraticEquation.getRoot2());
		}
		else {
			System.out.println("one root " + (quadraticEquation.getRoot1() > 0 ? 
				quadraticEquation.getRoot1() : quadraticEquation.getRoot2()));
		}
	}
}