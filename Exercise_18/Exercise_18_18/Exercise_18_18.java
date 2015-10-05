/**********************************************************************************
* (Tower of Hanoi) Modify Listing 18.8, TowerOfHanoi.java, so that the program    *
* finds the number of moves needed to move n disks from tower A to tower B.       *
* (Hint: Use a static variable and increment it every time the method is called.) *
**********************************************************************************/
import java.util.Scanner;

public class Exercise_18_18 {
	public static int numberOfMoves = 0;
	/** Main Method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of disks: ");
		int n = input.nextInt();

		// Find the solution recursively
		System.out.println("The move are:");
		moveDisks(n, 'A', 'B', 'C');

		// Display the number of moves needed to move the disks
		System.out.println(numberOfMoves + " moves are needed to move " 
			+ n + " disks from tower A to tower B.");
	}

	/** The method for finding the solution to move n disks
		 from fromTower to toTower with auxTower */
	public static void moveDisks(int n, char fromTower,
		char toTower, char auxTower) {
		numberOfMoves++; // Increment numberOfMoves
		if (n == 1) // Stopping condition
			System.out.println("Move disk " + n + " from " +
				fromTower + " to " + toTower);
		else {
			moveDisks(n - 1, fromTower, auxTower, toTower);
			System.out.println("Move disk " + n + " from " +
				fromTower + " to " + toTower);
			moveDisks(n - 1, auxTower, toTower, fromTower);
		}
	}
}