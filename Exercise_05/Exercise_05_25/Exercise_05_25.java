/*
(Compute p) You can approximate p by using the following series:
PI = 4(1 - 1 / 3 + 1 / 5 - 1 / 7 + 1 / 9 - 1 / 11 + ... + ((-1)i + 1 /  2i - 1))
Write a program that displays the p value for i = 10000, 20000, …, and
100000.
*/
public class Exercise_05_25 {
	public static void main(String[] args) {
		// Compute PI value for i = 10000, 
		double sum = 0;
		double value = 10000.0;
		for (double d = 1; d <= (2 * value - 1); d += 2) {
			sum += 1 / d;
			d += 2;
			sum -= 1 / d; 
		}
		double pi = 4 * sum;

		// Display result
		System.out.println("PI value for i = 10000: " + pi);

		// Compute PI value for i = 20000,
		sum = 0;
		value = 20000.0;
		for (double d = 1; d <= (2 * value - 1); d += 2) {
			sum += 1 / d;
			d += 2;
			sum -= 1 / d; 
		}
		pi = 4 * sum;

		// Display result
		System.out.println("PI value for i = 20000: " + pi);

		// Compute PI value for i = 20000,
		sum = 0;
		value = 100000.0;
		for (double d = 1; d <= (2 * value - 1); d += 2) {
			sum += 1 / d;
			d += 2;
			sum -= 1 / d; 
		}
		pi = 4 * sum;

		// Display result
		System.out.println("PI value for i = 100000: " + pi);
	}
}