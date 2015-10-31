/*********************************************************************************
* (Evaluate expression) Modify Listing 20.9 EvaluateExpression.java to add       *
* operators ^ for exponent and % for modulus. For example, 3 ^ 2 is 9 and 3 % 2  *
* is 1. The ^ operator has the highest precedence and the % operator has the     *
* same precedence as the * and / operators. Your program should prompt the user  *
* to enter an expression. Here is a sample run of the program:                   *
*********************************************************************************/
import java.util.*;

public class Exercise_20_23 {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter an expression
		System.out.print("Enter an expression: ");
		String expression = input.nextLine();

		try {
			System.out.println(expression + " = " + 
				evaluateExpression(expression));
		}
		catch (Exception ex) {
			System.out.println("Wrong expression: " + expression);
		}
	}

	/** Evaluate an expression */
	public static int evaluateExpression(String expression) {
		// Create operandStack to store operands
		Stack<Integer> operandStack = new Stack<>();

		// Create operandStack to store operators
		Stack<Character> operatorStack = new Stack<>();

		// Insert blanks around (, ), +, -, /, *, ^, and % 
		expression = insertBlanks(expression);

		// Extract operands an operators
		String[] tokens = expression.split(" ");

		// Phase 1: Scan tokens
		for (String token: tokens) {
		 	if (token.length() == 0) // Blank space
		 		continue; // Back to the while loop to extract the next token
		 	else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
		 		// Process all +, -, *, /, ^, % in the top of the operator stack
		 		while (!operatorStack.isEmpty() &&
		 			(operatorStack.peek() == '+' ||
		 			 operatorStack.peek() == '-' ||
		 			 operatorStack.peek() == '*' ||
		 			 operatorStack.peek() == '/' ||
		 			 operatorStack.peek() == '^' ||
		 			 operatorStack.peek() == '%')) {
		 			processAnOperator(operandStack, operatorStack);
		 		}

		 		// Push the + or - operator into the operator stack
		 		operatorStack.push(token.charAt(0));
		 	}
		 	else if (token.charAt(0) == '*' || 
		 				token.charAt(0) == '/' || token.charAt(0) == '%') {
		 		// Process all *, /, % in the top of the operator stack
		 		while (!operatorStack.isEmpty() &&
		 			(operatorStack.peek() == '*' ||
		 			 operatorStack.peek() == '/' ||
		 			 operatorStack.peek() == '%' )) {
		 			processAnOperator(operandStack, operatorStack);
		 		}

		 		// Push the *, / or % operator into the operator stack
		 		operatorStack.push(token.charAt(0));
		 	}
		 	else if (token.charAt(0) == '^') {
		 		// Process all '^' operators in the top of the operator stack
		 		while (!operatorStack.isEmpty() && 
		 				  operatorStack.peek() == '^') {
		 			processAnOperator(operandStack, operatorStack);
		 		}

		 		// Push the ^ operator into the operator stack
		 		operatorStack.push(token.charAt(0));
		 	}
		 	else if (token.trim().charAt(0) == '(') {
		 		operatorStack.push('('); // Push '(' to stack
		 	}
		 	else if (token.trim().charAt(0) == ')') {
		 		//Process all the operators in the stack until seeing '('
		 		while (operatorStack.peek() != '(') {
		 			processAnOperator(operandStack, operatorStack);
		 		}

		 		operatorStack.pop(); // Pop the '(' symbol from the stack
		 	}
		 	else { // An operand scanned
		 		// Push an operand to the stack
		 		operandStack.push(new Integer(token));
		 	}
		}

		// Phase 2: Process all the remaining operators in the stack
		while (!operatorStack.isEmpty()) {
			processAnOperator(operandStack, operatorStack);
		} 

		// Return the result
		return operandStack.pop();
	}

	/** Process one operator: Take an operator from operatorStack and 
	  * apply it on the operands in the operandStack */
	public static void processAnOperator(
			Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char op = operatorStack.pop();
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		if (op == '+')
			operandStack.push(op2 + op1);
		else if (op == '-')
			operandStack.push(op2 - op1);
		else if (op == '*')
			operandStack.push(op2 * op1);
		else if (op == '/')
			operandStack.push(op2 / op1);
		else if (op == '^')
			operandStack.push((int)Math.pow(op2, op1));
		else if (op == '%')
			operandStack.push(op2 % op1);
	}

	public static String insertBlanks(String s) {
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
				 s.charAt(i) == '+' || s.charAt(i) == '-' ||
				 s.charAt(i) == '*' || s.charAt(i) == '/' || 
				 s.charAt(i) == '^' || s.charAt(i) == '%')
				result += " " + s.charAt(i) + " ";
			else
				result += s.charAt(i);
		}

		return result;
	}
}