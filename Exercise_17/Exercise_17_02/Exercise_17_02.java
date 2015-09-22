/*********************************************************************************
* (Create a binary data file) Write a program to create a file named             *
* Exercise17_02.dat if it does not exist. Append new data to it if it already    *
* exists. Write 100 integers created randomly into the file using binary I/O.    *
*********************************************************************************/
import java.io.*;

public class Exercise_17_02 {
	public static void main(String[] args) throws IOException {
		try (
			// Create an output stream to the file
			// Append new data if file already exists
			FileOutputStream output = 
				new FileOutputStream("Exercise17_02.dat", true);
		) {
			// Output 100 integers created randomly into the file
			for (int i = 0; i < 100; i++)
				output.write((int)(1 + Math.random() * 100));
		}
	}
}