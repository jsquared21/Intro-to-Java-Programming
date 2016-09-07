/*********************************************************************************
* (setToList) Write the following method that returns an ArrayList from a set.   *
*                                                                                *
* public static <E> ArrayList<E> setToList(Set<E> s)                             *
*********************************************************************************/
import java.util.ArrayList;
import java.util.Set;

public class Exercise_27_11 {
	public static void main(String[] args) {
		// Create a set
		Set<String> set = new java.util.HashSet<>();
		set.add("Mark");
		set.add("Smith");
		set.add("Anderson");
		set.add("Sally");
		System.out.println("Elements in the set: " + set);

		// Convert the set to an ArrayList
		ArrayList<String> list = setToList(set);
		System.out.println("Elements in the ArrayList: " + list);
		System.out.println("Elements at ArrayList index 2: " + list.get(2));

	}

	/** Return an ArrayList from a set */
	public static <E> ArrayList<E> setToList(Set<E> s) {
		// Create an ArrayList
		ArrayList<E> list = new ArrayList<>();

		// Add elements from set
		for (E e: s) {
			list.add(e);
		}

		return list;
	}
}