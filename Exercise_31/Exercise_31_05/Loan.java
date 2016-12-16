public class Loan implements java.io.Serializable {
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;


	public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public int getNumberOfYears() {
		return numberOfYears;
	}

	public double getLoanAmount() {
		return loanAmount;
	}
}