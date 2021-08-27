/*
(Math: approximate the square root) There are several techniques for implementing
the sqrt method in the Math class. One such technique is known as the
Babylonian method. It approximates the square root of a number, n, by repeatedly
performing a calculation using the following formula:


nextGuess = (lastGuess + n / lastGuess) / 2

When nextGuess and lastGuess are almost identical, nextGuess is the
approximated square root. The initial guess can be any positive value (e.g., 1).
This value will be the starting value for lastGuess. If the difference between
nextGuess and lastGuess is less than a very small number, such as 0.0001,
you can claim that nextGuess is the approximated square root of n. If not, next-
Guess becomes lastGuess and the approximation process continues. Implement
the following method that returns the square root of n.
public static double sqrt(long n)
*/
import java.util.Scanner;

public class Exercise_06_22 {
	/** Main Method */
	public class Bolum6_22_YaklasikKarakök {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number.");
		long n = input.nextLong();
		sgrt(n);
	}

	public static double sgrt(long n) {
		double lastGuess = 1;
		double nextGuess = (lastGuess + n / lastGuess) / 2;
		double m = n;
		while (n == m) {
			lastGuess = nextGuess;
			nextGuess = (lastGuess + n / lastGuess) / 2;
			if (nextGuess - lastGuess == 0.0) {
				System.out.println(n + " is result sgrt: " + nextGuess);
				m++;
			}

		}
		return n;
	}
}
