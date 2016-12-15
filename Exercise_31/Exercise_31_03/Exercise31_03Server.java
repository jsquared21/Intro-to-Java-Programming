import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Exercise31_03Server extends Application {
	// Text area for displaying contents
	private TextArea ta = new TextArea();

	// Number a client
	private int clientNo = 0;

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {

		// Create a scene and place it in the stage
		Scene scene = new Scene(new ScrollPane(ta), 400, 200);
		primaryStage.setTitle("Exercise31_03Server"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		new Thread(() -> {
			try {
				// Create a server socket
				ServerSocket serverSocket = new ServerSocket(8000);
				Platform.runLater(() -> 
					ta.appendText("Exercise31_03Server started at " 
						+ new Date() + '\n'));

				while (true) {
					// Listen for a new connection request
					Socket socket = serverSocket.accept();

					Platform.runLater(() -> {
						// Display the client number
						ta.appendText("Starting thread for client " + ++clientNo + 
							" at " + new Date() + '\n');  
					});

					// Create and start a new thread for the connection
					new Thread(new HandleAClient(socket)).start();
				}
			}
			catch(IOException ex) {
				System.err.println(ex);
			}
		}).start();
	}

	// Define the thread class for handling new connection
	class HandleAClient implements Runnable {
		private Socket socket; // A connected socket

		/** Construct a thread */
		public HandleAClient(Socket socket) {
			this.socket = socket;
		}

		/** Run a thread */
		public void run() {
			try {
				// Create data input and output streams
				DataInputStream inputFromClient = new DataInputStream(
					socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(
					socket.getOutputStream());

				// Continuously serve the client
				while (true) {
					// Receive loan information from the client
					double annualInterestRate = inputFromClient.readDouble();
					int numberOfYears = inputFromClient.readInt();
					double loanAmount = inputFromClient.readDouble();

					// Compute monthly payments and total payment
					double monthlyInterestRate = annualInterestRate / 1200;
					double monthlyPayment = loanAmount * monthlyInterestRate / (
						1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
					double totalPayment = monthlyPayment * numberOfYears * 12;

					// Send monthly payment and total payment back to the client
					outputToClient.writeDouble(monthlyPayment);
					outputToClient.writeDouble(totalPayment);

					Platform.runLater(() -> {
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
		}
	}
}