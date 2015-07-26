/*********************************************************************************
* (IllegalTriangleException) Programming Exercise 11.1 defined the Triangle class*
* with three sides. In a triangle, the sum of any two sides is greater than the  *
* other side. The Triangle class must adhere to this rule. Create the            *
* IllegalTriangleException class, and modify the constructor of the Triangle     *
* class to throw an IllegalTriangleException object if a triangle is created     *
* with sides that violate the rule, as follows:                                  *
*                                                                                *
* /** Construct a triangle with the specified sides */                          /*
* public Triangle(double side1, double side2, double side3)                      *
*   throws IllegalTriangleException {                                            *
*   // Implement it                                                              *
* }                                                                              *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_12_05 {
	public static void main(String[] args) {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a color
		System.out.print("Enter a color: ");
		String color = input.next();

		// Prompt the user to enter whether the triangle is filled
		System.out.print("Is the triangle filled (true / false)? ");
		boolean filled = input.nextBoolean();

		boolean repeatSidesInput = true;
		do {
			// Prompt the user to enter three sides of the triangle
			System.out.print("Enter three side of the triangle: ");
			double side1 = input.nextDouble();		
			double side2 = input.nextDouble();		
			double side3 = input.nextDouble();
	
			try {
				// Create triangle object with user input
				Triangle triangle = new Triangle(side1, side2, side3);
				repeatSidesInput = false;	
				
				triangle.setColor(color);
				triangle.setFilled(filled);
		
				System.out.println(triangle.toString());
				System.out.println("Area: " + triangle.getArea());
				System.out.println("Perimeter: " + triangle.getPerimeter());
				System.out.println("Color: " + triangle.getColor());
				System.out.println("Triangle is" + (triangle.isFilled() ? "" : " not ") 
					+ "filled");
			}
			catch (IllegalTriangleException ex) {
				System.out.println(ex.getMessage());
			}

		} while (repeatSidesInput);
	}
}