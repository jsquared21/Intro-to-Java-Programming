/*********************************************************************************
* (Create a rational-number calculator) Write a program similar to Listing 7.9,  *
* Calculator.java. Instead of using integers, use rationals, as shown in Figure  *
* 13.10a. You will need to use the split method in the String class, introduced  *
* in Section 10.10.3, Replacing and Splitting Strings, to retrieve the numerator *
* string and denominator string, and convert strings into integers using the     *
* Integer.parseInt method.                                                       *
*********************************************************************************/
public class Exercise_13_16 {
	/** Main method */
	public static void main(String[] args) {
		// Check java command line usage
		if (args.length != 1) {
			System.out.println("Usage: java Exercise_13_16 String");
			System.exit(0);
		}

		// Create string output
		String output = args[0];

		// Retrieve numerator and denominator from string
		String[] str = (args[0].replaceAll(" ", "/")).split("/");

		// Create two Rational objects
		Rational r1 = new Rational(Integer.parseInt(str[0]), 
			Integer.parseInt(str[1]));
		Rational r2 = new Rational(Integer.parseInt(str[3]),
			Integer.parseInt(str[4]));

		// Retrieve operand
		switch (str[2].charAt(0)) {
			case '+' : output += " = " + r1.add(r2);	break;
			case '-' : output += " = " + r1.subtract(r2); break;
			case '.' : output += " = " + r1.multiply(r2); break;
			case '/' : output += " = " + r1.divide(r2); break;
			default : System.out.println("Illegal Argument: + - . /"); 
						System.exit(0);
		}

		// Display results
		System.out.println(output);
	}
}