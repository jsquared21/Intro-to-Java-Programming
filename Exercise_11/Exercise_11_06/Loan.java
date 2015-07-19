/**************************************
*            Loan                     *
*-----------------------------------  *
* -annualInterestRate: double         *
* -numberOfYears: int                 *
* -loanAmount: double                 *
* -loanDate: java.util.Date           *
* +Loan()                             *
* +Loan(annualInterestRate: double,   *
*   numberOfYears: int,loanAmount:    *
*   double)                           *
* +getAnnualInterestRate(): double    *
* +getNumberOfYears(): int            *
* +getLoanAmount(): double            *
* +getLoanDate(): java.util.Date      *
* +setAnnualInterestRate(             *
*   annualInterestRate: double): void *
* +setNumberOfYears(                  *
*   numberOfYears: int): void         *
* +setLoanAmount(                     *
* loanAmount: double): void           *
* +getMonthlyPayment(): double        *
* +getTotalPayment(): double          *
**************************************/

public class Loan {
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;

	/** Default constructor */
	public Loan() {
		this(2.5, 1, 1000);
	}

	/** Construct a loan with specified annual interest rate, 
	    number of years, and loan amount
	 */
	public Loan(double annualInterestRate, int numberOfYears,
		double loanAmount) {
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
		loanDate = new java.util.Date();
	}

	/** Return annualInterestRate */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	/** Set an new annualInterestRate */
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	/** Return numberOfYears */
	public int getNumberOfYears() {
		return numberOfYears;
	}

	/** Set a new numberOfYears */
	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	/** Return loanAmount */
	public double getLoanAmount() {
		return loanAmount;
	}

	/** Set a new loanAmount */
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	} 

	/** Find monthly payment */
	public double getMonthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
			(1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
		return monthlyPayment;
	}

	/** Find total payment */
	public double getTotalPayment() {
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;
	}
	
	/** Return loan date */
	public java.util.Date getLoanDate() {
		return loanDate;
	}
}