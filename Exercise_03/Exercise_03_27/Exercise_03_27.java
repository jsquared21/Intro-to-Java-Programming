/*
(Geometry: points in triangle?) Suppose a right triangle is placed in a plane as
shown below. The right-angle point is placed at (0, 0), and the other two points
are placed at (200, 0), and (0, 100). Write a program that prompts the user to enter
a point with x- and y-coordinates and determines whether the point is inside the
triangle. Here are the sample runs:
*/
import java.util.Scanner;

public class Exercise_03_27 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 	// Create a Scanner object

		// Prompt the user to enter a point with x and y coordinates
		System.out.print("Enter a point's x- and y-coordinates: ");
		double x = input.nextDouble();
		double y = input.nextDouble();

		// Determine whether the point is inside the triangle
		// getting the point of ina line that starts at point 

		// Get the intersecting point with the hypotenuse side of the triangle
		// of a line that starts and points (0, 0) and touches the user points
		double intersectx = (-x * (200 * 100)) / (-y * 200 - x * 100);
		double intersecty = (-y * (200 * 100)) / (-y * 200 - x * 100);

		// Display results
		System.out.println("The point " + ((x > intersectx || y > intersecty)
			? "is not " : "is " ) + "in the triangle");
	}
}