/*********************************************************************************
* (Sum the major diagonal in a matrix) Write a method that sums all the numbers  *
* in the major diagonal in an n * n matrix of double values using the following  *
* header:                                                                        *
*                                                                                *
* public static double sumMajorDiagonal(double[][] m)                            *
*                                                                                *
* Write a test program that reads a 4-by-4 matrix and displays the sum of all    *
* its elements on the major diagonal.                                            *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_08_02 {
	/** Main method */
	public static void main(String[] args) {
		// Create a 4-by-4 matrix
		double[][] matrix = getMatrix();

		// Display the sum the major diagonal
		System.out.println("Sum of the elements in the major diagonal is " + 
			sumMajorDiagonal(matrix));
	}

	/** getMatrix returns a matrix initialized with user input */
	public static double[][] getMatrix() {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Create a 4-by-4 matrix
		final int ROWS = 4;
		final int COLUMNS = 4;
		double[][] m = new double[ROWS][COLUMNS];
		
		// Prompt user to enter a 4-by-4 matrix
		System.out.println("Enter a 4-by-4 matrix row by row:");
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				m[row][col] = input.nextDouble(); 
			}
		}
		return m;
	}

	/** sumMajorDiagonal returns the sum of all 
	    the matrix elemets on the major diagonal */
	public static double sumMajorDiagonal(double[][] m) {
		double sum = 0;
		for (int i = 0; i < m.length; i++) {
			sum += m[i][i];
		}
		return sum;
	}
}