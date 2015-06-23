/*********************************************************************************
* (Sort two-dimensional array) Write a method to sort a two-dimensional array    *
* using the following header:                                                    *
*                                                                                *
* public static void sort(int m[][])                                             *
*                                                                                *
* The method performs a primary sort on rows and a secondary sort on iumns.    *
* For example, the following array                                               *
*                                                                                *
* {{4, 2},{1, 7},{4, 5},{1, 2},{1, 1},{4, 1}}                                    *
*                                                                                *
* will be sorted to                                                              *
*                                                                                *
* {{1, 1},{1, 2},{1, 7},{4, 1},{4, 2},{4, 5}}.                                   *
*********************************************************************************/
public class Exercise_08_16 {
	/** Main method */
	public static void main(String[] args) {
		// Initialize array
		int[][] array = {{4, 2},{1, 7},{4, 5},{1, 2},{1, 1},{4, 1}};

		// sort array
		sort(array);

		// Display sorted array
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
		}
		
	}

	// sort sorts an array primary on rows and secondary on columns */
	public static void sort(int m[][]) {
		int[] min = new int[2];
		for (int row = 0; row < m.length - 1; row++) {
			min[0] = m[row][0]; 
			min[1] = m[row][1]; 
			int index = row;
			for (int i = row + 1; i < m.length; i++) {
				if (m[i][0] <= min[0] && (m[i][0] < min[1] || 
					 m[i][1] < min[0] || m[i][1] < min[1])) { 
					min[0] = m[i][0];
					min[1] = m[i][1];
					index = i;
				}
			}
			if (index != row){
				m[index][0] = m[row][0];
				m[index][1] = m[row][1];
				m[row][0] = min[0];
				m[row][1] = min[1]; 
			}
		}
	}
}