import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Exercise31_05Server extends Application {
	@Override // Override the start method in the Application class 
	public void start(Stage primaryStage) {
		// Text area for displaying contents
		TextArea ta = new TextArea();

		// Create a scene and place it in the stage
		Scene scene = new Scene(new ScrollPane(ta), 400, 200);
		primaryStage.setTitle("Exercise31_05Server"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		new Thread(() -> {
			try {
				// Create a server socket
				ServerSocket serverSocket = new ServerSocket(8000);
				Platform.runLater(() -> 
					ta.appendText("Exercise31_05Server started at "
						+ new Date() + '\n'));

				// Listen for a connection request
				Socket socket = serverSocket.accept();

				// Create object input stream
				ObjectInputStream inputFromClient = new ObjectInputStream(
					socket.getInputStream());

				// Create data output stream
				DataOutputStream outputToClient = new DataOutputStream(
					socket.getOutputStream());
					
				while (true) {
					Date date = new Date();

					// Receive loan object from client 
					Loan loan = (Loan)inputFromClient.readObject();

					// Compute monthly payment and total payment
					double monthlyInterestRate = loan.getAnnualInterestRate() / 1200;
					double monthlyPayment = loan.getLoanAmount() * monthlyInterestRate 
						/ ( 1 - 1 / Math.pow(1 + monthlyInterestRate, 
						loan.getNumberOfYears() * 12));
					double totalPayment = monthlyPayment * 
						loan.getNumberOfYears() * 12;

					// send monthly payment and total payment back to the client
					outputToClient.writeDouble(monthlyPayment);
					outputToClient.writeDouble(totalPayment);

					Platform.runLater(() -> {
						ta.appendText("Connected to a client at " + date + '\n');
						ta.appendText("Annual interest Rate: " + 
							loan.getAnnualInterestRate() + '\n');
						ta.appendText("Number Of Years: " + 
							loan.getNumberOfYears() + '\n');
						ta.appendText("Loan Amount: " + loan.getLoanAmount() + '\n');
						ta.appendText("monthlyPayment: " + monthlyPayment + '\n');
						ta.appendText("totalPayment: " + totalPayment + '\n');
					});
				}
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
			catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
		}).start(); 
	}
}