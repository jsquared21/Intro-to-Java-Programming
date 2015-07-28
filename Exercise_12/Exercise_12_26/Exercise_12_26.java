/*********************************************************************************
* (Create a directory) Write a program that prompts the user to enter a          *
* directory name and creates a directory using the File’s mkdirs method. The     *
* program displays the message “Directory created successfully” if a directory   *
* is created or “Directory already exists” if the directory already exists.      *
*********************************************************************************/
import java.util.*;
import java.io.*;

public class Exercise_12_26 {
	/** Main method */
	public static void main(String[] args) throws Exception {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a directory name
		System.out.print("Enter directory name: ");
		File dir = new File(input.next());

		// Check if directory exists
		if (dir.isDirectory()) {
			System.out.println("Directory already exists");
			System.exit(0);
		}

		// Create directory
		if (dir.mkdirs()) {
			System.out.println("Directory created successfully");
		}
	}
}