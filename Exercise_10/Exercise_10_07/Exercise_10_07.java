/*********************************************************************************
* (Game: ATM machine) Use the Account class created in Programming Exercise      *
* 9.7 to simulate an ATM machine. Create ten accounts in an array with id        *
* 0, 1, . . . , 9, and initial balance $100. The system prompts the user to      *
* enter an id. If the id is entered incorrectly, ask the user to enter a correct *
* id. Once an id is accepted, the main menu is displayed as shown in the sample  *
* run. You can enter a choice 1 for viewing the current balance, 2 for           *
* withdrawing money, 3 for depositing money, and 4 for exiting the main menu.    *
* Once you exit, the system will prompt for an id again. Thus, once the system   *
* starts, it will not stop.                                                      *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_10_07 {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Create ten accounts in an array
		Account[] accounts = new Account[10];

		// Initialize accounts with balance
		initialBalance(accounts);
		
		// Once the system starts, it will not stop
		do {
			// Prompt user to enter an id
			System.out.print("Enter an id: ");
			int id = input.nextInt();

			if (isValidID(id, accounts)) {
				int choice;
				do {	
					// Get user choice
					choice = displayMainMenu(input);
					if (isTransaction(choice)) {
							executeTransaction(choice, accounts, id, input);
					}
				} while (choice != 4); // If 4 exit main menu
			}
			// Once you exit, the system will prompt for an id again
		} while (true); 
	}

	/** Initialize accounts with balance of 100 */
	public static void initialBalance(Account[] a) {
		int initialBalance = 100;
		for (int i = 0; i < a.length; i++) {
			a[i] = new Account(i, initialBalance);
		}
	}

	/** Return true if choice is a transaction */
	public static boolean isTransaction(int choice) {
		return choice > 0 && choice < 4;
	}

	/** Return true if ID is valid */
	public static boolean isValidID(int id, Account[] a) {
		for (int i = 0; i < a.length; i++) {
			if (id == a[i].getId())
				return true;
		}
		return false;
	}

	/** Display main menu */
	public static int displayMainMenu(Scanner input) {
		System.out.print(
			"\nMain menu\n1: check balance\n2: withdraw" +
			"\n3: deposit\n4: exit\nEnter a choice: ");
		return input.nextInt();
	}

	/** Execute a Transaction */
	public static void executeTransaction(
		int c, Account[] a, int id, Scanner input) {
		switch (c) {
			case 1: // Viewing the current balance
					  System.out.println("The balance is " + a[id].getBalance());
					  break;
			case 2: // Withdraw money
					  System.out.print("Enter an amount to withdraw: "); 
					  a[id].withdraw(input.nextDouble());
					  break;
			case 3: // Deposit money
					  System.out.print("Enter an amount to deposit: "); 
					  a[id].deposit(input.nextDouble());
		}
	}
}