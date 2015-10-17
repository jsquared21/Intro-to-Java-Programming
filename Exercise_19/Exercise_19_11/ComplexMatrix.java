public class ComplexMatrix extends GenericMatrix<Complex> {

	@Override /** Add two complex numbers */
	protected Complex add(Complex c1, Complex c2) {
		return c1.add(c2);
	}

	@Override /** Multiply two complex numbers */
	protected Complex multiply(Complex c1, Complex c2) {
		return c1.multiply(c2);
	}

	@Override /** Specify zero for a complex number */
	protected Complex zero() {
		return new Complex();
	}
}