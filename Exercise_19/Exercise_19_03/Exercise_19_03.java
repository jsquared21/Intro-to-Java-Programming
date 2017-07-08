/**************************************************************************************
* (Distinct elements in ArrayList) Write the following method that returns a new      *
* ArrayList. The new list contains the non-duplicate elements from the original list. *
*                                                                                     *
* public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)                  *
**************************************************************************************/
import java.util.ArrayList;

public class Exercise_19_03 {
	/** Removes duplicate elements from an array list */
	public static <E extends Comparable<E>> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		ArrayList<E> newList = new ArrayList<E>();
		if(!list.isEmpty()){
			newList.add(list.get(0));	//adds 1st item from reference list
			for (int i = 1; i < list.size(); i++) {		//loop starts from 1
				boolean shouldAddToNewList = true;
				for (int j = 0; j < newList.size(); j++) {
					if (list.get(i).compareTo(newList.get(j)) == 0){
						shouldAddToNewList = false;
					}
				}
				if(shouldAddToNewList){
					newList.add(list.get(i));
				}
			}
		}
		return newList;
	}
}
