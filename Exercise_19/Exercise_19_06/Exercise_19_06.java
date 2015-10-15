/*********************************************************************************
* (Maximum element in a two-dimensional array) Write a generic method that       *
* returns the maximum element in a two-dimensional array.                        *
*                                                                                *
* public static <E extends Comparable<E>> E max(E[][] list)                      *
*********************************************************************************/
public class Exercise_19_06 {
	/** Method returns the maximum element in a two-dimensional array */
	public static <E extends Comparable<E>> E max(E[][] list) {
		E max = list[0][0];
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				if (list[i][j].compareTo(max) > 0)
					max = list[i][j];
			}
		}
		return max;
	}
}
