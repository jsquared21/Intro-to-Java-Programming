/*
(Compute the volume of a cylinder) Write a program that reads in the radius
and length of a cylinder and computes the area and volume using the following
formulas:
area = radius * radius * pi
volume = area * length
*/
import java.util.Scanner;

public class Exercise_02_02 {
	public static void main(String[] args) {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);
		final double PI = 3.14159265359;

		// Prompt user to enter the radius and length of a cylinder
		System.out.print("Enter the radius and length of a cylinder: ");
		double radius = input.nextDouble();
		double length = input.nextDouble();

		// Comput the area and volume 
		double area = radius * radius * PI;
		double volume = area * length;

		// Display results
		System.out.println("The area is " + area);
		System.out.println("The volume is " + volume);
	}
}