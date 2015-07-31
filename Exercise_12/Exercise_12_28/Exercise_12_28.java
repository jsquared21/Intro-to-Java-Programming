/*********************************************************************************
* (Rename files) Suppose you have a lot of files in a directory named            *
* Exercisei_j, where i and j are digits. Write a program that pads a 0 before i  *
* if i is a single digit. For example, a file named Exercise2_1 in a directory   *
* will be renamed to Exercise02_1. In Java, when you pass the symbol * from the  *
* command line, it refers to all files in the directory (see Supplement III.V).  *
* Use the following command to run your program.                                 *
*********************************************************************************/
import java.io.*;
import java.util.*;

public class Exercise_12_28 {
	/** Main method */
	public static void main(String[] args) {
		// Check java command line usage
		if (args.length < 1) {
			System.out.println("Usage: java Exercise_12_28 *");
			System.exit(1);
		}

		// Create an ArrayList of File objects
		ArrayList<File> list = getFiles(args);

		// Pad each file's name in list
		for (int i = 0; i < list.size(); i++) {
			padFileName(list.get(i));
		}
	}

	/** Pads a file's name with a 0 */
	public static void padFileName(File file) {
		StringBuilder newName = new StringBuilder(file.getName());
		newName.insert(8, '0');
		file.renameTo(new File(newName.toString()));
	}

	/** Add Files named Exercisei_j, where i and j are digits to a list */
	public static ArrayList<File> getFiles(String[] args) {
		ArrayList<File> list = new ArrayList<>();
		for (String e: args) {
			File f = new File(e);
			if (f.isFile() &&
				 f.getName().matches("Exercise\\d_\\d.*"))
				list.add(f);
		}
		return list;
	}
}