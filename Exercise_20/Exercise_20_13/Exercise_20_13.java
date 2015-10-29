import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.*;
import java.io.*;

public class Exercise_20_13 extends Application {
	protected Button btShuffle = new Button("Shuffle");
	protected Button btVerify = new Button("Verify");
	protected TextField textField = new TextField();
	protected Label lblStatus = new Label();
	protected ArrayList<ImageView> cards = new ArrayList<>();
	protected ArrayList<String> cardNumbers = new ArrayList<>();
	protected HBox paneForCards = new HBox(5);

	@Override /** Override the start method in the Application class */
	public void start(Stage primaryStage) {
		// Create a hbox for the shuffle button and verification status
		HBox paneForStatus = new HBox(5);
		paneForStatus.getChildren().addAll(lblStatus, btShuffle);
		paneForStatus.setAlignment(Pos.CENTER_RIGHT);

		// Create a hbox for expression and verify button
		HBox paneForExpression = new HBox(5);
		paneForExpression.getChildren().addAll(
			new Label("Enter an expression: "), textField, btVerify);
		paneForExpression.setAlignment(Pos.CENTER);

		// Pick and display 4 random cards from deck
		shuffle();

		// Create a pane and add nodes
		BorderPane pane = new BorderPane();
		pane.setTop(paneForStatus);
		pane.setCenter(paneForCards);
		pane.setBottom(paneForExpression);
		pane.setPadding(new Insets(5, 5, 5, 5));

		// Create and register handlers
		btShuffle.setOnAction(e -> shuffle());
		btVerify.setOnAction(e -> verify());

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 180);
		primaryStage.setTitle("Exercise_20_13"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/** Load four new random cards */
	private void shuffle() {
		lblStatus.setText("");
		textField.setText("");
		cards.clear();
		cardNumbers.clear();
		paneForCards.getChildren().clear();

		for (int i = 0; i < 4; i++) {
			ImageView card;
			int cardNum;
			do {
				cardNum = (int)(1 + Math.random() * 52);
				card = new ImageView(new Image("image/card/" + 
					cardNum + ".png"));
			} while (Collections.frequency(cards, card) > 1);
			cards.add(card);
			cardNumbers.add(String.valueOf(
				(cardNum % 13 == 0 ? 13 : cardNum % 13)));
		}
		paneForCards.getChildren().addAll(cards);	
		paneForCards.setAlignment(Pos.CENTER);
	}

	/** Checks whether the numbers in the expression are currently 
	  * selected and whether the result of the expression is correct */
	private void verify() {
		if (expressionMatch() && correctResult()) {
			lblStatus.setText("Correct");
		}
		else if (!expressionMatch()) {
			lblStatus.setText("The numbers in the expression don't " 
				+ "\nmatch the numbers in the set");
		}
		else if (!correctResult())
			lblStatus.setText("Incorrect result");
	}

	/** Returns true if numbers in the expression 
	  * match the numbers in the set */
	private boolean expressionMatch() {
		ArrayList<String> values = new ArrayList<>(
			Arrays.asList(textField.getText().split("[ ,(,),+,-,/,*]")));
		values.removeAll(Arrays.asList("+","-","/","*"," ","(",")",""));
		return values.containsAll(cardNumbers);
	}

	/** Returns true if the expression evaluates to 24 */
	private boolean correctResult() {
		return evaluateExpression() == 24;
	}

	/** Evaluate an expression */
	private int evaluateExpression() {
		// Create operandStack to store operands
		Stack<Integer> operandStack = new Stack<>();

		// Create operatorStack to store operators
		Stack<Character> operatorStack = new Stack<>();

		// Insert blanks around (, ), +, -, /, and *
		String expression = insertBlanks(textField.getText());

		// Extract tokens and operators
		String[] tokens = expression.split(" ");

		// Phase 1: Scan tokens
		for (String token: tokens) {
			if (token. length() == 0) // Blank space
				continue; // Back to the while loop to extract the next token
			else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
				// Process all +, -, *, / in the top of the operator stack
				while (!operatorStack.isEmpty() &&
					(operatorStack.peek() == '+' ||
					 operatorStack.peek() == '-' ||
					 operatorStack.peek() == '*' ||
					 operatorStack.peek() == '/')) {
					processAnOperator(operandStack, operatorStack);
				}

				// Push the + or - operator into the operator stack
				operatorStack.push(token.charAt(0));
			}
			else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
				// Process all *, / in the top of the operator stack
				while (!operatorStack.isEmpty() &&
					(operatorStack.peek() == '*') ||
					 operatorStack.peek() == '/') {
					processAnOperator(operandStack, operatorStack);
				}

				// Push the * or / operator into the operator stack
				operatorStack.push(token.charAt(0));
			}
			else if (token.trim().charAt(0) == '(') {
				operatorStack.push('('); // Push '(' to stack
			}
			else if (token.trim().charAt(0) == ')') {
				// Process all the operators in the stack until seeing '('
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

	/** Process on operator: Take an operator from operatorStack and
	 *  apply it on the operands in the operandStack */
	private void processAnOperator(
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
	}

	private String insertBlanks(String s) {
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