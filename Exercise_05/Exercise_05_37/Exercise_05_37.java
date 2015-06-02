/*
(Decimal to binary) Write a program that prompts the user to enter a decimal
integer and displays its corresponding binary value. Don’t use Java’s Integer
.toBinaryString(int) in this program.
*/
import java.util.Scanner;

public class Exercise_05_37 {
	public static void main(String[] args) {
		// Create Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a decimal integer
		System.out.print("Enter a decimial interger: ");
		int decimal = input.nextInt();

		// Convert the decimal number to a binary number
		String binary = "";	// Holds the binary value
		for (int i = decimal; i > 0; i /= 2) {
			binary = (i % 2) + binary; 
		}

		// Display the corresponding binary value of the decimal integer
		System.out.println(
			"The binary value of the decimial \"" + decimal + "\" is: " + binary);
	}
}