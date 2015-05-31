/*
(Random character) Write a program that displays a random uppercase letter
using the Math.random() method.
*/
public class Exercise_04_16 {
	public static void main(String[] args) {
		// Generate a random number between 65 and 90
		int number = 65 + (int)(Math.random() * (91 - 65));

		// Display a random uppercase letter
		System.out.println((char)(number));
	}
}