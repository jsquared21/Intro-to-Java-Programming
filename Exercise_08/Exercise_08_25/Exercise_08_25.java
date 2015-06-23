/*********************************************************************************
* (Markov matrix) An n * n matrix is called a positive Markov matrix if each     *
* element is positive and the sum of the elements in each column is 1. Write the *
* following method to check whether a matrix is a Markov matrix.                 *
*                                                                                *
* public static boolean isMarkovMatrix(double[][] m)                             *
*                                                                                *
* Write a test program that prompts the user to enter a 3 * 3 matrix of double   *
* values and tests whether it is a Markov matrix.                                *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_08_25 {
	/** Main method */
	public static void main(String[] args) {
		// Generate a 3 x 3 matrix of user input
		double[][] matrix = getMatrix();

		// Test if matrix is a Markov matrix
		System.out.println("It is" + (isMarkovMatrix(matrix) ? " " : " not ") +
			"a Markov matrix");
	}

	/** getMatrix return a 3-by-3 matrix filled with user input */
	public static double[][] getMatrix() {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Create a 3-by-3 matrix
		double[][] m = new double[3][3];

		// Prompt ther user to enter a 3 x 3 matrix
		System.out.println("Enter a 3-by-3 matrix row by row:");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = input.nextDouble();
			}
		}
		return m;
	}

	/** isMarkovMatrix returns true if matrix is a positive Markov matrix */
	public static boolean isMarkovMatrix(double[][] m) {
		return isElementsPositive(m) && isEachColumnSum1(m);
	}

	/** isElementsPositive returns true if each 
	    element in the matrix is positive */
	public static boolean isElementsPositive(double[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] < 0)
					return false;
			}
		}
		return true;
	}

	/** isEachColumnSum1 returns true if the 
	    sum of the elements in each column is 1 */
	public static boolean isEachColumnSum1(double[][] m) {
		for (int col = 0; col < m.length; col++) {
			double sum = 0; // Sum of each column
			for (int row = 0; row < m.length; row++) {
				sum += m[row][col];
			}
			if (sum != 1)
				return false;
		}
		return true;
	}
}