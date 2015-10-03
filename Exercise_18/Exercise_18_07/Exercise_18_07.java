/*********************************************************************************
* (Fibonacci series) Modify Listing 18.2, ComputeFibonacci.java, so that the     *
* program finds the number of times the fib method is called. (Hint: Use a       *
* static variable and increment it every time the method is called.)             *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_18_07 {
	// Count the number of times the fib method is called
	public static int count = 0;

	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an index for a Fibonacci number: ");
		int index = input.nextInt();

		// Find and display the Fibonacci number
		System.out.println("The Fibonacci number at index " 
			+ index + " is " + fib(index));

		// Display the number of times fib(index) is called
		System.out.println("The fib method was called "
			+ count + (count == 1 ? " time." : " times."));
	}

	/** The method for finding the Fibonacci number */
	public static long fib(long index) {
		count++; // Increment count

		if (index == 0) // Base case
			return 0;
		else if (index == 1) // Base case
			return 1;
		else // Reduction and recursive calls
			return fib(index - 1) + fib(index - 2);
	}
}