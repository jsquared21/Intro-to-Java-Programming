/*
(Game: add three numbers) The program in Listing 3.1, AdditionQuiz.java, generates
two integers and prompts the user to enter the sum of these two integers.
Revise the program to generate three single-digit integers and prompt the user to
enter the sum of these three integers.
*/
import java.util.Scanner;

public class Exercise_03_02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Generate three random integers 
		int digit1 = (int)(Math.random() * 10);
		int digit2 = (int)(Math.random() * 10);
		int digit3 = (int)(Math.random() * 10);

		// Prompt user to enter the sum of three integers
		System.out.print(
			"What is " + digit1 + " + " + digit2 + " + " + digit3 + "? ");
		int answer = input.nextInt();
		
		System.out.println(
			digit1 + " + " + digit2 + " + " + digit3 + " = " + answer + " is " +
			(digit1 + digit2 + digit3 == answer));
	}
}