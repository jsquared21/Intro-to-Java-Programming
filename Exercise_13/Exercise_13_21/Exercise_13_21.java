/*********************************************************************************
* (Algebra: vertex form equations) The equation of a parabola can be expressed   *
* in either standard form (y = ax^2 + bx + c) or vertex form (y = a(x - h)^2 + k)*
* Write a program that prompts the user to enter a, b, and c as integers in      *
* standard form and displays h and k in the vertex form.                         *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_13_21 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner Object
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a, b and c and 
		// create three Rational objects form input
		System.out.print("Enter a, b, c: ");
		Rational a = new Rational(input.nextLong(), 1);
		Rational b = new Rational(input.nextLong(), 1);
		Rational c = new Rational(input.nextLong(), 1);

		// Compute h and k
		// h = -b / 2a
		Rational h = new Rational(-b.getNumerator(), 2 * a.getNumerator());

		// k = f(h) = a * h^2 + b * h + c
		Rational k = (a.multiply(h.multiply(h)).add(b.multiply(h))).add(c);

		// Display results
		System.out.println("h is " + h + " k is " + k);
	}
}