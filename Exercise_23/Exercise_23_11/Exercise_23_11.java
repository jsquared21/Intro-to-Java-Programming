/***********************************************************************************
* (Heap clone and equals) Implement the clone and equals method in the Heap class. *
***********************************************************************************/
public class Exercise_23_11 {
	/** Test clone and equals method */
	public static void main(String[] args) throws CloneNotSupportedException {
		Integer[] list1 = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
		Integer[] list2 = {-44, -5, -3, 3, 5, 1, -4, 0, 1, 2, 4, 5, 53};
		Heap<Integer> heap1 = new Heap<>(list1);
		Heap<Integer> heap2 = (Heap)heap1.clone();
		Heap<Integer> heap3 = new Heap<>(list2);

		System.out.println("Heap1 is " + 
			(heap1.equals(heap2) ? "" : "not ") + "equal to heap2");

		System.out.println("Heap1 is " +
			(heap1.equals(heap3) ? "" : "not ") + "equal to heap3");
	}
}
                                      