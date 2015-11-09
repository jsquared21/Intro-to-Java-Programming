/*********************************************************************************
* (Display nonduplicate words in ascending order) Write a program that reads     *
* words from a text file and displays all the nonduplicate words in ascending    *
* order. The text file is passed as a command-line argument.                     *
*********************************************************************************/
import java.util.*;
import java.io.*;

public class Exercise_21_02 {
	public static void main(String[] args) throws Exception {
		// Check length of command-line argument
		if (args.length != 1) {
			System.out.println("Usage: java fileName");
			System.exit(1);
		}

		// Check if file exists
		File textFile = new File(args[0]);
		if (!textFile.exists()) {
			System.out.println("The file " + args[0] + " does not exist.");
			System.exit(2);
		}

		// Create a set
		TreeSet<String> set = new TreeSet<>();

		// Read nonduplicate words from the file
		try ( // Create an input file 
			Scanner input = new Scanner(textFile);
		) {
			while (input.hasNext()) {
				String[] words = input.nextLine().split("[ \n\t\r.,;:!?()-]");
				for (String word: words) {
					if (word.length() > 0)
						set.add(word.toLowerCase());	
				}
			}
		}

		// Display nonduplicate word in ascending order
		System.out.println(set);
	}
}