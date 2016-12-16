import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class Exercise31_05Client extends Application {
	// IO streams
	ObjectOutputStream toServer = null;
	DataInputStream fromServer = null;

	// Text fields for loan info
	private TextField tfAnnualInterestRate = new TextField();
	private TextField tfNumberOfYears = new TextField();
	private TextField tfLoanAmount = new TextField();

	// Button for submitting loan objet to server
	private Button btSubmit = new Button("Submit");

	// Create text area
	private TextArea ta = new TextArea();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Set text fields alignment right
		tfAnnualInterestRate.setAlignment(Pos.BASELINE_RIGHT);
		tfNumberOfYears.setAlignment(Pos.BASELINE_RIGHT);
		tfLoanAmount.setAlignment(Pos.BASELINE_RIGHT);

		// Create a pane to hold loan infomation
		GridPane paneForLoanInfo = new GridPane();
		paneForLoanInfo.add(new Label("Annual Interest Rate"), 0, 0);
		paneForLoanInfo.add(tfAnnualInterestRate, 1, 0);
		paneForLoanInfo.add(new Label("Number Of Years"), 0, 1);
		paneForLoanInfo.add(tfNumberOfYears, 1, 1);
		paneForLoanInfo.add(btSubmit, 2, 1);
		paneForLoanInfo.add(new Label("Loan Amount"), 0, 2);
		paneForLoanInfo.add(tfLoanAmount, 1, 2);

		BorderPane pane = new BorderPane();
		pane.setTop(paneForLoanInfo);
		pane.setCenter(new ScrollPane(ta));

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 355, 200);
		primaryStage.setTitle("Exercise31_05Client"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		btSubmit.setOnAction(e -> {
			try {
				// Get loan info from text fields and create a loan object
				Loan loan = new Loan(
					Double.parseDouble(tfAnnualInterestRate.getText().trim()),
					Integer.parseInt(tfNumberOfYears.getText().trim()),
					Double.parseDouble(tfLoanAmount.getText().trim()));

				// Send the loan object to the server
				toServer.writeObject(loan);
				toServer.flush();

				// Get monthly payment and total payment from the server
				double monthlyPayment = fromServer.readDouble();
				double totalPayment = fromServer.readDouble();

				// Display to text area
				ta.appendText("Annual Interest Rate: " + 
					loan.getAnnualInterestRate() + '\n');
				ta.appendText("Number Of Years: " + loan.getNumberOfYears() + '\n');
				ta.appendText("Loan Amount: " + loan.getLoanAmount() + '\n');
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

			// Create an output stream to send objects to the server
			toServer = new ObjectOutputStream(socket.getOutputStream());
		}
		catch (IOException ex) {
			ta.appendText(ex.toString() + '\n');
		}
	}	
}