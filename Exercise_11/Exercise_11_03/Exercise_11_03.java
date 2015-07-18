/*********************************************************************************
* (Subclasses of Account) In Programming Exercise 9.7, the Account class was     *
* defined to model a bank account. An account has the properties account number, *
* balance, annual interest rate, and date created, and methods to deposit and    *
* withdraw funds. Create two subclasses for checking and saving accounts. A      *
* checking account has an overdraft limit, but a savings account cannot be       *
* overdrawn.                                                                     *
*                                                                                *
* Draw the UML diagram for the classes and then implement them. Write            *
* a test program that creates objects of Account, SavingsAccount, and            *
* CheckingAccount and invokes their toString() methods.                          *
*********************************************************************************/
public class Exercise_11_03 {
	// Main method
	public static void main(String[] args) {
		// Create Account, SavingsAccount and Checking Account objects
		Account account = new Account(1122, 20000);
		SavingsAccount savings = new SavingsAccount(1001, 20000);
		CheckingAccount checking = new CheckingAccount(1004, 20000, -20);
		// Set annual interest rate of 4.5%
		account.setAnnualInterestRate(4.5);
		savings.setAnnualInterestRate(4.5);
		checking.setAnnualInterestRate(4.5);

		// Withdraw $2,500
		account.withdraw(2500);
		savings.withdraw(2500);
		checking.withdraw(2500);

		// Deposit $3,000
		account.deposit(3000);
		savings.deposit(3000);
		checking.deposit(3000);

		// Invoke toString methods
		System.out.println(account.toString());
		System.out.println(savings.toString());
		System.out.println(checking.toString());
	}
}