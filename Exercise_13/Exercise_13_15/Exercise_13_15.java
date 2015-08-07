/*********************************************************************************
* (Use BigInteger for the Rational class) Redesign and implement the Rational    *
* class in Listing 13.13 using BigInteger for the numerator and denominator.     *
*********************************************************************************/
import java.math.BigInteger;

public class Exercise_13_15 {
	/** Main method */
	public static void main(String[] args) {
		// Create and initialize two rational numbers r1 and r2
		Rational r1 = new Rational(new BigInteger("400000"), 
			new BigInteger("200000"));
		Rational r2 = new Rational(new BigInteger("200000"), 
			new BigInteger("300000"));

		// Display results
		System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
		System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
		System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
		System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
		System.out.println(r2 + " is " + r2.doubleValue());
	}
}