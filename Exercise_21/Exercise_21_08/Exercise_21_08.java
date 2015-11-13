/*********************************************************************************
* (Count the occurrences of words in a text file) Rewrite Listing 21.9 to read   *
* the text from a text file. The text file is passed as a command-line argument. *
* Words are delimited by whitespace characters, punctuation marks (,;.:?),       *
* quotation marks ('"), and parentheses. Count words in case-insensitive fashion *
* (e.g., consider Good and good to be the same word). The words must start with  *
* a letter. Display the output in alphabetical order of words, with each word    *
* preceded by its occurrence count.                                              *
*********************************************************************************/
import java.util.*;
import java.io.*;

public class Exercise_21_08 {
	public static void main(String[] args) throws Exception {
		// Check command-line argument length
		if (args.length != 1) {
			System.out.println("Usage: java Exercise_21_08 textFileName");
			System.exit(1);
		}

		// Check if the file exists
		File file = new File(args[0]);
		if (!file.exists()) {
			System.out.println("The file " + args[0] + " does not exists.");
			System.exit(1);
		}

		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new TreeMap<>();
		
		try ( // Create an input stream
			Scanner input = new Scanner(file);
		) {
			while (input.hasNext()) {
				String[] words = input.nextLine().split("[ \n\t\r\"\'.,;:!?()]");
				store(map, words);
			}
		}	

		// Get all entries into a set
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

		// Get key and value from each entry
		for (Map.Entry<String, Integer> entry: entrySet)
			System.out.println(entry.getValue() + "\t" + entry.getKey());
	}

	/** Method Sotres occurrence of words */
	private static void store(Map<String, Integer> map, String[] words) {
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();

			if (key.length() > 0 && Character.isLetter(key.charAt(0))) {
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
	}
}