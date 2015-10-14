/************************************************************************************
* (Generic linear search) Implement the following generic method for linear search. *
*                                                                                   *
* public static <E extends Comparable<E>>                                           *
* 	int linearSearch(E[] list, E key)                                                *
************************************************************************************/
public class Exercise_19_04 {
	/** Method finds the key in a list */
	public static <E extends Comparable<E>>
			int linearSearch(E[] list, E key) {
		for (int i = 0; i < list.length; i++) {
			if (key.compareTo(list[i]) == 0)
				return i;
		}
		return -1;
	}
}