/*********************************************************************************
* (The Rectangle class) Following the example of the Circle class in Section 9.2,*
* design a class named Rectangle to represent a rectangle. The class contains:   *
*                                                                                *
* ■ Two double data fields named width and height that specify the width and     *
* height of the rectangle. The default values are 1 for both width and height.   *
* ■ A no-arg constructor that creates a default rectangle.                       *
* ■ A constructor that creates a rectangle with the specified width and height.  *
* ■ A method named getArea() that returns the area of this rectangle.            *
* ■ A method named getPerimeter() that returns the perimeter.                    *
*                                                                                *
* Draw the UML diagram for the class and then implement the class. Write a test  *
* program that creates two Rectangle objects—one with width 4 and height 40      *
* and the other with width 3.5 and height 35.9. Display the width, height, area, *
* and perimeter of each rectangle in this order.                                 *
*********************************************************************************/
public class Exercise_09_01 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Rectangle with width 4 and height 40
		Rectangle rectangle1 = new Rectangle(4, 40);

		// Create a Rectangle with width 3.5 and height 35.9
		Rectangle rectangle2 = new Rectangle(3.5, 35.9);

		// Display the width, height, area, and perimeter of rectangle1
		System.out.println("\n Rectangle 1");
		System.out.println("-------------");
		System.out.println("Width:     " + rectangle1.width);
		System.out.println("Height:    " + rectangle1.height);
		System.out.println("Area:      " + rectangle1.getArea());
		System.out.println("Perimeter: " + rectangle1.getPerimeter());

		// Display the width, height, area, and perimeter of rectangle2
		System.out.println("\n Rectangle 2");
		System.out.println("-------------");
		System.out.println("Width:     " + rectangle2.width);
		System.out.println("Height:    " + rectangle2.height);
		System.out.println("Area:      " + rectangle2.getArea());
		System.out.println("Perimeter: " + rectangle2.getPerimeter());
	}
}