/*
(Compute e) You can approximate e using the following series:

		e = 1 + 1 / 1! + 1 / 2! + 1 / 3! + 1 / 4! + ... + 1 / i!

Write a program that displays the e value for i = 10000, 20000, …, and
100000. (Hint: Because i! = i * (i - 1) * c * 2 * 1, then

		1 / i! is 1 / (i(i - 1)!)

Initialize e and item to be 1 and keep adding a new item to e. The new item is
the previous item divided by i for i = 2, 3, 4, ....)
*/
public class Exercise_05_26 {
	public static void main(String[] args) {
		double e = 0.0,
				 value = 10000.0;
		// Compute e value for i = 10000
		for (double i = 1; i <= value; i++) {
			double denominator = i;
			for (double k = i - 1; k >= 1; k--) {
				denominator *= k;
			}
			e += 1 / denominator;  
		}

		// Display result
		System.out.println("The e value for i = 10000: " + e);

		// Compute e value for i = 20000
		e = 0.0;
		value = 20000.0;
		for (double i = 1; i <= value; i++) {
			double denominator = i;
			for (double k = i - 1; k >= 1; k--) {
				denominator *= k;
			}
			e += 1 / denominator;  
		}

		// display result
		System.out.println("The e value for i = 20000: " + e);

		// Compute e value for i = 100000
		e = 0.0;
		value = 100000.0;
		for (double i = 1; i <= value; i++) {
			double denominator = i;
			for (double k = i - 1; k >= 1; k--) {
				denominator *= k;
			}
			e += 1 / denominator;  
		}

		// Display result
		System.out.println("The e value for i = 100000: " + e);
	}
}