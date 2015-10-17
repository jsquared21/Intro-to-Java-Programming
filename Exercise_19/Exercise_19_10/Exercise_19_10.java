/*********************************************************************************
* (Largest element in ArrayList) Write the following method that returns the     *
* largest element in an ArrayList:                                               *
*                                                                                *
* public static <E extends Comparable<E>> E max(ArrayList<E> list)               *
*********************************************************************************/
import java.util.ArrayList;

public class Exercise_19_10 {
	/** Method returns the largest element in an ArrayList */
	public static <E extends Comparable<E>> E max(ArrayList<E> list) {
		E max = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (max.compareTo(list.get(i)) < 0)
				max = list.get(i);
		}
		return max;
	}
}