
/* (Financial: credit card number validation) Credit card numbers follow certain patterns.
* A credit card number must have between 13 and 16 digits. It must start with:
*
* ■ 4 for Visa cards
* ■ 5 for Master cards
* ■ 37 for American Express cards
* ■ 6 for Discover cards
*
* In 1954, Hans Luhn of IBM proposed an algorithm for validating credit card
* numbers. The algorithm is useful to determine whether a card number is entered
* correctly or whether a credit card is scanned correctly by a scanner. Credit card
* numbers are generated following this validity check, commonly known as the
* Luhn check or the Mod 10 check, which can be described as follows (for illustration,
* consider the card number 4388576018402626):
*
* 1. Double every second digit from right to left. If doubling of a digit results in a
*    two-digit number, add up the two digits to get a single-digit number.
*
* 2. Now add all single-digit numbers from Step 1.
*                 4 + 4 + 8 + 2 + 3 + 1 + 7 + 8 = 37
*
* 3. Add all digits in the odd places from right to left in the card number.
*                 6 + 6 + 0 + 8 + 0 + 7 + 8 + 3 = 38
*
* 4. Sum the results from Step 2 and Step 3.
*                 37 + 38 = 75
*
* 5. If the result from Step 4 is divisible by 10, the card number is valid; otherwise,
*    it is invalid. For example, the number 4388576018402626 is invalid, but the
*    number 4388576018410707 is valid.
*
* Write a program that prompts the user to enter a credit card number as a long
* integer. Display whether the number is valid or invalid. Design your program to
* use the following methods: 
*
*         /** Return true if the card number is valid 
*         public static boolean isValid(long number)
*
*         /** Get the result from Step 2 */
/*         public static int sumOfDoubleEvenPlace(long number)
*
*         /** Return this number if it is a single digit, otherwise,
*         * return the sum of the two digits */
/*         public static int getDigit(int number)
*
*         /** Return sum of odd-place digits in number */
/*         public static int sumOfOddPlace(long number)
*
*         /** Return true if the digit d is a prefix for number */
/*         public static boolean prefixMatched(long number, int d)
*
*         /** Return the number of digits in d */
/*         public static int getSize(long d)
*
*         /** Return the first k number of digits from number. If the
*         * number of digits in number is less than k, return number. */
/*         public static long getPrefix(long number, int k)
*/

import java.util.Scanner;

public class Exercise_06_31 {
	/** Main Method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Create a Scanner

		// Prompt the user to enter a credit card number as a long integer
		System.out.print("Enter a credit card number as a long integer: ");
		long number = input.nextLong();

		System.out.println(
			number + " is " + (isValid(number) ? "valid" : "invalid"));
	}

	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		boolean valid =
			(getSize(number) >= 13 && getSize(number) <= 16) &&
			(prefixMatched(number, 4) || prefixMatched(number, 5) ||
			prefixMatched(number, 37) || prefixMatched(number, 6)) &&
			((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);

		return valid;
	}
	
	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		int sum = 0;
		String num = number + "";
		for (int i = getSize(number) - 2; i >= 0; i -= 2) {
			sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
		}
		return sum;
	}
	
	/** Return this number if it is a single digit, otherwise,
	* return the sum of the two digits */
	public static int getDigit(int number) {
		if (number < 9)
			return number;
		else
			return number / 10 + number % 10;
	}
	
	/** Return sum of odd-place digits in number */
	public static int sumOfOddPlace(long number) {
		int sum = 0;
		String num = number + "";
		for (int i = getSize(number) - 1; i >= 0; i -= 2) {
			sum += Integer.parseInt(num.charAt(i) + "");
		}
		return sum;
	}
	
	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d) {
		return getPrefix(number, getSize(d)) == d;
	}
	
	/** Return the number of digits in d */
	public static int getSize(long d) {
		String num = d + "";
		return num.length();
	}
	
	/** Return the first k number of digits from number. If the
	* number of digits in number is less than k, return number. */
	public static long getPrefix(long number, int k) {
		if (getSize(number) > k)  {
			String num = number + "";
			return  Long.parseLong(num.substring(0, k));
		}
		return number;
	}
}
