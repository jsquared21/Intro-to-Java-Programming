import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Exercise31_02Client extends Application {
	// IO streams
	DataOutputStream toServer = null;
	DataInputStream fromServer = null;

	// Text fields for BMI information
	private TextField tfWeight = new TextField();
	private TextField tfHeight = new TextField();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Main pane
		BorderPane pane = new BorderPane();

		// Set text field alignment right
		tfWeight.setAlignment(Pos.BASELINE_RIGHT);
		tfHeight.setAlignment(Pos.BASELINE_RIGHT);

		// Create button to send BMI info to server
		Button btSubmit = new Button("Submit");

		// Pane to hold BMI information and submit button
		GridPane paneForBmiInfo = new GridPane();
		paneForBmiInfo.add(new Label("Weight in pounds"), 0, 0);
		paneForBmiInfo.add(tfWeight, 1, 0);
		paneForBmiInfo.add(new Label("Height in inches"), 0, 1);
		paneForBmiInfo.add(tfHeight, 1, 1);
		paneForBmiInfo.add(btSubmit, 2, 1);

		// Text Area to display contents
		TextArea ta = new TextArea();
		pane.setTop(paneForBmiInfo);
		pane.setCenter(new ScrollPane(ta));

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 200);
		primaryStage.setTitle("Exercise31_01Client"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		btSubmit.setOnAction(e -> {
			try {
				// Get the weight and height from the text fields
				double weight = Double.parseDouble(tfWeight.getText().trim());
				double height = Double.parseDouble(tfHeight.getText().trim());

				// Send the BMI information to the server
				toServer.writeDouble(weight);
				toServer.writeDouble(height);
				toServer.flush();

				// Get string from the server
				String bmi = fromServer.readUTF();

				// Display to text area
				ta.appendText("Weight: " + weight + '\n');
				ta.appendText("Height: " + height + '\n');
				ta.appendText(bmi + '\n');
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