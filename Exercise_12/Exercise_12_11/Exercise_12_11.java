/*********************************************************************************
* (Remove text) Write a program that removes all the occurrences of a specified  *
* string from a text file. For example, invoking                                 *
*                                                                                *
* java Exercise12_11 John filename                                               *
*                                                                                *
* removes the string John from the specified file. Your program should get the   *
* arguments from the command line.                                               *
*********************************************************************************/
import java.io.*;
import java.util.*;

public class Exercise_12_11 {
	/** Main method */
	public static void main(String[] args) throws Exception {
		// Check command line parameter usage
		if (args.length != 2) {
			System.out.println("Usage: java RemoveText filename");
			System.exit(1);
		}

		// Check if file exists
		File file = new File(args[1]);
		if (!file.exists()) {
			System.out.println("File " + args[1] + " does not exist");
			System.exit(2);
		}

		// Create an ArrayList
		ArrayList<String> s2 = new ArrayList<>(); 
		try (
			// Create input file
			Scanner input = new Scanner(file);
		) {
			while (input.hasNext()) {
				String s1 = input.nextLine();
				s2.add(removeString(args[0], s1));
			}
		}

		try (
			// Create output file
			PrintWriter output = new PrintWriter(file);
		) {
			for (int i = 0; i < s2.size(); i++) {
				output.println(s2.get(i));
			}
		}
	}

	public static String removeString(String string, String line) {
		StringBuilder stringBuilder = new StringBuilder(line);
		int start = stringBuilder.indexOf(string); // Start index
		int end = string.length(); // End index

		while (start >= 0) {
			end = start + end;
			stringBuilder = stringBuilder.delete(start, end);
			start = stringBuilder.indexOf(string, start); 
		}

		return stringBuilder.toString();
	}
}