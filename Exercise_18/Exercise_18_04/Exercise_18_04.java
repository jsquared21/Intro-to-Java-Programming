/*********************************************************************************
* (Sum series) Write a recursive method to compute the following series:         *
* 				m(i) = 1 + 1 / 2 + 1 / 3 + ... + 1 / i                               *
* Write a test program that displays m(i) for i = 1, 2, . . ., 10.               *
*********************************************************************************/
public class Exercise_18_04 {
	/** Main method */
	public static void main(String[] args) {
		// Display m(i) for i = 1 to 10
		System.out.println("\n i    m(i)");
		System.out.println("-----------");
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%2d%8.2f\n", i, m(i));
		}
	}

	/** Method for computing m(i) */
	private static double m(double i) {
		if (i == 1) // Base case
			return 1; 
		else
			return  1 / i + m(i - 1); // Recursive call
	}
}