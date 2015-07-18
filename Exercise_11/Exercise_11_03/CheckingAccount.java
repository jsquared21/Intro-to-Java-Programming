/***************************************************************************
*                              CheckingAccount                             *
*--------------------------------------------------------------------------*
* -overdraftLimit: double                                                  *
* +CheckingAccount()                                                       *
* +CheckingAccount(newId: int, newBalance: double, overdraftLimit: double) *
* +setOverdraftLimit(overdraftLimit: double): void                         *
* +getOverdraftLimit(): double                                             *
* +withdraw(amount: double): boolean                                       *
* +toString(): String                                                      *
****************************************************************************/
// Implement Checking class
public class CheckingAccount
		extends Account {
	// Data fields
	private double overdraftLimit;

	/** Construct a default CheckingAccount object */
	public CheckingAccount() {
		super();
		overdraftLimit = -20;
	}

	/** Construct a CheckingAccout with specified id, balance and overdraftLimit */
	public CheckingAccount(int id, double balance, double overdraftLimit) {
		super(id, balance);
		this.overdraftLimit = overdraftLimit;
	}

	/** Set a new overdraft limit */
	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	/** Return overdraft limit */
	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	/** Decrease balance by amount */
	public void withdraw(double amount) {
		if (getBalance() - amount > overdraftLimit) {
			setBalance(getBalance() - amount);
		}
		else
			System.out.println("Error! Amount exceeds overdraft limit.");
	}

	/** Return a String decription of CheckingAccount class */
	public String toString() {
		return super.toString() + "\nOverdraft limit: $" + 
		String.format("%.2f", overdraftLimit);
	}
}