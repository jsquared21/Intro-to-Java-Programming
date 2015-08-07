/*********************************************************************************
* (Convert decimals to fractions) Write a program that prompts the user to enter *
* a decimal number and displays the number in a fraction. Hint: read the decimal *
* number as a string, extract the integer part and fractional part from the      *
* string, and use the BigInteger implementation of the Rational class in         *
* Programming Exercise 13.15 to obtain a rational number for the decimal number. *
*********************************************************************************/
import java.math.BigInteger;
import java.util.Scanner;

public class Exercise_13_19 {
	/** Main method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a decimal number
		System.out.print("Enter a decimal number: ");
		String[] decimal = input.nextLine().split("[.]");

		// Create a Rational object of the integer part of the decimal number
		Rational r1 = new Rational(new BigInteger(decimal[0]), BigInteger.ONE);

		// Create a Rational object of the fractional part of the decimal number
		Rational r2 = new Rational(new BigInteger(decimal[1]), new BigInteger(
			String.valueOf((int)Math.pow(10, decimal[1].length()))));

		// Display fraction number
		System.out.println("The fraction number is " + 
			(decimal[0].charAt(0) == '-' ? (r1).subtract(r2) : (r1).add(r2)));
	}
}