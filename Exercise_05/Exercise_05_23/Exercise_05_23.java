/* 
(Demonstrate cancellation errors) A cancellation error occurs when you are
manipulating a very large number with a very small number. The large number
may cancel out the smaller number. For example, the result of 100000000.0 +
0.000000001 is equal to 100000000.0. To avoid cancellation errors and obtain
more accurate results, carefully select the order of computation. For example, in
computing the following series, you will obtain more accurate results by computing
from right to left rather than from left to right:

1 + 1 / 2 +  1 / 3 + ... +  1 / n

Write a program that compares the results of the summation of the preceding
series, computing from left to right and from right to left with n = 50000.
*/
public class Exercise_05_23 {
	public static void main(String[] args) {
		// Compute series from left to right
		double sumLeftToRight = 0.0;
		for (double i = 1.0; i <= 50000.0; i++) {
			sumLeftToRight += 1 / i;
		}

		// Display result of series sum from left to right
		System.out.println("Summation of series left to right: " + sumLeftToRight);
		
		// Compute series from right to left
		double sumRightToLeft = 0.0;
		for (double i = 50000.0; i >= 1.0; i--) {
			sumRightToLeft += 1 / i;
		}

		// Display result of series sum from right to left
		System.out.println("Summation of series right to left: " + sumRightToLeft);

		// Compare the results
		System.out.println("Summation of the series right to left - "
			+ "Summation of the series left to right: " 
			+ (sumRightToLeft - sumLeftToRight));
	}
}