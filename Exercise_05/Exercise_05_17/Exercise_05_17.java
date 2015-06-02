/*
(Display pyramid) Write a program that prompts the user to enter an integer from
1 to 15 and displays a pyramid, as shown in the following sample run:
*/
import java.util.Scanner;

public class Exercise_05_17 {
	public static void main(String[] args) {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter an integer from 1 to 15
		System.out.print("Enter the number of lines: ");
		int numberOfLines = input.nextInt();

		// Display pyramid
		for (int rows = 1; rows <= numberOfLines; rows++) {
			// Create spaces in each row
			for (int s = numberOfLines - rows; s >= 1; s--) {
				System.out.print("  ");
			}
			// Create decending numbers in each row
			for (int l = rows; l >= 2; l--) {
				System.out.print(l + " ");
			}
			// Create ascending number in each row
			for (int r = 1; r <= rows; r++) {
				System.out.print(r + " ");
			}
			// End line
			System.out.println();
		}
	}
}