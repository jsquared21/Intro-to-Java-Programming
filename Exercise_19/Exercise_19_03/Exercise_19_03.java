/*********************************************************************************
* (Distinct elements in ArrayList) Write the following method that returns a new *
* ArrayList. The new list contains the non-duplicate elements from the original  *
* list.                                                                          *
*                                                                                *
* public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)             *
*********************************************************************************/
import java.util.ArrayList;

public class Exercise_19_03 {
	/** Removes duplicate elements from an array list */
	public static <E extends Comparable<E>> 
			ArrayList<E> removeDuplicates(ArrayList<E> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).compareTo(list.get(j)) == 0)
					list.remove(j);
			}
		}
		return list;
	} 
}