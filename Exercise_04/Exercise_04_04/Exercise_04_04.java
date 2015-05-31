/*
(Geometry: area of a hexagon) The area of a hexagon can be computed using the
following formula (s is the length of a side):

Write a program that prompts the user to enter the side of a hexagon and displays
its area.
*/
import java.util.Scanner;

public class Exercise_04_04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter the side of a hexagon
		System.out.print("Enter the side: ");
		double s = input.nextDouble();

		// Compute the area of a hexagon
		double area = (6 * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / 6));

		// Display result
		System.out.printf("The are of the hexagon is %4.2f\n", area);
	}
}