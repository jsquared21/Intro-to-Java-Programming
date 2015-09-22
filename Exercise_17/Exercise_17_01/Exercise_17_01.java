/************************************************************************************
* (Create a text file) Write a program to create a file named Exercise17_01.txt if  *
* it does not exist. Append new data to it if it already exists. Write 100 integers *
* created randomly into the file using text I/O. Integers are separated by a space. *
************************************************************************************/
import java.io.*;
import java.util.*;

public class Exercise_17_01 {
	public static void main(String[] args) throws FileNotFoundException {
		// Create an array list of string
		ArrayList<String> list = new ArrayList<>();

		// Check if file exist
		File file = new File("Exercise17_01.txt");
		if (file.exists()) {
			try (
				// Create input file
				Scanner input = new Scanner(file);
			) {// Read data from file
				while (input.hasNext()) {
					list.add(input.nextLine());
				}
			}
		}
		// Generate 100 integers randomly
		for (int i = 0; i < 100; i++) {
			list.add(((int)(Math.random() * 100)) + " ");
		}

		try (
			// Create output file
			PrintWriter output = new PrintWriter(file);
		) {
			// write to file using text I/O
			for (String l: list) {
				output.print(l);
			}
		}
	}
}