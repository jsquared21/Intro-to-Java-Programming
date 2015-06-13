/*********************************************************************************
* (Computing gcd) Write a method that returns the gcd of an unspecified number   *
* of integers. The method header is specified as follows:                        *
* public static int gcd(int... numbers)                                          *
* Write a test program that prompts the user to enter five numbers, invokes the  *
* method to find the gcd of these numbers, and displays the gcd.                 *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_07_14 {
	/** Main method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Create a Scanner
		int[] numbers = new int[5]; // Create an array of length 5
		
		// Prompt the user to enter five numbers
		System.out.print("Enter five numbers: ");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextInt();
		}

		// Display the gcd
		System.out.println("The greatest common divisor is " + gcd(numbers));
	}

	/** Method gcd returns the gcd of an unspecified number of integers */
	public static int gcd(int... numbers) {
		int gcd = 1;			// Initial gcd is 1
		boolean isDivisor;	// Is number a diviser

		for (int i = 2; i < min(numbers); i++) {
			isDivisor = true;
			for (int e: numbers) {
				if (e % i != 0)
					isDivisor = false;
			}
			if (isDivisor)
				gcd = i;
		}
		return gcd;
	}

	/** Method min returns the smallest integer in an array */
	public static int min(int... numbers) {
		int min = numbers[0];
		for (int e: numbers) {
			if (e < min)
				min = e;
		}
		return min;
	}
}