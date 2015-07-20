/*********************************************************
*                     Account                            *
*--------------------------------------------------------*
* -name: String                                          *
* -id: int                                               *
* -balance: double                                       *
* -annualInterestRate: double                            *
* ---------------------------                            *
* -dateCreated: String                                   *
* -transactions: ArrayList<Transaction>                  *
* +Account()                                             *
* +Account(id: int, balance: double)               *
* +Account(name: String, id: int, balance: double) *
* +setId(id: int)                                     *
* +setBalance(balance: double)                        *
* +setAnnualInterestRate(annualInterestRate: double)  *
* +getId(): int                                          *
* +getBalance(): double                                  *
* +getAnnualInterestRate(): double                       *
* +getDateCreated(): String                              *
* +getMonthlyInterestRate(): double                      *
* +getMonthlyInterest(): double                          *
* +withdraw(amount: double)                              *
* +deposit(amount: double)                               *
*********************************************************/

// Implement the Account class
import java.util.Date;
import java.util.ArrayList;

public class Account {
	// Data fields
	private String name;
	private int id;
	private double balance;
	private static double annualInterestRate;
	private Date dateCreated;
	private ArrayList<Transaction> transactions;

	// Constructors
	/** Creates a default account */
	Account() {
		name = "";
		id = 0;
		balance = 0;
		annualInterestRate = 0;
		dateCreated = new Date(); 
		transactions = new ArrayList<Transaction>();
	}

	/** Creates an account with the specified id and initial balance */
	Account(int id, double balance) {
		name = "";
		this.id = id;
		this.balance = balance;
		dateCreated = new Date();
		transactions = new ArrayList<Transaction>();
	}

	/** Creates an account with the specified 
	  * name,id and initial balance */
	Account(String name, int id, double balance) {
		this(id, balance);
		this.name = name;
	}

	// Mutator methods
	/** Set new name */
	public void setName(String name) {
		this.name = name;
	}

	/** Return name */
	public String getName() {
		return name;
	}
	/** Set id */
	public void setId(int id) {
		this.id = id;
	}

	/** Set balance */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/** Set annualInterestRate */
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	// Accessor methods
	/** Return id */
	public int getId() {
		return id;
	}

	/** Return balance */
	public double getBalance() {
		return balance;
	}

	/** Return annualInterestRate */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	/** Return dateCreated */
	public String getDateCreated() {
		return dateCreated.toString();
	}

	/** Return monthly interest rate */
	public double getMonthlyInterestRate() {
		return annualInterestRate / 12;
	}

	// Methods
	/** Return monthly interest */
	public double getMonthlyInterest() {
		return balance * (getMonthlyInterestRate() / 100);
	}

	/** Decrease balance by amount */
	public void withdraw(double amount) {
		balance -= amount;
		transactions.add(new Transaction('W', amount, balance, 
			"Withdrawal from account"));
	}

	/** Increase balance by amount */
	public void deposit(double amount) {
		balance += amount;
		transactions.add(new Transaction('D', amount, balance, 
			"Deposit to account"));
	}

	/** Return transactions */
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
}