/*********************************************************************************
* (Sum series) Write a recursive method to compute the following series:         *
*                                                                                *
*                 m(i) = 1 / 2 + 2 / 3 + ... + i / (i + 1)                       *
*                                                                                *
* Write a test program that displays m(i) for i = 1, 2, . . ., 10.               *
*********************************************************************************/
public class Exercise_18_06 {
	/** Main method */
	public static void main(String[] args) {
		// Display m(i) for i = 1 - 10
		System.out.println("\n i    m(i)");
		System.out.println("-----------");
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%2d%8.2f\n", i, m(i));
		}
	}

	/** Method to compute m(i) */
	private static double m(double i) {
		if (i <= 0) // Base case
			return 0;
		else 
			return i / (i + 1) + m(i - 1); // Recursive call
	}
}