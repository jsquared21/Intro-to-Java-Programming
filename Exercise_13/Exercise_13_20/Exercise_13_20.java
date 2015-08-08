/*********************************************************************************
* (Algebra: solve quadratic equations) Rewrite Programming Exercise 3.1 to       *
* obtain imaginary roots if the determinant is less than 0 using the Complex     *
* class in Programming Exercise 13.17.                                           *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_13_20 {
	public static void main(String[] args) {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter values for a, b and c.
		System.out.print("Enter a, b, c: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();

		// Compute the discriminant of the quadriatic equation.
		double discriminant = Math.pow(b, 2) - 4 * a * c;

		// Compute the real roots of the quadriatic equation if any.
		if (discriminant > 0)
		{
			double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);  
			double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);  
			System.out.println("The roots are " + root1 + " and " + root2);
		}
		else if (discriminant == 0)
		{
			System.out.println("The root is " + 
				(-b + Math.sqrt(discriminant)) / (2 * a));
		}
		else { // Display imaginary roots by using two Complex objects.
			System.out.print("The roots are "); 
			Complex root1 = new Complex(-b / (2 * a), Math.sqrt(2 * a));
			Complex root2 = new Complex(-b / (2 * a), -Math.sqrt(2 * a));
			System.out.println(root1 + " and " + root2);
		}
	}
}