/*********************************************************************************
* (Triangle class) Design a new Triangle class that extends the abstract         *
* GeometricObject class. Draw the UML diagram for the classes Triangle and       *
* GeometricObject and then implement the Triangle class. Write a test program    *
* that prompts the user to enter three sides of the triangle, a color, and a     *
* Boolean value to indicate whether the triangle is filled. The program should   *
* create a Triangle object with these sides and set the color and filled         *
* properties using the input. The program should display the area, perimeter,    *
* color, and true or false to indicate whether it is filled or not.              *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_13_01 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter three sides of a triangle a color 
		// and a Boolean value to indicate whether the triangle is filled
		System.out.print("Enter three sides of the triangle: ");
		double side1 = input.nextDouble();
		double side2 = input.nextDouble();
		double side3 = input.nextDouble();

		System.out.print("Enter a color: ");
		String color = input.next();

		System.out.print("Is the triangle filled (true / false)? ");
		boolean filled = input.nextBoolean();

		// Create a Triangle
		Triangle triangle = new Triangle(side1, side2, side3, color, filled);

		System.out.println(triangle);
	}
}