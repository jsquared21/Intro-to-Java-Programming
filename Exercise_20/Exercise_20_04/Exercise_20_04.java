/**********************************************************************************
* (Sort points in a plane) Write a program that meets the following requirements: *
*                                                                                 *
* ■ Define a class named Point with two data fields x and y to represent a        *
*   point’s x- and y-coordinates. Implement the Comparable interface for          *
* 	 comparing the points on x-coordinates. If two points have the same            *
*   x-coordinates, compare their y-coordinates.                                   *
*                                                                                 *
* ■ Define a class named CompareY that implements Comparator<Point>. Implement    *
*   the compare method to compare two points on their y-coordinates. If two       *
* 	 points have the same y-coordinates, compare their x-coordinates.              *
*                                                                                 *
* ■ Randomly create 100 points and apply the Arrays.sort method to display the    *
*   points in increasing order of their x-coordinates and in increasing order of  *
*   their y-coordinates, respectively.                                            *
**********************************************************************************/
import java.util.*;
public class Exercise_20_04 {
	public static void main(String[] args) {
		// Randomly create 100 points
		Point[] points = new Point[100];
		for (int i = 0; i < points.length; i++) {
			points[i] = new Point((double)(Math.random() * 5),
				(double)(Math.random() * 5));
		}

		// Display the points in increasing order of their x-coordinates
		Arrays.sort(points);
		List<Point> list1 = Arrays.asList(points);
		System.out.println("\nPoints in increasing order of their x-coordinates:");
		System.out.println(list1);
		
		
		// Display the points in increasing order of their y-coordinates
		Arrays.sort(points, new CompareY());
		List<Point> list2 = Arrays.asList(points);
		System.out.println("\nPoints in increasing order of their y-coordinates:");
		System.out.println(list2);
	}
}