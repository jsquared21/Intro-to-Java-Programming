/*********************************************************************************
* (Postfix notation) Postfix notation is a way of writing expressions without    *
* using parentheses. For example, the expression (1 + 2) * 3 would be written as *
* 1 2 + 3 *. A postfix expression is evaluated using a stack. Scan a postfix     *
* expression from left to right. A variable or constant is pushed into the       *
* stack. When an operator is encountered, apply the operator with the top two    *
* operands in the stack and replace the two operands with the result. The        *
* following diagram shows how to evaluate 1 2 + 3 *.                             *
*                                                                                *
* Write a program to evaluate postfix expressions. Pass the expression as a      *
* command-line argument in one string.                                           *
*********************************************************************************/
import java.util.*;

public class Exercise_20_14 {
	public static void main(String[] args) {
		// Check number of command-line arguments 
		if (args.length != 1) {
			System.out.println("Usage: Java Exercise_20_14 \"Expressions\"");
			System.exit(1);
		}

		try {
			System.out.println(evaluateExpression(args[0]));
		}
		catch (Exception ex) {
			System.out.println("Wrong expression: " + args[0]);
		}
	}

	/** Evaluate a postfix notation expression */
	public static int evaluateExpression(
			String expression) throws Exception {
		// Create operandStack to store operands
		Stack<Integer> operandStack = new Stack<>();
		
		expression = insertBlanks(expression);

		// Extract operands and operators
		String[] tokens = expression.split(" ");

		// Scan tokens
		for (String token: tokens) {
			if (token.length() == 0) // Blank space
				continue; // Back to the while loop to extract the next token
			else if (token.charAt(0) == '+' || token.charAt(0) == '-'||
						token.charAt(0) == '/' || token.charAt(0) == '*') {
					// Process all operands in the top of the stack
					processAnOperator(operandStack, token.charAt(0));
			}
			else if (Character.isDigit(token.charAt(0))){
				// Push an operand into the stack
				operandStack.push(Integer.parseInt(token));
			}
			else
				throw new Exception("Wrong expression: ");
		}

		// Return the result
		return operandStack.pop();
	}

	/** Process one operator: Apply an operator 
	  * to the operands in the stack */
	public static void processAnOperator(
			Stack<Integer> operandStack, char operator) {
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();

		switch (operator) {
			case '+': operandStack.push(op2 + op1); break;
			case '-': operandStack.push(op2 - op1); break;
			case '/': operandStack.push(op2 / op1); break;
			case '*': operandStack.push(op2 * op1);
		}
	}

	/** Inserts blanks around +, -, /, and * */
	public static String insertBlanks(String s) {
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-' ||
				 s.charAt(i) == '/' || s.charAt(i) == '*')
				result += " " + s.charAt(i) + " ";
			else
				result += s.charAt(i);
		}

		return result;
	}
}