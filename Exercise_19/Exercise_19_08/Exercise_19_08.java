/*********************************************************************************
* (Shuffle ArrayList) Write the following method that shuffles an ArrayList:     *
*                                                                                *
* public static <E> void shuffle(ArrayList<E> list)                              *
*********************************************************************************/
import java.util.ArrayList;

public class Exercise_19_08 {
	/** Method shuffles an ArrayList */
	public static <E> void shuffle(ArrayList<E> list) {
		for (int i = 0; i < list.size(); i++) {
			int index = (int)(Math.random() * list.size());
			E temp = list.get(i);
			list.set(i, list.get(index));
			list.set(index, temp);
		}
	}
}