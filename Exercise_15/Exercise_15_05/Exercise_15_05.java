/*********************************************************************************
* (Create an investment-value calculator) Write a program that calculates the    *
* future value of an investment at a given interest rate for a specified number  *
* of years. The formula for the calculation is:                                  *
*                                                                                *
* futureValue = investmentAmount * (1 + monthlyInterestRate)years*12             *
*                                                                                *
* Use text fields for the investment amount, number of years, and annual         *
* interest rate. Display the future amount in a text field when the user clicks  *
* the Calculate button, as shown in Figure 15.25b.                               *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class Exercise_15_05 extends Application {
	private TextField tfInvestmentAmount = new TextField();
	private TextField tfNumberOfYears = new TextField();
	private TextField tfAnnualInterestRate = new TextField();
	private TextField tfFutureValue = new TextField();
	private Button btCalculate = new Button("Calculate");

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create UI
		GridPane pane = new GridPane();
		pane.setVgap(5);
		pane.setHgap(5);
		pane.add(new Label("Investment Amount:"), 0, 0);
		pane.add(tfInvestmentAmount, 1, 0);
		pane.add(new Label("Number Of Years:"), 0, 1);
		pane.add(tfNumberOfYears, 1, 1);
		pane.add(new Label("Annual Interest Rate:"), 0, 2);
		pane.add(tfAnnualInterestRate, 1, 2);
		pane.add(new Label("Future value:"), 0, 3);
		pane.add(tfFutureValue, 1, 3);
		pane.add(btCalculate, 1, 4);

		// Set UI properties
		pane.setAlignment(Pos.CENTER);
		tfInvestmentAmount.setAlignment(Pos.BOTTOM_RIGHT);
		tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
		tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
		tfFutureValue.setAlignment(Pos.BOTTOM_RIGHT);
		tfFutureValue.setEditable(false);
		pane.setHalignment(btCalculate, HPos.RIGHT);
		pane.setPadding(new Insets(10, 10, 10, 10));

		// Process events
		btCalculate.setOnAction(e -> futureValue());

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_15_05"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	private void futureValue() {
		double investmentAmount = Double.parseDouble(tfInvestmentAmount.getText());
		int years = Integer.parseInt(tfNumberOfYears.getText());
		double monthlyInterestRate = 
			Double.parseDouble(tfAnnualInterestRate.getText()) / 1200;
		tfFutureValue.setText(String.format("$%.2f", 
			(investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12))));
	}
}