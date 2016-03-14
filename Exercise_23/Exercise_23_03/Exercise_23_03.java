/*********************************************************************************
* (Generic quick sort) Write the following two generic methods using quick sort. *
* The first method sorts the elements using the Comparable interface and the     *
* second uses the Comparator interface.                                          *
*                                                                                *
* public static <E extends Comparable<E>>                                        *
*   void quickSort(E[] list)                                                     *
* public static <E> void quickSort(E[] list,                                     *
*   Comparator<? super E> comparator)                                            *
*********************************************************************************/
import java.util.Comparator;

public class Exercise_23_03 {
	/** Generic quick sort using Comparable */
	public static <E extends Comparable<E>> void quickSort(E[] list) {
		quickSort(list, 0, list.length - 1);
	}

	public static <E extends Comparable<E>> 
			void quickSort(E[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}

	/** Partition the array list[first..last] */
	public static <E extends Comparable<E>> 
			int partition(E[] list, int first, int last) {
		E pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; // Index for backward search

		while (high > low) {
			// Search forward from left
			while (low <= high && list[low].compareTo(pivot) <= 0)
				low++;

			// Search backward from right
			while (low <= high && list[high].compareTo(pivot) > 0)
				high--;

			// Swap two elements in the list
			if (high > low) {
				E temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

		while (high > first && list[high].compareTo(pivot) >= 0)
			high--;

		// Swap pivot with list[high]
		if (pivot.compareTo(list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else {
			return first;
		}
	}

	public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
		quickSort(list, 0, list.length - 1, comparator);
	}

	public static <E> void quickSort(
			E[] list, int first, int last, Comparator<? super E> comparator) {
		if (last > first) {
			int pivotIndex = partition(list, first, last, comparator);
			quickSort(list, first, pivotIndex - 1, comparator);
			quickSort(list, pivotIndex + 1, last, comparator);
		}
	}

	/** Partition the array list[first.. last] */
	public static <E> int partition(
			E[] list, int first, int last, Comparator<? super E> comparator) {
		E pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; // Index for backward search

		while (high > low) {
			// Search forward from left
			while (low <= high && comparator.compare(list[low], pivot) <= 0)
				low++;

			// Search backward from right
			while (low <= high && comparator.compare(list[high], pivot) > 0)
				high--;

			// Swap two elements in the list
			if (high > low) {
				E temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

		while (high > first && comparator.compare(list[high], pivot) >= 0)
			high--;

		// Swap pivot with list[high]
		if (comparator.compare(pivot, list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else {
			return first;
		}
	}

	/** A test method */
	public static void main(String[] args) {
		// Create an Integer array
		Integer[] intArray = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

		// Create a Double array
		Double[] doubleArray = {3.4, 1.3, -22.1, 14.8, 6.0, 2.3, 12.2};

		// Create a Character array
		Character[] charArray = {'a', 'J', 'r'};

		// Create a String array
		String[] stringArray = {"Tom", "Susan", "Kim"};

		// Sort the arrays
		quickSort(intArray);
		quickSort(doubleArray);
		quickSort(charArray);
		quickSort(stringArray);

		// Display the sorted arrays
		printList(intArray);
		printList(doubleArray);
		printList(charArray);
		printList(stringArray);

		// Create an array of 10 GeometricObjects
		GeometricObject[] list = {new Circle(5), new Rectangle(4, 5), 
			new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
			new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
			new Circle(6.5), new Rectangle(4, 5)};

		// Invoke quick sort using GeometricObjectComparator
		quickSort(list, new GeometricObjectComparator());

		// Display the sorted elements
		printList(list);
	}

	/** Print an array elements */
	public static void printList(Object[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}

	/** Print an array of elements */
	public static void printList(GeometricObject[] list) {
		System.out.print("Sorted elements: ");
		for (GeometricObject e: list) {
			System.out.printf("%.2f ", e.getArea());
		}
		System.out.println();
	}
}