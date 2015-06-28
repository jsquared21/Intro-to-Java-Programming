public class Exercise_09_07 {
	/** Main method */
	public static void main(String[] args) {
		// Create an Account object with an account
		// ID of 1122, and a balance of $20,000
		Account account = new Account(1122, 20000);

		// Set annual interest rate of 4.5%
		account.setAnnualInterestRate(4.5);

		// Withdraw $2,500
		account.withdraw(2500);

		// Deposit $3,000
		account.deposit(3000);

		// Display the balance, the monthly interest, 
		// and the date when this account was created
		System.out.println("\n          Account Statement");
		System.out.println("------------------------------------------");
		System.out.println("Account ID: " + account.getId());
		System.out.println("Date created: " + account.getDateCreated());
		System.out.printf("Balance: $%.2f\n", account.getBalance());
		System.out.printf("Monthly interest: $%.2f\n", 
			account.getMonthlyInterest());
	}
}