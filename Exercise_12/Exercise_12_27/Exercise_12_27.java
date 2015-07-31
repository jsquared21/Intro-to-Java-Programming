/*********************************************************************************
* (Replace words) Suppose you have a lot of files in a directory that contain    *
* words Exercisei_j, where i and j are digits. Write a program that pads a 0     *
* before i if i is a single digit and 0 before j if j is a single digit. For     *
* example, the word Exercise2_1 in a file will be replaced by Exercise02_01. In  *
* Java, when you pass the symbol * from the command line, it refers to all files *
* in the directory (see Supplement III.V). Use the following command to run your *
* program.                                                                       *
*********************************************************************************/
import java.util.*;
import java.io.*;

public class Exercise_12_27 {
	/** Main method */
	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.out.println("Usage: java Exercise_12_27 *");
			System.exit(1);
		}

		// Create an ArrayList for File objects
		ArrayList<File> list = new ArrayList<>();

		// Add all files in the director to list
		addFiles(list, args);

		replaceWords(list);
	}

	/** Replaces a word in each file of a list */
	public static void replaceWords(ArrayList<File> file) 
			throws FileNotFoundException {

		for (int i = 0; i < file.size(); i++) {
			ArrayList<String> list = new ArrayList<>();
			try (
				// Create an input file
				Scanner input = new Scanner(file.get(i));
			) {
				while (input.hasNext()) {
					String word = input.nextLine();
					if (word.contains("Exercise")) {
						list.add(pad(word));
					}
					else
						list.add(word);
				}
			}

			try (
				// Create an output file
				PrintWriter output = new PrintWriter(file.get(i));
			) {
				for (int j = 0; j < list.size(); j++) {
					output.println(list.get(j));
				}
			}
		}
	}

	/** Pads words */
	public static String pad(String word) {
		ArrayList<String> str = new ArrayList<>(Arrays.asList(word.split(" ")));

		for (int i = 0; i < str.size(); i++) {
			if (str.get(i).matches("Exercise\\d_\\d")) {
				StringBuilder newStr = new StringBuilder(str.get(i));
				newStr.insert(newStr.length() - 1, 0 + ""); 
				newStr.insert(8, '0');
				str.remove(i);
				str.add(i, newStr.toString());
			}
		}

		String s = "";
		for (int i = 0; i < str.size(); i++) {
			s += str.get(i) + " ";
		}
		return s;
	}

	/** Creates and adds File objects to a list */
	public static void addFiles(ArrayList<File> list, String[] args) {
		for (int i = 0; i < args.length; i ++) {
			if (!args[i].equals("Exercise_12_27.java") &&
				 !args[i].equals("Exercise_12_27.class")) {
				list.add(new File(args[i]));
			}
		}
	}
}