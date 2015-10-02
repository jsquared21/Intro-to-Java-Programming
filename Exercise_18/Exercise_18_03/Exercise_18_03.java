/*********************************************************************************
* (Compute greatest common divisor using recursion) The gcd(m, n) can also be    *
* defined recursively as follows:                                                *
*                                                                                *
* ■ If m % n is 0, gcd(m, n) is n.                                               *
* ■ Otherwise, gcd(m, n) is gcd(n, m % n).                                       *
*                                                                                *
* Write a recursive method to find the GCD. Write a test program that prompts    *
* the user to enter two integers and displays their GCD.                         *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_18_03 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter two integers
		System.out.print("Enter two integers: ");
		int m = Integer.parseInt(input.next());
		int n = Integer.parseInt(input.next());

		// Calucate and display the GCD
		System.out.println("The greatest common divisor of " + m + " and " + n 
			+ " is " + gcd(m, n));
	}

	/** Method for computing GCD */
	private static int gcd(int m, int n) {
		if (m % n == 0)
			return n; // Base case
		else // Recursive call
			return gcd(n, m % n);
	}
}