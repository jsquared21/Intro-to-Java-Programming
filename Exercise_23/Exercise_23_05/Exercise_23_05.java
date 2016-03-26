/*********************************************************************************
* (Generic heap sort) Write the following two generic methods using heap sort.   *
* The first method sorts the elements using the Comparable interface and the     *
* second uses the Comparator interface.                                          *
*                                                                                *
* public static <E extends Comparable<E>>                                        *
*   void heapSort(E[] list)                                                      *
* public static <E> void heapSort(E[] list,                                      *
*   Comparator<? super E> comparator)                                            *
*********************************************************************************/
import java.util.Comparator;

public class Exercise_23_05 {

	public static <E extends Comparable<E>> void heapSort(E[] list) {
		// Create a Heap
		Heap<E> heap = new Heap<>();

		// Add elements to the heap
		for (int i = 0; i < list.length; i++)
			heap.add(list[i]);

		// Remove elements form the heap
		for (int i = list.length - 1; i >= 0; i--)
			list[i] = heap.remove();
	}

	public static <E> void heapSort(E[] list, Comparator<? super E> comparator) {
		// Create a Heap
		HeapA<E> heap = new HeapA<>(comparator);

		// Add elements to the heap
		for (int i = 0; i < list.length; i++)
			heap.add(list[i]);

		// Remove elements from the heap
		for (int i = list.length - 1; i >= 0; i--)
			list[i] = heap.remove();
	}

	/** A test method */
	public static void main(String[] args) {
		/** Create an Array of Integers */
		Integer[] intArray = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
		
		/** Create an Array of Doubles */
		Double[] doubleArray = {3.4, 1.3, -22.1, 14.8, 6.0, 2.3, 12.2};
		
		/** Create an Array of Characters */
		Character[] charArray = {'a', 'J', 'r'};
		
		/** Create an Array of String */
		String[] stringArray = {"Tom", "Susan", "Kim"};
		
		/** Heapsort the arrays */
		heapSort(intArray);
		heapSort(doubleArray);
		heapSort(charArray);
		heapSort(stringArray);
		
		/** Display the array */
		System.out.print("Sorted Integers: ");
		printList(intArray);
		
		System.out.print("Sorted Doubles: ");
		printList(doubleArray);

		System.out.print("Sorted Characters: ");
		printList(charArray);

		System.out.print("Sorted Strings: ");
		printList(stringArray);

		// Create an array of 10 GeometricObjects
		GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
			new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
			new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
			new Circle(6.5), new Rectangle(4, 5)};
		heapSort(list, new GeometricObjectComparator());
		System.out.print("Sorted elements: ");
		for (GeometricObject e: list) {
			System.out.printf("%.2f ", e.getArea());
		}
		System.out.println();
	}

	/** Display elements in an Array */
	public static void printList(Object[] list) {
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		System.out.println();
	}
}