public class Rational extends Number implements Comparable<Rational> {
	// Data fields for numerator and denominator
	private long[] r = new long[2];

	/** Construct a ratinoal with default properties */
	public Rational() {
		this(0, 1);
	}

	/** Construct a rational with specifiec numerator and denominator */
	public Rational(long numerator, long denominator) {
		long gcd = gcd(numerator, denominator);
		r[0] = ((denominator > 0) ? 1 : -1) * numerator / gcd;
		r[1] = Math.abs(denominator) / gcd;
	}

	/** Find GCD of two numbers */
	private static long gcd(long n, long d) {
		long n1 = Math.abs(n);
		long n2 = Math.abs(d);
		int gcd = 1;

		for (int k = 1; k <= n1 && k <= n2; k++) {
			if (n1 % k == 0 && n2 % k == 0)
				gcd = k;
		}

		return gcd;
	}

	/** Return numerator */
	public long getNumerator() {
		return r[0];
	}

	/** Return denominator */
	public long getDenominator() {
		return r[1];
	}

	/** Add a rational number to this rational */
	public Rational add(Rational secondRational) {
		long n = r[0] * secondRational.getDenominator() +
			r[1] * secondRational.getNumerator();
		long d = r[1] * secondRational.getDenominator();
		return new Rational(n, d);
	}

	/** Subtract a rational number from this rational */
	public Rational subtract(Rational secondRational) {
		long n = r[0] * secondRational.getDenominator()
			- r[1] * secondRational.getNumerator();
		long d = r[1] * secondRational.getDenominator();
		return new Rational(n, d);
	}

	/** Mulitply a rational number by this rational */
	public Rational multiply(Rational secondRational) {
		long n = r[0] * secondRational.getNumerator();
		long d = r[1] * secondRational.getDenominator();
		return new Rational(n, d);
	}

	/** Divide a rational number by this rational */
	public Rational divide(Rational secondRational) {
		long n = r[0] * secondRational.getDenominator();
		long d = r[1] * secondRational.getNumerator();
		return new Rational(n, d);
	}

	@Override
	public String toString() {
		if (r[1] == 1)
			return r[0] + "";
		else
			return r[0] + "/" + r[1];
	}

	@Override // Override the equals method in the Object class
	public boolean equals(Object other) {
		if ((this.subtract((Rational)(other))).getNumerator() == 0)
			return true;
		else
			return false;
	}

	@Override // Implement the abstract intValue method in Number
	public int intValue() {
		return (int)doubleValue();
	}

	@Override // Implement the abstract floatValue method in Number
	public float floatValue() {
		return (float)doubleValue();
	}

	@Override // Implement the doubleValue method in Number
	public double doubleValue() {
		return r[0] * 1.0 / r[1];
	}

	@Override // Implement the abstract longValue method in Number
	public long longValue() {
		return (long)doubleValue();
	}

	@Override // Implement the compareTo method in Coparable
	public int compareTo(Rational o) {
		if (this.subtract(o).getNumerator() > 0)
			return 1;
		else if (this.subtract(o).getNumerator() < 0)
			return -1;
		else
			return 0;
	}
}