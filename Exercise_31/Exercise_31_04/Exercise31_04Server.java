import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Exercise31_04Server extends Application {
	// Text area for displaying contents
	private TextArea ta = new TextArea();

	// Count the thread
	private int threadNo = 0;

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a scene and place it in the stage
		Scene scene = new Scene(new ScrollPane(ta), 450, 200);
		primaryStage.setTitle("Exercise31_04Sever"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		new Thread(() -> {
			try {
				// Create a server socket
				ServerSocket serverSocket = new ServerSocket(8000);
				ta.appendText("Exercise31_04Sever started at " + new Date() + '\n');

				while (true) {
					// Listen for a new connection request
					Socket socket = serverSocket.accept();

					Platform.runLater(() -> {
						// Display the thread number
						ta.appendText("Starting thread " + threadNo++ + '\n');

						// Find the client's ip address
						InetAddress inetAddress = socket.getInetAddress();
						ta.appendText("Client IP /" + 
							inetAddress.getHostAddress() + '\n');

					});

					// Create and start new thread for the connection
					new Thread(new HandleAClient(socket)).start();
				}	
			}
			catch(IOException ex) {
				System.err.println(ex);
			}
		}).start();
	}

	// Define the thread class for handlind new connection
	class HandleAClient implements Runnable {
		private Socket socket; // A connected socket

		/** Construct a thread */
		public HandleAClient(Socket socket) {
			this.socket = socket;
		}

		/** Run a thread */
		public void run() {
			try {
				// Create a data output stream
				DataOutputStream outputToClient = new DataOutputStream(
					socket.getOutputStream());

				// Send a string to the Client
				outputToClient.writeUTF("You are visitor " + threadNo);
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}