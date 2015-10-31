/*********************************************************************************
* (Convert infix to postfix) Write a method that converts an infix expression    *
* into a postfix expression using the following header:                          *
*                                                                                *
* public static String infixToPostfix(String expression)                         *
* For example, the method should convert the infix expression (1 + 2) * 3 to     *
* 1 2 + 3 * and 2 * (1 + 3) to 2 1 3 + *.                                        *
*********************************************************************************/
import java.util.*;

public class Exercise_20_16 {
	public static void main(String[] args) {
		// Test method infixToPostfix and display result
		System.out.println("Infix Expression     Postfix Expression");
		System.out.println("  (1 + 2) * 3            " 
			+ infixToPostfix("(1 + 2) * 3"));
		System.out.println("   2 * (1 + 3)           " 
			+ infixToPostfix("2 * (1 + 3)"));
	}

	/** Method converts an infix expression into a postfix expression */
	public static String infixToPostfix(String expression) {
		// Create a Linked list to store the result
		LinkedList<String> operatorList = new LinkedList<>();

		// Create a Linked list to store operands
		LinkedList<String> resultList = new LinkedList<>();

		// Create a stack to store '('
		Stack<Character> stack = new Stack<>();

		// Insert blanks around (, ), +, -, /, and *
		expression = insertBlanks(expression);

		// Extract operands and operators
		String[] tokens = expression.split(" ");

		// Scan tokens
		for (String token: tokens) {
			if (token.length() == 0) // Blank space
				continue; // Back to the while loop to extract the next token
			else if (token.charAt(0) == '(') // Push '(' onto the stack
				stack.push(token.charAt(0));
			else if (!stack.isEmpty() && stack.peek() == '(' && 
						token.charAt(0) != ')') {
				// Place operators within "( )" and the 
				// front to the front of the operatorList
				if (Character.isDigit(token.charAt(0)))
					resultList.addLast(token);
				else if (token.charAt(0) == '+' || token.charAt(0) == '-' ||
							token.charAt(0) == '*' || token.charAt(0) == '/' )
					operatorList.addFirst(token);
			} 
			else if (!stack.isEmpty() && token.charAt(0) == ')') {
				// Add the operatorList to the result
				resultList.addAll(operatorList);
				operatorList.clear();
				stack.pop();
			}
			else if (token.charAt(0) == '+' || token.charAt(0) == '-')
				operatorList.addLast(token); // Add +, - to the end of list
			else if (token.charAt(0) == '*' || token.charAt(0) == '/') 
				operatorList.addFirst(token); // Add +, - to the front of list
			else if (Character.isDigit(token.charAt(0)))
				resultList.addLast(token); // Add digits to result list
		}

		// Format the result string
		String result = "";
		resultList.addAll(operatorList);
		for (String e: resultList) {
			result += e + " ";
		}

		// return result
		return result;
	}

	/** Method Inserts blanks around (, ), +, -, /, and *. */
	public static String insertBlanks(String s) {
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
				 s.charAt(i) == '+' || s.charAt(i) == '-' ||
				 s.charAt(i) == '*' || s.charAt(i) == '/')
				result += " " + s.charAt(i) + " ";
			else
				result += s.charAt(i);
		}

		return result;
	}
}