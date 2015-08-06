/*********************************************************************************
* (Sum the areas of geometric objects) Write a method that sums the areas of all *
* the geometric objects in an array. The method signature is:                    *
*                                                                                *
* public static double sumArea(GeometricObject[] a)                              *
*                                                                                *
* Write a test program that creates an array of four objects (two circles and    *
* two rectangles) and computes their total area using the sumArea method.        *
*********************************************************************************/
public class Exercise_13_12 {
	/** Method main */
	public static void main(String[] args) {
		// Create an array of four objects
		GeometricObject[] array = {new Circle(5), new Circle(8),
			new Rectangle(3, 4), new Rectangle(4, 2)};

		// Display results
		System.out.println("Total area of elements in array: " + sumArea(array));
	}

	/** Returns the sum of the areas of all 
	 *  the geometric objects in an array */
	public static double sumArea(GeometricObject[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i].getArea();
		}
		return sum;
	}
}