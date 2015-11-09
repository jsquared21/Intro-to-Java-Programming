/*******************************************************************************
* (Perform set operations on hash sets) Create two linked hash sets {"George", *
* "Jim", "John", "Blake", "Kevin", "Michael"} and {"George", "Katie", "Kevin", *
* "Michelle", "Ryan"} and find their union, difference, and intersection.      *
* (You can clone the sets to preserve the original sets from being changed by  *
* these set methods.)                                                          *
*******************************************************************************/
import java.util.*;

public class Exercise_21_01 {
	public static void main(String[] args) {
		// Create two linked hash sets
		Set<String> set1 = new LinkedHashSet<>(Arrays.asList(
			"George", "Jim", "John", "Blake", "Kevin", "Michael"));
		Set<String> set2 = new LinkedHashSet<>(Arrays.asList(
			"George", "Katie", "Kevin", "Michelle", "Ryan"));

		// Display the union of the two sets
		Set<String> union = new LinkedHashSet<>(set1);
		union.addAll(set2);
		System.out.println("Union of the two sets: " + union);

		// Display the difference of the two sets
		Set<String> difference = new LinkedHashSet<>(set1);
		difference.removeAll(set2);
		System.out.println("Difference of the two sets: " + difference);


		// Display the intersetion of the two sets
		Set<String> intersection = new LinkedHashSet<>();
		for (String e: set2) {
			if (set1.contains(e))
				intersection.add(e);
		}
		System.out.println("Intersection of the two sets: " + intersection);
	}
}
