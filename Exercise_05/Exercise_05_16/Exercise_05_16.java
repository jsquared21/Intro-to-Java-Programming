/*
(Find the factors of an integer) Write a program that reads an integer and displays
all its smallest factors in increasing order. For example, if the input integer is
120, the output should be as follows: 2, 2, 2, 3, 5.
*/
import java.util.Scanner;

public class Exercise_05_16 {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter an integer
		System.out.print("Enter an integer: ");
		int number = input.nextInt();
		int index = 2; // Numbers to test as factors 

		// Find and display all the smallest factors in increasing order
		while (number / index != 1) {
			// Test as a factor of number
			if (number % index  == 0) {
				System.out.print(index + ", ");
				number /= index; 
			}
			else
				index++; // Increment index
		}
		System.out.println(number + ".");
	}
}