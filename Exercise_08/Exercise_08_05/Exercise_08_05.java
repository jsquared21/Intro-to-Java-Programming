/*********************************************************************************
* (Algebra: add two matrices) Write a method to add two matrices. The header of  *
* the method is as follows:                                                      *
*                                                                                *
* public static double[][] addMatrix(double[][] a, double[][] b)                 *
*                                                                                *
* In order to be added, the two matrices must have the same dimensions and the   *
* same or compatible types of elements. Let c be the resulting matrix. Each      *
* element cij is aij + bij.                                                      *
* Write a test program that prompts the user to enter two 3 * 3 matrices and     *
* displays their sum.                                                            *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_08_05 {
	/** Main method */
	public static void main(String[] args) {
		// Initialize two 3 x 3 matrices
		double[][] matrix1 = getmatrix(1);
		double[][] matrix2 = getmatrix(2);

		// Initialize matrix3 with the sum of matrix1 and matrix2
		double[][] matrix3 = addMatrix(matrix1, matrix2);

		// Display matrix1, matrix2 and matrix3
		print(matrix1, matrix2, matrix3);
	}

	/** getmatrix */
	public static double[][] getmatrix(int n) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a 3 x 3 matrix
		System.out.print("Enter matrix" + n + ": ");

		double[][] m = new double[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				m[i][j] = input.nextDouble();
		}

		return m;
	}

	/** addMatrix adds two matrices and returns the result */
	public static double[][] addMatrix(double[][] a, double[][] b) {
		double[][] c = new double[3][3];

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}

	/** print displays all the elements in row r */
	public static void print(double[][] m, int r) {	
		for (int j = 0; j < m[r].length; j++) {
			System.out.print(m[r][j] + " ");
		}	
	}

	/** print displays results */
	public static void print(double[][] m1, double[][] m2, double[][] m3) {
		System.out.println("The matrices are added as follows");
		
		for (int i = 0; i < 3; i++) {
			print(m1, i);
			System.out.print((i == 1 ? "  +  " : "     "));
			print(m2, i);
			System.out.print((i == 1 ? "  =  " : "     "));
			print(m3, i);
			System.out.println();
		}
	}
}
