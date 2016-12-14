import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Exercise31_01Server extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Text area for displaying contents
		TextArea ta = new TextArea();

		// Create a scene and place it in the stage
		Scene scene = new Scene(new ScrollPane(ta), 450, 200);
		primaryStage.setTitle("Exercise31_01Server"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		new Thread(() -> {
			try {
				// Create a server socket
				ServerSocket serverSocket = new ServerSocket(8000);
				Platform.runLater(() ->
					ta.appendText("Exercise31_01Server started at" + new Date() + '\n'));

				// Listen for a connection request
				Socket socket = serverSocket.accept();

				// Create data input and output streams
				DataInputStream inputFromClient = new DataInputStream(
					socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(
					socket.getOutputStream());

				while (true) {
					Date dateClientConnected = new Date();
					// Receive loan information from the client
					double annualInterestRate = inputFromClient.readDouble();
					int numberOfYears = inputFromClient.readInt();
					double loanAmount = inputFromClient.readDouble();

					// Compute monthly payment and total payment
					double monthlyInterestRate = annualInterestRate / 1200;
					double monthlyPayment = loanAmount * monthlyInterestRate / (1
						- 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
					double totalPayment = monthlyPayment * numberOfYears * 12;

					// Send monthly payment and total payment back to the client
					outputToClient.writeDouble(monthlyPayment);
					outputToClient.writeDouble(totalPayment);

					Platform.runLater(() -> {
						ta.appendText("Connected to a client at " + 
							dateClientConnected + '\n');
						ta.appendText("Annual Interest Rate: " + 
							annualInterestRate + '\n');
						ta.appendText("Number Of Years: " + numberOfYears + '\n');
						ta.appendText("Loan Amount: " + loanAmount + '\n');
						ta.appendText("monthlyPayment: " + monthlyPayment + '\n');
						ta.appendText("totalPayment: " + totalPayment + '\n');
					});
				}
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
		}).start();
	}
}