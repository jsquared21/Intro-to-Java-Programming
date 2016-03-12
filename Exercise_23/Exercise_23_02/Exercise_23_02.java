/*********************************************************************************
* (Generic merge sort) Write the following two generic methods using merge sort. *
* The first method sorts the elements using the Comparable interface and the     *
* second uses the Comparator interface.                                          *
*                                                                                *
* public static <E extends Comparable<E>>                                        *
*   void mergeSort(E[] list)                                                     *
* public static <E> void mergeSort(E[] list,                                     *
*   Comparator<? super E> comparator)                                            *
*********************************************************************************/
import java.util.Comparator;
import java.util.Arrays;

public class Exercise_23_02 {
	/** Generic merge sort using Comparable */
	public static <E extends Comparable<E>> void mergeSort(E[] list) {
		if (list.length > 1) {
			// Merge sort the first half
			E[] firstHalf = (E[])new Comparable[list.length / 2];
			System.arraycopy(list, 0 , firstHalf, 0, list.length / 2);
			mergeSort(firstHalf);

			// Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			E[] secondHalf = (E[])(new Comparable[secondHalfLength]);
			System.arraycopy(list, list.length / 2,
				secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);

			// Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list);
		}
	}

	/** Merge two sorted lists */
	public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp) {
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp

		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1].compareTo(list2[current2]) < 0)
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}

		while (current1 < list1.length) 
			temp[current3++] = list1[current1++];
		
		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
	}

	public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) {
		/** Generic mergeSort using Comparator */
		if (list.length > 1) {
			// Merge sort the first half
			E[] firstHalf = Arrays.copyOf(list, list.length / 2);
			mergeSort(firstHalf, comparator);

			// Merge sort the second half
			E[] secondHalf = Arrays.copyOfRange(list, list.length / 2, list.length);
			mergeSort(secondHalf, comparator);

			// Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list, comparator);
		}
	}

	/** Merge two sorted lists */
	public static <E> void merge(E[] list1, E[] list2, E[] temp, 
			Comparator<? super E> comparator) {
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp

		while (current1 < list1.length && current2 < list2.length) {
			if (comparator.compare(list1[current1], list2[current2]) < 0)
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}

		while (current1 < list1.length)
			temp[current3++] = list1[current1++];

		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
	}

	/** A test method */
	public static void main(String[] args) {
		Integer[] intArray = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

		// Create a Double array
		Double[] doubleArray = {3.4, 1.3, -22.1, 14.8, 6.0, 2.3, 12.2};

		// Create a Character array
		Character[] charArray = {'a', 'J', 'r'};

		// Create a String array
		String[] stringArray = {"Tom", "Susan", "Kim"};

		// Sort the arrays
		mergeSort(intArray);
		mergeSort(doubleArray);
		mergeSort(charArray);
		mergeSort(stringArray);

		// Display the arrays
		printList(intArray);
		printList(charArray);
		printList(stringArray);
		printList(doubleArray);

		// Create an array of 10 GeometricObjects
		GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
			new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
			new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
			new Circle(6.5), new Rectangle(4, 5)};

		// Invoke merge sort using GeometricObjectComparator
		mergeSort(list, new GeometricObjectComparator());

		// Display the sorted elements
		printList(list);
	}

	/** Print an array of Objects */
	public static void printList(Object[] list) {
		for (int i = 0; i < list.length; i ++)
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