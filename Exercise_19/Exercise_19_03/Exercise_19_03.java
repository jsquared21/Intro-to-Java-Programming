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
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		ArrayList<E> new_list = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
		    E o = list.get(i);
		    if (notContains(o, new_list))
			new_list.add(o);
		}
		return new_list;
	}

	public static <E> Boolean notContains(E o, ArrayList<E> list) {
		for (int i = 0; i < list.size(); i++) {
		    if (list.get(i).equals(o))
			return false;
		}
		return true;
	}
}
