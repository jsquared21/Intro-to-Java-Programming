/*********************************************************************************
* (Sum series) Write a recursive method to compute the following series:         *
*                                                                                *
*   m(i) = 1 / 3 + 2 / 5 + 3 / 7 + 4 / 9 + 5 / 11 + 6 / 13 + ... + i / (2i + 1)  *
*                                                                                *
* Write a test program that displays m(i) for i = 1, 2, . . ., 10.               *
*********************************************************************************/
public class Exercise_18_05 {
	/** Main method */
	public static void main(String[] args) {
		// Display m(i) for i = 1 - 10
		System.out.println("\n i    m(i)");
		System.out.println("-----------");
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%2d%8.2f\n", i, m(i));
		}
	}

	/** Method for computing m(i) */
	private static double m(double i) {
		if (i == 0) // Base case
			return 0;
		else
			return i / (2 * i + 1) + m(i - 1); // Recursive call
	}
}