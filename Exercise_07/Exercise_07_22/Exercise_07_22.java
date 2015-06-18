/*********************************************************************************
* (Game: Eight Queens) The classic Eight Queens puzzle is to place eight queens  *
* on a chessboard such that no two queens can attack each other (i.e., no two    *
* queens are on the same row, same column, or same diagonal). There are many     *
* possible solutions. Write a program that displays one such solution.           *
*********************************************************************************/
public class Exercise_07_22 {
	/** Main method */
	public static void main(String[] args) {
		char[] board; // Create an array

		// Repeat while queens are attacking
		do {
			// Generate a board
			board = getNewBoard();

			// Place eight queens
			placeQueens(board);

		} while (isAttacking(board));

		// Display solution
		print(board);
	}

	/** placeQueens randomly places eight queens on the board*/
	public static void placeQueens(char[] board) {
		int location;
		for (int i = 0; i < 8; i++) {
			do {
				location = placeQueens();
			} while (isOccupied(board[location]));
			board[location] = 'Q';
		}
	}

	/** placeQueens randomly places one queen on the board */
	public static int placeQueens() {
		return (int)(Math.random() * 64);
	}

	/** isAttacking returns true if two queens are attacking each other */
	public static boolean isAttacking(char[] board) {
		return isSameRow(board) || isSameColumn(board) ||  isSameDiagonal(board);
	}

	/** isSameRow returns true if two queens are in the same row */
	public static boolean isSameRow(char[] board) {
		int[] rows = new int[8];
		for (int i = 0; i < board.length; i++) {
			if (isOccupied(board[i])) {
				rows[getRow(i)]++;
			}	
			if (rows[getRow(i)] > 1) 
				return true;
		}
		return false;
	}

	/** isSameColumn returns true if two queens are in the same column */
	public static boolean isSameColumn(char[] board) {
		int[] columns = new int[8];
		for (int i = 0; i < board.length; i++) {
			if (isOccupied(board[i])) {
				columns[getColumn(i)]++;
			}	
			if (columns[getColumn(i)] > 1) 
				return true;
		}
		return false;
	}

	/** isSameDiagonal returns true if two queens are on the same diagonal */
	public static boolean isSameDiagonal(char[] board) {
		for (int i = 0; i < board.length; i++) {
			if (isOccupied(board[i])) {
				for (int j = 0; j < board.length; j++) {
					if (isOccupied(board[j]) && Math.abs(getColumn(j) - getColumn(i)) ==
					    Math.abs(getRow(j) - getRow(i)) && j != i) {
						return true;
					}
				}
			}	
		}
		return false;
	}

	/** isOccupied returns true if the element in x is the char Q */
	public static boolean isOccupied(char x) {
		return x == 'Q';
	}

	/** getNewBoard returns a char array filled with blank space */
	public static char[] getNewBoard() {
		char[] board = new char[64];
			for (int i = 0; i < board.length; i++)
				board[i] = ' ';
		return board;
	}

	/** print displays the board */
	public static void print(char[] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.print(
				"|" + ((getRow(i + 1) == 0) ? board[i] + "|\n" : board[i]));
		}
	}

	/** getRow returns the row number that corresponds to the given index */
	public static int getRow(int index) {
		return index % 8;
	}
 
	/** getColumn returns the column number that corresponds to the given index */
	public static int getColumn(int index) {
		return index / 8;
	}
}