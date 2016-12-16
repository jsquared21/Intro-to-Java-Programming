import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Exercise31_04Client extends Application {
	// Input stream
	DataInputStream fromServer = null;

	// Create a label
	private Label label  = new Label("");

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {

		// Create a stack pane
		StackPane pane = new StackPane();
		pane.getChildren().add(label);

		// Crate a scene and place it in the stage
		Scene scene = new Scene(pane, 300, 75);
		primaryStage.setTitle("Exercise31_04Client"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		try {
			// Create a socket to connect to the server
			Socket socket = new Socket("localhost", 8000);

			// Create an input stream to receive data from the server
			fromServer = new DataInputStream(socket.getInputStream());

			// Receive and display string from the server 
			label.setText(fromServer.readUTF());
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}