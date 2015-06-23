/*********************************************************************************
* (Even number of 1s) Write a program that generates a 6-by-6 two-dimensional    *
* matrix filled with 0s and 1s, displays the matrix, and checks if every row and *
* every column have an even number of 1s.                                        *
*********************************************************************************/
public class Exercise_08_22 {
	/** Main method */
	public static void main(String[] args) {
		int[][] matrix = int[6][6];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int)(Math.random() * 2);
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("Every row and every column" + 
			(isRowsAndColumnsEven1s(matrix) ? " " : " does not " + 
				"have an even number of 1s"));
	}

	/** isRowsAndColumnsEven1s */
	public static boolean isRowsAndColumnsEven1s(int[][] m) {
		return isAllRowsEven1s(m) && isAllColumnsEven1s(m);
	}

	/** isAllRowsEven1s */
	public static boolean isAllRowsEven1s(int[][] m) {
		int count = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == 1)
					count++;
			}
			if (count % 2 != 0)
				return false;
		}
		return true;
	}

	/** isAllColumnsEven1s */
	public static boolean isAllColumnsEven1s(int[][] m) {
		int count = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[j][i] == 1)
					count++;
			}
			if (count % 2 != 0)
				return false;
		}
		return true;
	}
}