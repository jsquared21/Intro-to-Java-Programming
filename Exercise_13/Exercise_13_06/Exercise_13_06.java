/*********************************************************************************
* (The ComparableCircle class) Define a class named ComparableCircle that        *
* extends Circle and implements Comparable. Draw the UML diagram and implement   *
* the compareTo method to compare the circles on the basis of area. Write a test *
* class to find the larger of two instances of ComparableCircle objects.         *
*********************************************************************************/
public class Exercise_13_06 {
	/** Main method */
	public static void main(String[] args) {
		// Create two instances of ComparableCircle objects
		ComparableCircle comparableCircle1 = new ComparableCircle(12.5);
		ComparableCircle comparableCircle2 = new ComparableCircle(18.3);

		// Display comparableCircles
		System.out.println("\nComparableCircle1:");
		System.out.println(comparableCircle1);
		System.out.println("\nComparableCircle2:");
		System.out.println(comparableCircle2);

		// Find and display the larger of the two ComparableCircle objects
		System.out.println((comparableCircle1.compareTo(comparableCircle2) == 1 
			? "\nComparableCircle1 " : "\nComparableCircle2 ") + 
			"is the larger of the two Circles");
	}
}