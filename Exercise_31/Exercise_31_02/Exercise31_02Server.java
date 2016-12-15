import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Exercise31_02Server extends Application {
	final double KILOGRAMS_PER_POUND = 0.45359237; // Kilograms per pound
	final double METERS_PER_INCH = 0.0254; // Meters per Inch

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Text area for displaying contents
		TextArea ta = new TextArea();

		// Create a scene and place it in the stage
		Scene scene = new Scene(new ScrollPane(ta), 450, 200);
		primaryStage.setTitle("Exercise31_02Server"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		new Thread(() -> {
			try {
				// Create a server socket
				ServerSocket serverSocket = new ServerSocket(8000);
				Platform.runLater(() ->
					ta.appendText("Exercise31_02Server started at " 
						+ new Date() + '\n'));

				// Listen for a connection request
				Socket socket = serverSocket.accept();

				// Create data input and output streams
				DataInputStream inputFromClient = new DataInputStream(
					socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(
					socket.getOutputStream());

				while (true) {
					Date date = new Date();

					// Receive the weight and height from the server
					double weight = inputFromClient.readDouble();
					double height = inputFromClient.readDouble();

					// Compute the BMI (Body Mass Index)
					double weightInKilograms = weight * KILOGRAMS_PER_POUND;
					double heightInMeters = height * METERS_PER_INCH;
					double bmi = weightInKilograms / Math.pow(heightInMeters, 2);

					// Create string with BMI information
					StringBuilder strBMI = new StringBuilder("BMI is " + 
						String.format("%.2f", bmi) + ". ");
					
					if (bmi < 18.5)
						strBMI.append("Underweight");
					else if (bmi < 25)
						strBMI.append("Normal");
					else if (bmi < 30)
						strBMI.append("Overweight");
					else
						strBMI.append("Obese");

					// Send string back to client
					outputToClient.writeUTF(strBMI.toString());

					Platform.runLater(() -> {
						ta.appendText("Connected to a client at " + date + '\n');
						ta.appendText("Weight: " + weight + '\n');
						ta.appendText("Height: " + height + '\n');
						ta.appendText(strBMI.toString() + '\n');
					});
				}
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}).start();
	}
}