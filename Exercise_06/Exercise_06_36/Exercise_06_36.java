/*
(Geometry: area of a regular polygon) A regular polygon is an n-sided polygon
in which all sides are of the same length and all angles have the same degree (i.e.,
the polygon is both equilateral and equiangular). The formula for computing the
area of a regular polygon is

				Area = (n * s^2) / (4 * tan(PI / n))

Write a method that returns the area of a regular polygon using the following header:

	public static double area(int n, double side)

Write a main method that prompts the user to enter the number of sides and the
side of a regular polygon and displays its area.
*/
import java.util.Scanner;

public class Exercise_06_36 {
	/** Main Method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Create a Scanner

		// Prompt the user to enter the number of sides 
		// and the side of a regular polygon
		System.out.print("Enter the number of sides: ");
		int n = input.nextInt();
		System.out.print("Enter the side: ");
		double side = input.nextDouble();

		// Display the area of the regular polygon
		System.out.println("The area of the polygon is " + area(n, side));

	}

	/** Method area computes and returns the area of a regular polygon */
	public static double area(int n, double side) {
		return (n * Math.pow(side, 2) / (4 * Math.tan(Math.PI / n)));
	}
}
