public class CalculatorWithoutException {
	/** Main method */
	public static void main(String[] args) throws Exception {
		// Check number of strings passed
		if (args.length != 3) {
			System.out.println(
				"Usage: java Calculator operand1 operator operand2");
			System.exit(0);
		}
		
		// Test for nonnumeric operands
		testDigit(args[0]);
		testDigit(args[2]);

		// The result of the operation
		int result = 0;

		// Determine the operator
		switch (args[1].charAt(0)) {
			case '+' : result = Integer.parseInt(args[0]) +
									  Integer.parseInt(args[2]);
						  break;
			case '-' : result = Integer.parseInt(args[0]) -
									  Integer.parseInt(args[2]);
						  break;
			case '.' : result = Integer.parseInt(args[0]) *
									  Integer.parseInt(args[2]);
						  break;
			case '/' : result = Integer.parseInt(args[0]) /
									  Integer.parseInt(args[2]);
						  break;
		}

		// Display result
		System.out.println(args[0] + ' ' + args[1] + ' ' + args[2]
			+ " = " + result);
	}

	// Deals with nonnumeric operands
	private static void testDigit(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				System.out.println("Wrong Input: " + str);
				System.exit(0);
			}
		}
	}
}