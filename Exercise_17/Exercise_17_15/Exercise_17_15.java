/*********************************************************************************
* (Decrypt files) Suppose a file is encrypted using the scheme in Programming    *
* Exercise 17.14. Write a program to decode an encrypted file. Your program      *
* should prompt the user to enter an input file name for the encrypted file and  *
* an output file name for the unencrypted version of the input file.             *
*********************************************************************************/
import java.io.*;
import java.util.Scanner;

public class Exercise_17_15 {
	public static void main(String[] args) throws IOException {
		// Create a scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter the input file for the encrypted file
		// and the output file name for the unencrypted version of the input file
		System.out.print("Enter the encrypted file name: ");
		String inFile = input.next();
		System.out.print("Enter the file name for the decrypted file: ");
		String outFile = input.next();

		try ( // Create two random access files
			RandomAccessFile encrypted = new RandomAccessFile(inFile, "r");
			RandomAccessFile decrypted = new RandomAccessFile(outFile, "rw");
		) {
			// Subtract 5 from every byte in the encrypted file
			// the write to decrypted file
			int r;
			encrypted.seek(0); // Move the file pointer to beginning
			while ((r = encrypted.read()) != -1) {
				decrypted.write(((byte)r) - 5);
			}
		}
	}
}