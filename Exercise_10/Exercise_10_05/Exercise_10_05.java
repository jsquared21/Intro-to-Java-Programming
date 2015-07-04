/*********************************************************************************
* (Displaying the prime factors) Write a program that prompts the user to enter  *
* a positive integer and displays all its smallest factors in decreasing order.  *
* For example, if the integer is 120, the smallest factors are displayed as      *
* 5, 3, 2, 2, 2. Use the StackOfIntegers class to store the factors              *
* (e.g., 2, 2, 2, 3, 5) and retrieve and display them in reverse order.          *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_10_05 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a positive integer
		System.out.print("Enter a positive integer: ");
		int number = input.nextInt();

		// Displays all the number's smallest factors in decreasing order
		System.out.print("The smallest factors of " + number + " are: ");
		StackOfIntegers stack = new StackOfIntegers(); // Create a StackOfIntegers

		smallestFactors(number, stack);

		while (!stack.empty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}

	/** Find smallestFactors and push them to StackOfIntegers */
	public static void smallestFactors(int number, StackOfIntegers stack) {
		int i = 2; // Potential prime factor
		while (number / i != 1){ 
			if (number % i == 0) {
				stack.push(i);
				number /= i;
			}
			else
				i++;
		}
		stack.push(number);
	}
}