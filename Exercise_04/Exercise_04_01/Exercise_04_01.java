/*
(Geometry: area of a pentagon) Write a program that prompts the user to enter
the length from the center of a pentagon to a vertex and computes the area of the
pentagon, as shown in the following figure.

where r is the length from the center of a pentagon to a vertex. Round up two digits
after the decimal point.
*/
import java.util.Scanner;

public class Exercise_04_01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// prompt the user to enter the length from  
		// the center of a pentagon to a vertex
		System.out.print("Enter the length from the center to a vertex: ");
		double r = input.nextDouble();

		// Compute the area of the pentagon
		double s = (2 * r) * Math.sin(Math.PI / 5); // Length of a side
		double area = (5 * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / 5));

		// Display results
		System.out.printf("The area of the pentagon is %5.2f\n", area);
	}
}