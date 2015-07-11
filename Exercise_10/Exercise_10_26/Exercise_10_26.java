/*********************************************************************************
* (Calculator) Revise Listing 7.9, Calculator.java, to accept an expression as   *
* a string in which the operands and operator are separated by zero or more      *
* spaces. For example, 3+4 and 3 + 4 are acceptable expressions.                 *
*********************************************************************************/
public class Exercise_10_26 {
		/** Main method */
	public static void main(String[] args) {
		
		String a = args[0].replaceAll(" ","");
		a = a.replaceAll("[+]","#+#");
		a = a.replaceAll("[-]","#-#");
		a = a.replaceAll("[*]","#*#");
		a = a.replaceAll("[/]","#/#");
		args = a.split("#");

		// Check number of strings passed
		if (args.length != 3) {
			System.out.println(
				"Usage: java Calculator operand1 operator operand2");
			System.exit(0);
		}

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
			case '*' : result = Integer.parseInt(args[0]) *
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
}