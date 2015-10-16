/*********************************************************************************
* (Sort ArrayList) Write the following method that sorts an ArrayList:           *
*                                                                                *
* public static <E extends Comparable<E>>                                        *
* 	void sort(ArrayList<E> list)                                                  *
*********************************************************************************/
import java.util.ArrayList;

public class Exercise_19_09 {
	/** Sorts an ArrayList of comparable objects */
	public static <E extends Comparable<E>>
			void sort(ArrayList<E> list) {
		E currentMin;
		int currentMinIndex;

		for (int i = 0; i < list.size() - 1; i++) {
			// Find the minimum in the ArrayList
			currentMin = list.get(i);
			currentMinIndex = i;

			for (int j = i + 1; j < list.size(); j++) {
				if (currentMin.compareTo(list.get(j)) > 0) {
					currentMin = list.get(j);
					currentMinIndex = j;
				}
			}

			// Swap list.get(i) wtih list.get(currentMinIndex) if necessary;
			if (currentMinIndex != i) {
				list.set(currentMinIndex, list.get(i));
				list.set(i, currentMin);
			}
		}
	}
}