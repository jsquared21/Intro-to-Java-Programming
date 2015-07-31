import java.util.*;
import java.io.*;

public class CreateFiles {
	/** Main method */
	public static void main(String[] args) throws Exception {
		// Create an ArrayList
		ArrayList<File> directories = new ArrayList<>();

		// Add directories to list
		addDirectories(directories);
		
		// Create files in each directory
		makeFiles(directories);
	}

	/** Creates and adds files to a list */
	public static void makeFiles(ArrayList<File> d) 
		throws FileNotFoundException {
		for (int i = 0; i < d.size(); i++) {
			makeFiles(3, d.get(i), "TestJavafile", ".java");
			makeFiles(2, d.get(i), "TestTextfile", ".txt");
			makeFiles(2, d.get(i), "TestDatfile", ".dat");
		}
	}

	/** Create n File objects in a directory */
	public static void makeFiles(
		int n, File dir, String fileName, String ext) 
		throws FileNotFoundException {
		for (int j = 1; j <= n; j++) {
			File file = new File(dir, fileName + j + ext);
			if(!file.exists()) {
				try (
						// Create output file
						PrintWriter output = new PrintWriter(file);
				) {
					// Write 100 integers created radomly to file
					for (int i = 0; i < 100; i++) {
						output.print(((int)(Math.random() * 500) + 1));
						output.print(" ");
					}
				}
			}
		}
	}

	/** Adds directories to a list */
	public static void addDirectories(ArrayList<File> list) {
		for (int i = 1; i <= 34; i++) {
			// Check if file exists
			File dir = new File("srcRootDirectory/chapter" + i);
			if (!dir.isDirectory()) {
				if (dir.mkdirs())
					list.add(dir);
			}
		}
	}
}