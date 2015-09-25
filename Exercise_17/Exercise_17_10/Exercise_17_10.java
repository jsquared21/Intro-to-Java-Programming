/*********************************************************************************
* (Split files) Suppose you want to back up a huge file (e.g., a 10-GB AVI file) *
* to a CD-R. You can achieve it by splitting the file into smaller pieces and    *
* backing up these pieces separately. Write a utility program that splits a      *
* large file into smaller ones using the following command:                      *
*                                                                                *
* java Exercise17_10 SourceFile numberOfPieces                                   *
*                                                                                *
* The command creates the files SourceFile.1, SourceFile.2, . . . , SourceFile.n *
* where n is numberOfPieces and the output files are about the same size.        *
*********************************************************************************/
import java.io.*;

public class Exercise_17_10 {
	public static void main(String[] args) throws IOException {
		// Check java usage
		if (args.length != 2) {
			System.out.println(
				"Usage: java Exercise_17_10 SourceFile numberOfPieces");
			System.exit(1);
		}

		// Get the number of pieces
		int numberOfPieces = Integer.parseInt(args[1]);

		// Create an array of random access files
		RandomAccessFile[] splits = 
			new RandomAccessFile[numberOfPieces];

		try (// Create a random access file
			RandomAccessFile inout = new RandomAccessFile(args[0], "r");
		) {
			// Add files to array
			for (int i = 0; i < splits.length; i++) {
				splits[i] = new RandomAccessFile(args[0] + "." + (i + 1), "rw");
			}
			int size = Math.round(inout.length() / numberOfPieces);
			int count = 0; // Count number of pieces written 
			byte[] b;

			for (int i = 0; i < numberOfPieces - 1; i++) {
				inout.seek(count * size);
				b = new byte[size];
				inout.read(b);
				splits[i].write(b);
				count++;
			}
			inout.seek(count * size);
			b = new byte[(int)inout.length() - (count * size)];
			inout.read(b);
			splits[numberOfPieces - 1].write(b);
		}
	}
}