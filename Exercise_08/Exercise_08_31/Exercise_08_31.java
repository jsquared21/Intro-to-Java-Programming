/*********************************************************************************
* (Geometry: intersecting point) Write a method that returns the intersecting    *
* point of two lines. The intersecting point of the two lines can be found by    *
* using the formula shown in Programming Exercise 3.25. Assume that (x1, y1) and *
* (x2, y2) are the two points on line 1 and (x3, y3) and (x4, y4) are on line 2. *
* The method header is                                                           *
*                                                                                *
* public static double[] getIntersectingPoint(double[][] points)                 *
*                                                                                *
* The points are stored in a 4-by-2 two-dimensional array points with            *
* (points[0][0], points[0][1]) for (x1, y1). The method returns the intersecting *
* point or null if the two lines are parallel. Write a program that prompts      *
* the user to enter four points and displays the intersecting point. See         *
* Programming Exercise 3.25 for a sample run.                                    *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_08_31 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Create a 4 x 2 array
		double[][] points = new double[4][2]; 

		// Prompt the user to enter four points
		System.out.println("Enter four points:");
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points[i].length; j++) {
				points[i][j] = input.nextDouble();
			}
		}

		// Get intersecting point
		double[] result = getIntersectingPoint(points);

		// Display the intersection point
		if (result == null)
			System.out.println("The two lines are parallel");
		else {
			System.out.println("The intersecting point is at (" + 
				result[0] + ", " + result[1] + ")");
		}
		
	}

	/** getIntersectingPoint */
	public static double[] getIntersectingPoint(double[][] points) {
		// Create a 2 x 2 matrix
		double[][] a = new double[2][2];

		// Create an array of length 2
		double[] b = new double[2];

		// Calculate the intersecting point
		a[0][0] = points[0][1] - points[1][1];
		a[0][1] = -1 * (points[0][0] - points[1][0]);
		a[1][0] = points[2][1] - points[3][1];
		a[1][1] = -1 * (points[2][0] - points[3][0]);
		b[0] = (points[0][1] - points[1][1]) * points[0][0] - 
				 (points[0][0] - points[1][0]) * points[0][1];
		b[1] = (points[2][1] - points[3][1]) * points[2][0] - 
				 (points[2][0] - points[3][0]) * points[2][1];

		return Exercise_08_30.linearEquation(a, b);
	}
}