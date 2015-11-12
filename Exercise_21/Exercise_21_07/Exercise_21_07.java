/*********************************************************************************
* (Revise Listing 21.9, CountOccurrenceOfWords.java) Rewrite Listing 21.9 to     *
* display the words in ascending order of occurrence counts.                     *
*                                                                                *
* (Hint: Create a class named WordOccurrence that implements the Comparable      *
* interface. The class contains two fields, word and count. The compareTo method *
* compares the counts. For each pair in the hash set in Listing 21.9, create an  *
* instance of WordOccurrence and store it in an array list. Sort the array list  *
* using the Collections.sort method. What would be wrong if you stored the       *
* instances of WordOccurrence in a tree set?)                                    *
*********************************************************************************/
import java.util.*;

public class Exercise_21_07 {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a Map to hold words as keys and count as values
		Map<String, Integer> map = new HashMap<>();

		// Compute and store the occurrence of each word
		String[] words = text.split("[ \n\t\r.,;:!?()]");
		for (String word: words) {
			String key = word.toLowerCase();

			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}

		// Create an ArrayList
		ArrayList<WordOccurrence> list = new ArrayList<>();
		
		// Store the key and value from each entry in the list
		for (Map.Entry<String, Integer> entry: map.entrySet())
			list.add(new WordOccurrence(entry.getKey(), entry.getValue()));

		// Sort the list
		Collections.sort(list);

		// Display the sorted list
		System.out.println(list);
	}
}