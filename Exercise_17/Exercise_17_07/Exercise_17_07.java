/*********************************************************************************
* (Restore objects from a file) Suppose a file named Exercise17_07.dat has been  *
* created using the ObjectOutputStream. The file contains Loan objects. The Loan *
* class in Listing 10.2 does not implement Serializable. Rewrite the Loan class  *
* to implement Serializable. Write a program that reads the Loan objects from    *
* the file and displays the total loan amount. Suppose you don’t know how many   *
* Loan objects are there in the file, use EOFException to end the loop.          *
*********************************************************************************/

import java.io.*;

public class Exercise_17_07 {
	public static void main(String[] args) 
			throws IOException, ClassNotFoundException {
		try ( // Create an input stream for file Exercise17.07.dat
			ObjectInputStream input = new ObjectInputStream(new 
				BufferedInputStream(new FileInputStream("Exercise17_07.dat")))
		) { // Read Loan objects from file and display the total loan amount
			while (true) {
				Loan loan = (Loan)input.readObject();
				System.out.println(loan);
				System.out.printf("Total loan amount: $%.2f\n", 
					loan.getTotalPayment());
				System.out.println();
			}
		}
		catch (EOFException ex) {
			// Use EOFExecption to end the loop
		}
	}
}