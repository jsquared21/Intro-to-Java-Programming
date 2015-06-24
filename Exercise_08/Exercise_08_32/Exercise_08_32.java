/*********************************************************************************
* (Geometry: area of a triangle) Write a method that returns the area of a       *
* triangle using the following header:                                           *
*                                                                                *
* public static double getTriangleArea(double[][] points)                        *
*                                                                                *
* The points are stored in a 3-by-2 two-dimensional array points with points[0]  *
* [0] and points[0][1] for (x1, y1). The triangle area can be computed using the *
* formula in Programming Exercise 2.19. The method returns 0 if the three points *
* are on the same line. Write a program that prompts the user to enter three     *
* points of a triangle and displays the triangle's area.                         *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_08_32 {
	/** Main method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Create a 3-by-2 two-dimensional array
		double[][] points = new double[3][2];

		// Prompt the user to enter three points of a triangle
		System.out.println("Enter three points of a triangle:");
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points[i].length; j++) {
				points[i][j] = input.nextDouble();
			}
		}

		// Get the area of the triangle
		double result = getTriangleArea(points);
		if (result == 0)
			System.out.println("The three points are on the same line");
		else
			System.out.printf("The area of the triangle is %.2f\n", result);
	}

	/** getTriangleArea returns the area of a triangle */
	public static double getTriangleArea(double[][] points) {
		double[] side = new double[3]; // Sides of the triangle

		// Test if points are on the same line
		if (linePosition(points) == 0)
			return 0;

		// Compute sides
		side[0] = Math.sqrt(Math.pow(points[1][0] - points[0][0], 2) + 
				 Math.pow(points[1][1] - points[0][1], 2));

		side[1] = Math.sqrt(Math.pow(points[2][0] - points[1][0], 2) + 
				 Math.pow(points[2][1] - points[1][1], 2));

		side[2] = Math.sqrt(Math.pow(points[0][0] - points[2][0], 2) + 
				 Math.pow(points[0][1] - points[2][1], 2));

		// Compute s
		double s = 0;
		for (double e: side) 
			s += e;
		s /= 2;

		// Compute area
		double area = s;
		for (double i: side) {
			area *= (s - i);
		}
		return Math.sqrt(area);
	}

	/** linePosition returns the position of p2 to p0 and p1 */
	public static double linePosition(double[][] points) {
		return 
			(points[1][0] - points[0][0]) * (points[2][1] - points[0][1]) - 
			(points[2][0] - points[0][0]) * (points[1][1] - points[0][1]);
	}
}