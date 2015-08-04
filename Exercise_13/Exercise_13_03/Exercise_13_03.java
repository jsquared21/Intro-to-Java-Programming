/*********************************************************************************
* (Sort ArrayList) Write the following method that sorts an ArrayList of numbers.*
*                                                                                *
* public static void sort(ArrayList<Number> list)                                *
*********************************************************************************/
import java.util.ArrayList;

public class Exercise_13_03 {
	/** Main method */
	public static void main(String[] args) {
		// Create and arrayList
		ArrayList<Number> list = new ArrayList<>();

		// Add unsorted numbers to list
		list.add(1);
		list.add(8);
		list.add(2.3);
		list.add(7.43);
		list.add(3);
		list.add(6.246);
		list.add(5);
		list.add(4.6);

		System.out.println(list.toString());

		// Sort list
		sort(list);

		// Display list of sorted numbers
		System.out.println(list.toString());
	}

	/** Sorts an ArrayList of numbers */
	public static void sort(ArrayList<Number> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			// Find the mimimum in the list
			Number min = list.get(i);
			int minIndex = i;

			for (int j = i + 1; j < list.size(); j++) {
				if (min.doubleValue() > list.get(j).doubleValue()) {
					min = list.get(j);
					minIndex = j;
				}
			}

			// Swap list.get(i) with list.get(minIndex) if necessary
			if (minIndex != i) {
				list.set(minIndex, list.get(i));
				list.set(i, min);
			} 
		}
	}
}