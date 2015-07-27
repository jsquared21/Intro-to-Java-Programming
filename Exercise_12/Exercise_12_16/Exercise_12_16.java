/*********************************************************************************
* (Replace text) Listing 12.16, ReplaceText.java, gives a program that replaces  *
* text in a source file and saves the change into a new file. Revise the program *
* to save the change into the original file. For example, invoking               *
*                                                                                *
* java Exercise12_16 file oldString newString                                    *
*                                                                                *
* replaces oldString in the source file with newString.                          *
*********************************************************************************/
import java.util.*;
import java.io.*;

public class Exercise_12_16 {
	/** Main method */
	public static void main(String[] args) throws Exception {
		// Check command line parameter usage
		if (args.length != 3) {
			System.out.println(
				"Usage: Java Exercise_12_16 file oldString newString");
			System.exit(1);
		}

		// Check if file exists
		File file = new File(args[0]);
		if (!file.exists()) {
			System.out.println("File " + args[0] + " does not exist");
			System.exit(2);
		}

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