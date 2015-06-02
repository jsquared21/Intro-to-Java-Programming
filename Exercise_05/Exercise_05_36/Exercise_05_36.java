/*
(Business application: checking ISBN ) Use loops to simplify Programming
Exercise 3.9.
*/
import java.util.Scanner;

public class Exercise_05_36 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter the first 9 digits of a 10-digit ISBN
		System.out.print("Enter the first 9 digits of an ISBN as integer: ");
		String isbn = input.nextLine();

		int d10 = 0;
		// Extract the digits of the ISBN and compute d10
		for (int i = 0; i < 9; i++) {
			d10 += Integer.parseInt(isbn.charAt(i) + "") * (i + 1);
		}
		d10 %= 11;

		// Display the 10-digit ISBN
		for (int i = 0; i < 9; i++) {
			System.out.print(isbn.charAt(i));
		}
		if (d10 == 10)
			System.out.println("X");
		else
			System.out.println(d10);
	}
}