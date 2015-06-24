/*********************************************************************************
* (Latin square) A Latin square is an n-by-n array filled with n different Latin *
* letters, each occurring exactly once in each row and once in each column.      *
* Write a program that prompts the user to enter the number n and the array of   *
* characters, as shown in the sample output, and checks if the input array is a  *
* Latin square. The characters are the first n characters starting from A.       *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_08_36 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		
		// Prompt the user to enter the number n
		System.out.print("Enter number n: "); 
		int n = input.nextInt();

		// Create an array of character of size n
		char[][] square = new char[n][n]; 


		// Prompt the user to enter characters
		System.out.println("Enter 4 rows of letters separated by spaces:");
		initializeSquare(square);
		
		// Display if square is a Latin square
		System.out.println("The array is" + 
			(isLatinSquare(square) ? " " : " not ") + "a Latin square");
	}

	/** isLatinSquare returns true if array is a latin square */
	public static boolean isLatinSquare(char[][] s) {
		return isDistinctRow(s) && isDistinctColumn(s);
	}

	/** isDistinctRow returns true if Latin letters,
		 each occur exactly once in each row */
	public static boolean isDistinctRow(char[][] s) {
		for (int i = 0; i < s.length; i++) {
			int[] counts = new int[s.length]; // Occurrence of each letter
			for (int j = 0; j < s[i].length; j++) {
				counts[s[i][j] - 65]++;
				if (counts[s[i][j] - 65] > 1)
					return false;
			}
		}
		return true;
	} 

	/** isDistinctColumn returns true if Latin letters,
		 each occur exactly once in each column */
	public static boolean isDistinctColumn(char[][] s) {
		for (int i = 0; i < s.length; i++) {
			int[] counts = new int[s[0].length]; // Occurrence of each letter
			for (int j = 0; j < s[i].length; j++) {
				counts[s[j][i] - 65]++;
				if (counts[s[j][i] - 65] > 1)
					return false;
			}
		}
		return true;
	}

	/** initializeSquare initializes the square with user input */
	public static void initializeSquare(char[][] square) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[i].length; j++) {
				String str = input.next();
				char ch = str.charAt(0);
				if (ch >= 'A' && ch < (char)('A' + square.length))
					square[i][j] = ch;
				else {
					System.out.println("Wrong input: the letters must be from A to " 
						+ (char)('A' + square.length - 1));
					System.exit(1);
				}
			}
		}
	}
}