/*********************************************************************************
* (The Colorable interface) Design an interface named Colorable with a void      *
* method named howToColor(). Every class of a colorable object must implement    *
* the Colorable interface. Design a class named Square that extends              *
* GeometricObject and implements Colorable. Implement howToColor to display the  *
* message Color all four sides.                                                  *
*                                                                                *
* Draw a UML diagram that involves Colorable, Square, and GeometricObject. Write *
* a test program that creates an array of five GeometricObjects. For each object *
* in the array, display its area and invoke its howToColor method if it is       *
* colorable.                                                                     *
*********************************************************************************/
public class Exercise_13_07 {
	/** Main method */
	public static void main(String[] args) {
		// Create an array of five GeometricObjects
		GeometricObject[] squares = {new Square(4.5), new Square(14), 
			new Square(8.2), new Square(12), new Square(10)};

		// Display the area and invoke the howToColor 
		// method for each GeometricObject
		for (int i = 0; i < squares.length; i++) {
		 	System.out.println("\nSquare #" + (i + 1));
		 	System.out.println("Area: " + squares[i].getArea());
		 	System.out.println("How to color: " + ((Square)squares[i]).howToColor());
		 } 
	}
}