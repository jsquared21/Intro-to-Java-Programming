/*********************************************************************************
* (Shuffle rows) Write a method that shuffles the rows in a two-dimensional int  *
* array using the following header:                                              *
*                                                                                *
* public static void shuffle(int[][] m)                                          *
*                                                                                *
* Write a test program that shuffles the following matrix:                       *
*                                                                                *
* int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};                         *
*********************************************************************************/
public class Exercise_08_18 {
	/** Main method */
	public static void main(String[] args) {
		// Initialize matrix
		int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};

		// Randomly shuffle the rows in the matrix
		shuffle(m);

		// Display the matrix
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

	/** shuffle shuffles the rows in a two-dimensional int array */
	public static void shuffle(int[][] m) {
		int[] temp = new int[2];

		for (int i = 0; i < m.length; i++) {
			// Generate random index
			int i1 = (int)(Math.random() * m.length);

			// Swap row i with row i1
			temp[0] = m[i][0];
			temp[1] = m[i][1];
			m[i][0] = m[i1][0];
			m[i][1] = m[i1][1];
			m[i1][0] = temp[0];
			m[i1][1] = temp[1];
		}
	}
}