/*********************************************************************************
* (Generic bubble sort) Write the following two generic methods using bubble     *
* sort. The first method sorts the elements using the Comparable interface and   *
* the second uses the Comparator interface.                                      *
*                                                                                *
* public static <E extends Comparable<E>>                                        *
*   void bubbleSort(E[] list)                                                    *
* public static <E> void bubbleSort(E[] list,                                    *
*   Comparator<? super E> comparator)                                            *
*********************************************************************************/
import java.util.Comparator;

public class Exercise_23_01 {
	/** Generic bubble sort method using comparable */
	public static <E extends Comparable<E>> void bubbleSort(E[] list) {
		boolean needNextPass = true;

		for (int k = 1; k < list.length && needNextPass; k++) {
			// Array may be sorted and next pass not needed
			needNextPass = false;
			for (int i = 0; i < list.length - k; i++) {
				if (list[i].compareTo(list[i + 1]) > 0) {
					// Swap list[i] with list[i + 1]
					E temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;

					needNextPass = true; // Next pass still needed
				}
			}
		}
	}

	/** Generic bubble sort method using comparator */
	public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
		boolean needNextPass = true;

		for (int k = 1; k < list.length && needNextPass; k++) {
			// Array may be sorted and next pass not needed
			needNextPass = false;
			for (int i = 0; i < list.length - k; i++) {
				if (comparator.compare(list[i], list[i + 1]) > 0) {
					// Swap list[i] with list[i + 1]
					E temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;

					needNextPass = true; // Next pass still needed
				}
			}
		}
	}

	/** A test method */
	public static void main(String[] args) {
		// Create an Integer array
		Integer[] listArray = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

		// Carate a Double array
		Double[] doubleArray = {3.4, 1.3, -22.1, 14.8, 6.0, 2.3, 12.2};

		// Create a Character array
		Character[] charArray = {'a', 'J', 'r'};

		// Create a String array
		String[] stringArray = {"Tom", "Susan", "Kim"};

		// Sort the arrays
		bubbleSort(listArray);
		bubbleSort(doubleArray);
		bubbleSort(charArray);
		bubbleSort(stringArray);

		printList(listArray);
		printList(charArray);
		printList(stringArray);
		printList(doubleArray);

		// Create an array of 10 GeometricObjects
		GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
			new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
			new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
			new Circle(6.5), new Rectangle(4, 5)};

		// Invoke bubble sort using GeometricObjectComparator
		bubbleSort(list, new GeometricObjectComparator());

		// Display the sorted elements
		printList(list);
	}

	/** Print an array of objects */
	public static void printList(Object[] list) {
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		System.out.println();
	}

	/** Print the sorted elements */
	public static void printList(GeometricObject[] list) {
		System.out.print("Sorted elements: ");
		for (GeometricObject e: list) {
			System.out.printf("%.2f ", e.getArea());
		}
		System.out.println();
	}
}
