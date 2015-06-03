/*
(Business: check ISBN-13) ISBN-13 is a new standard for indentifying books. It
uses 13 digits d1d2d3d4d5d6d7d8d9d10d11d12checksum. The last digit checksum is a checksum,
which is calculated from the other digits using the following formula:

10 - (d1 + 3d2 + d3 + 3d4 + d5 + 3d6 + d7 + 3d8 + d9 + 3d10 + d11 + 3d12)%10

If the checksum is 10, replace it with 0. Your program should read the input as a
string.
*/
import java.util.Scanner;

public class Exercise_05_47 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter the first 12 digits of an ISBN-13 as string
		System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
		String isbn = input.nextLine();

		// Verify string length
		if (isbn.length() != 12) {
			System.out.println(isbn + " is an invalid input");
			System.exit(1);
		}

		int checksum = 0; // Holds the checksum value

		//	Calculate the checksum
		for (int i = 0; i < isbn.length(); i++) {
			checksum += i % 2 == 0 ? 3 * Integer.parseInt(isbn.charAt(i) + "") 
				: Integer.parseInt(isbn.charAt(i) + "");  
		}
		checksum = 10 - checksum % 10;

		// Print the result if checksum is 10, replace it with 0
		System.out.println("The ISBN-13 number is " + isbn + 
			(checksum == 10 ? 0 : checksum));
	}
}