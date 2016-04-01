/*********************************************************************************
* (Sort using a heap) Implement the following sort method using a heap.          *
*                                                                                *
* public static <E extends Comparable<E>> void sort(E[] list)                    *
*********************************************************************************/

public class Exercise_23_08 {
	public static <E extends Comparable<E>> void sort(E[] list) {
		// Create a Heap of objects
		Heap<E> heap = new Heap<>(list);

		// Remove elements from the heap
		for (int i = list.length - 1; i >= 0; i--)
			list[i] = heap.remove();
	}

	public static void main(String[] args) {
		Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
		sort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		System.out.println();
	}
}