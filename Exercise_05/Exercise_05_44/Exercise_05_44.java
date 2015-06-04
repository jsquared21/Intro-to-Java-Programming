/*
(Computer architecture: bit-level operations) A short value is stored in 16 bits.
Write a program that prompts the user to enter a short integer and displays the 16
bits for the integer. Here are sample runs:
*/
import java.util.Scanner;

public class Exercise_05_44 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a short integer
		System.out.print("Enter an integer: ");
		short number = input.nextShort();

		String bits = "";	// Holds the bits

		// Get the 16 bits for the integer 
		for (int i = 0; i < 16; i++) {
			bits = (number & 1) + bits;
			number >>= 1;
		}

		// Display result
		System.out.println("The bits are " + bits);
	}
}