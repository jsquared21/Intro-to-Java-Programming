public class Transaction {
	// Data fields
	private java.util.Date date;
	private char type;
	private double amount;
	private double balance;
	private String description;

	// Constructors
	/** Construts a Transaction with specified 
	  * date, type, balance and description */
	public Transaction(char type, double amount, 
		double balance, String description) {
		date = new java.util.Date();
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;
	}

	// Methods
	/** getDate */
	public String getDate() {
		return date.toString();
	}
	/** Set a new type */
	public void setType(char type) {
		this.type = type;
	}

	/** Return type */
	public char getType() {
		return type;
	}

	/** Set new amount */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/** Return amount */
	public double getAmount() {
		return amount;
	}

	/** Set a new balance */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/** Return balance */
	public double getBalance() {
		return balance;
	}

	/** Set a new description */
	public void setDescription(String description) {
		this.description = description;
	}

	/** Return description */
	public String getDescription() {
		return description;
	}
}