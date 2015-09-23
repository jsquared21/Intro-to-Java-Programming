/*********************************************************************************
* (Update count) Suppose you wish to track how many times a program has been     *
* executed. You can store an int to count the file. Increase the count by 1 each *
* time this program is executed. Let the program be Exercise17_08 and store the  *
* count in Exercise17_08.dat.                                                    *
*********************************************************************************/
import java.io.*;

public class Exercise_17_08 {
	public static void main(String[] args) throws IOException {
		try ( // Create a random access file
			RandomAccessFile inout = 
				new RandomAccessFile("Exercise17_08.dat", "rw");
		) {
			// Check if file has been executed
			if (inout.length() == 0) {
				inout.writeInt(1); // Start count
			}
			else {
				int count = inout.readInt(); // Read current count
				inout.seek(0); // Move the file pointer to the beginning
				inout.writeInt(++count); // Increment the count
			}
		}
	}
}