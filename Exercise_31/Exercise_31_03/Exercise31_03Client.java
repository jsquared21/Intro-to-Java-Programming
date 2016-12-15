import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class Exercise31_03Client extends Application {
	// Create streams
	DataInputStream fromServer = null;
	DataOutputStream toServer = null;

	// Create text fields for loan information
	private TextField tfAnnuealInterestRate = new TextField();
	private TextField tfNumberOfYears = new TextField();
	private TextField tfLoanAmount = new TextField();

	// Create button for submitting loan info to the server
	private Button btSubmit = new Button("Submit");

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();

		// Set text fields alignment right
		tfAnnuealInterestRate.setAlignment(Pos.BASELINE_RIGHT);
		tfNumberOfYears.setAlignment(Pos.BASELINE_RIGHT);
		tfLoanAmount.setAlignment(Pos.BASELINE_RIGHT);

		// GridPane to hold loan information
		GridPane paneForLoanInfo = new GridPane();
		paneForLoanInfo.add(new Label("Annual Interest Rate"), 0, 0);
		paneForLoanInfo.add(tfAnnuealInterestRate, 1, 0);
		paneForLoanInfo.add(new Label("Number Of Years"), 0, 1);
		paneForLoanInfo.add(tfNumberOfYears, 1, 1);
		paneForLoanInfo.add(btSubmit, 2, 1);
		paneForLoanInfo.add(new Label("Loan Amount"), 0, 2);
		paneForLoanInfo.add(tfLoanAmount, 1, 2);

		// Text area to display contents
		TextArea ta = new TextArea();
		pane.setTop(paneForLoanInfo);
		pane.setCenter(new ScrollPane(ta));

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 355, 200);
		primaryStage.setTitle("Exercise31_03Client"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		btSubmit.setOnAction(e -> {
			try {
				// Get the loan information from the text fields
				double annualInterestRate = Double.parseDouble(
					tfAnnuealInterestRate.getText().trim());

				int numberOfYears = Integer.parseInt(
					tfNumberOfYears.getText().trim());

				double loanAmount = Double.parseDouble(
					tfLoanAmount.getText().trim());

				// Send the loan information to the server
				toServer.writeDouble(annualInterestRate);
				toServer.writeInt(numberOfYears);
				toServer.writeDouble(loanAmount);
				toServer.flush();

				// Get monthly payment and total payment from the server
				double monthlyPayment = fromServer.readDouble();
				double totalPayment = fromServer.readDouble();

				// Display to text area
				ta.appendText("Annual Interest Rate: " + annualInterestRate + '\n');
				ta.appendText("Number Of Years: "  + numberOfYears + '\n');
				ta.appendText("Loan Amount: " + loanAmount + '\n');
				ta.appendText("monthlyPayment: " + monthlyPayment + '\n');
				ta.appendText("totalPayment: " + totalPayment + '\n');
			}
			catch (IOException ex) {
				System.err.println(ex);
			}
		});

		try {
			// Create a socket to connect to the server
			Socket socket = new Socket("localhost", 8000);

			// Create an input stream to receive data from the server
			fromServer = new DataInputStream(socket.getInputStream());

			// Create an output stream to send data to the server
			toServer = new DataOutputStream(socket.getOutputStream());
		}
		catch (IOException ex) {
			ta.appendText(ex.toString() + '\n');
		}
	}
}