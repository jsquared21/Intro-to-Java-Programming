/*********************************************************************************
* (The Octagon class) Write a class named Octagon that extends GeometricObject   *
* and implements the Comparable and Cloneable interfaces. Assume that all eight  *
* sides of the octagon are of equal length. The area can be computed using the   *
* following formula:                                                             *
*                                                                                *
*                      area = (2 + 4/√22)* side * side                           *
*                                                                                *
* Draw the UML diagram that involves Octagon, GeometricObject, Comparable, and   *
* Cloneable. Write a test program that creates an Octagon object with side value *
* 5 and displays its area and perimeter. Create a new object using the clone     *
* method and compare the two objects using the compareTo method.                 *
*********************************************************************************/
public class Exercise_13_11 {
	/** Method method */
	public static void main(String[] args) throws CloneNotSupportedException {
		// Create an Octagon object
		Octagon octagon1 = new Octagon(5);

		// Display area and perimeter of object
		System.out.println("\nOctagon:\nArea: " + octagon1.getArea() + 
			"\nPerimeter: " + octagon1.getPerimeter());

		// Create new object using the clone method
		System.out.println("Cloning Octagon...");
		Octagon octagon2 = (Octagon)octagon1.clone();

		// Compare the two object using compareTo method
		int result = (octagon1.compareTo(octagon2));
		if (result == 1)
			System.out.println("Octagon is greather than its clone.");
		else if (result == -1)
			System.out.println("Octagon is less than its clone."); 
		else
			System.out.println("Octagon is equal to its clone.");
	}
}