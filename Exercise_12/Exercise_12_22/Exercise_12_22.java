/*********************************************************************************
* (Replace text) Revise Programming Exercise 12.16 to replace a string in a file *
* with a new string for all files in the specified directory using the command:  *
*                                                                                *
* java Exercise12_22 dir oldString newString                                     *
*********************************************************************************/
import java.util.*;
import java.io.*;

public class Exercise_12_22 {
	/** Main method */
	public static void main(String[] args) throws Exception {
		// Check command line parameter usage
		if (args.length != 3) {
			System.out.println(
				"Usage: Java Exercise_12_16 dir oldString newString");
			System.exit(1);
		}

		// Check if File object is a directory
		File dir = new File(args[0]);
		if (!dir.isDirectory()) {
			System.out.println("Directory " + args[0] + " does not exist");
			System.exit(2);
		}

		// Create an array of all the files in the directory
		File[] files = dir.listFiles();

		// Replace the string for each element in the array
		for (File e: files) {
			replaceText(e, args);
		}
	}

	/** Replaces a string in a file with a new string */
	public static void replaceText(File file, String[] args) 
			throws FileNotFoundException {
		// Create Arraylist
		ArrayList<String> list = new ArrayList<>();

		// Read text from file and change oldString to newString
		try (
			// Create input file
			Scanner input = new Scanner(file);
		) {
			while (input.hasNext()) {
				String s1 = input.nextLine();
				list.add(s1.replaceAll(args[1], args[2]));
			}
		}

		// Save the change into the original file
		try (
			// Create output file
			PrintWriter output = new PrintWriter(file);
		) {
			for (int i = 0; i < list.size(); i++) {
				output.println(list.get(i));
			}
		}
	}
}