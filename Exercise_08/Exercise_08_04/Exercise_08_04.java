/*********************************************************************************
* (Compute the weekly hours for each employee) Suppose the weekly hours for all  *
* employees are stored in a two-dimensional array. Each row records an employee’s*
* seven-day work hours with seven columns. For example, the following            *
* array stores the work hours for eight employees. Write a program that displays *
* employees and their total hours in decreasing order of the total hours.        *
*********************************************************************************/
public class Exercise_08_04 {
	/** Main method */
	public static void main(String[] args) {
		// Initialize 7-by-7 matrix with data
		int[][] weeklyHours = { {2, 4, 3, 4, 5, 8, 8},
										{7, 3, 4, 3, 3, 4, 4},
										{3, 3, 4, 3, 3, 2, 2},
										{9, 3, 4, 7, 3, 4, 1},
										{3, 5, 4, 3, 6, 3, 8},
										{3, 4, 4, 6, 3, 4, 4},
										{3, 7, 4, 8, 3, 8, 4},
										{6, 3, 5, 9, 2, 7, 9},};

		// Initialize 7-by-2 matrix with total hours of each employee
		int[][] totalHours = sumRows(weeklyHours);

		// Sort matrix in decreasing order of the total hours
		sort(totalHours);

		// Display results
		print(totalHours);
	}

	/** sumRows returns a matrix with the total of each row */
	public static int[][] sumRows(int[][] m) {
		// Create a 7-by-2 matrix
		int[][] totals = new int[m.length][2];

		for (int row = 0; row < m.length; row++) {
			totals[row][0] = row;
			totals[row][1] = 0;
			for (int col = 0; col < m[row].length; col++) {
				totals[row][1] += m[row][col];
			}	
		}
		return totals;
	}

	/** sort sorts a matrix in decreasing order of column 1 */
	public static void sort(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			// Find maximum of column 1
			int maxCol0 = m[i][0];
			int maxCol1 = m[i][1];
			int maxIndex = i;

			for (int j = i + 1; j < m.length; j++) {
				if (maxCol1 < m[j][1]) {
					maxCol1 = m[j][1];
					maxCol0 = m[j][0];
					maxIndex = j;
				}
			}

			// Swap
			if (i != maxIndex) {
				m[maxIndex][1] = m[i][1];
				m[maxIndex][0] = m[i][0];
				m[i][1] =  maxCol1;
				m[i][0] =  maxCol0;
			}
		}
	}

	/** print displays table of employees and their total hours */
	public static void print(int[][] m) {
		System.out.println("Employee     Weekly Hours");
		System.out.println("-------------------------");
		for (int row = 0; row < m.length; row++) {
				System.out.printf("%4d%16d\n", m[row][0], totalHours[row][1]);
		}	
	}
}