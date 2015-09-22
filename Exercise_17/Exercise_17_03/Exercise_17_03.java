/*********************************************************************************
* (Sum all the integers in a binary data file) Suppose a binary data file named  *
* Exercise17_03.dat has been created and its data are created using              *
* writeInt(int) in DataOutputStream. The file contains an unspecified number of  *
* integers. Write a program to find the sum of the integers.                     *
*********************************************************************************/
import java.io.*;

public class Exercise_17_03 {
	public static void main(String[] args) throws IOException {
		int sum = 0; // Sum of the integers

		try ( // Create an data input stream for file Exercise17_03.dat
			DataInputStream input = 
				new DataInputStream(new FileInputStream("Exercise17_03.dat")); 
		) {
			// Read and sum the integers from the file
			while (true)
				sum += input.readInt();
		}
		catch (EOFException ex) { // Detect end of file
			System.out.println("Sum of the integers is: " + sum);
		}
	}
}