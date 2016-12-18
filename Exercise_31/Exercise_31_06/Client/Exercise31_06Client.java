import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class Exercise31_06Client extends Application {
	// IO Streams
	ObjectOutputStream objectToServer = null;
	ObjectInputStream objectFromServer = null;
	DataInputStream dataFromServer = null;
	DataOutputStream dataToServer = null;

	// Text fields for address information
	private TextField tfName = new TextField();
	private TextField tfStreet = new TextField();
	private TextField tfCity = new TextField();
	private TextField tfState = new TextField();
	private TextField tfZip = new TextField();

	// Buttons for navigating address information
	private Button btAdd = new Button("Add");
	private Button btFirst = new Button("First");
	private Button btNext = new Button("Next");
	private Button btPrevious = new Button("Previous");
	private Button btLast = new Button("Last");

	// Host name or ip
	String host = "localhost";

	// Address index
	int index = -1;

	// Number of Addresses stored
	int size = 0;

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();
		pane.add(new Label("Name"), 0, 0);
		pane.add(tfName, 1, 0);
		pane.add(new Label("Street"), 0, 1);
		pane.add(tfStreet, 1, 1);
		pane.add(new Label("City"), 0, 2);

		// Hbox to store city, state and zip info
		HBox hBox = new HBox(5);
		pane.add(hBox, 1, 2);
		hBox.getChildren().addAll(tfCity, new Label("State"), 
			tfState, new Label("Zip"), tfZip);

		// Hbox to hold buttons
		HBox paneForButtons = new HBox(5);
		paneForButtons.getChildren().addAll(btAdd, btFirst, btNext, btPrevious, btLast);
		pane.add(paneForButtons, 1, 3);
		pane.setHgap(5);
		pane.setVgap(5);

		pane.setAlignment(Pos.CENTER);
		tfName.setPrefColumnCount(15);
		tfState.setPrefColumnCount(15);
		tfCity.setPrefColumnCount(10);
		tfState.setPrefColumnCount(2);
		tfZip.setPrefColumnCount(3);

		// Register handlers
		btAdd.setOnAction(e -> addAddress());
		btFirst.setOnAction(e -> getFirst());
		btNext.setOnAction(e -> getNext());
		btPrevious.setOnAction(e -> getPrevious());
		btLast.setOnAction(e -> getLast());

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 375, 130);
		primaryStage.setTitle("Exercise31_06"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

	/** Add an address */
	private void addAddress() {
		try {
			// Connect to the server
			Socket socket = new Socket(host, 8000);

			// Create an output stream
			dataToServer = new DataOutputStream(socket.getOutputStream());

			// Send a string command to the server
			dataToServer.writeUTF("ADD_STUDENT");
			dataToServer.flush();

			// Get text field
			String name = tfName.getText().trim();
			String street = tfStreet.getText().trim();
			String city = tfCity.getText().trim();
			String state = tfState.getText().trim();
			String zip = tfZip.getText().trim();
	
			// Create a Student object and send to the server
			objectToServer = new ObjectOutputStream(socket.getOutputStream());
			StudentAddress s = 
				new StudentAddress(name, street, city, state, zip);
			objectToServer.writeObject(s);
			
			// Create an input stream
			dataFromServer = new DataInputStream(socket.getInputStream());
			index = dataFromServer.readInt(); // Get this address index
			size = dataFromServer.readInt(); // Get number of addresses stored
			System.out.println("Address index: " + index);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	} 

	/** Display the first address */
	private void getFirst() {
		getAddress(0);
	}

	/** Display the next address */
	private void getNext() {
		getAddress(index + 1);
	}

	/** Display the previous address */
	private void getPrevious() {
		getAddress(index - 1);
	}

	/** Request and Display an object from the server */
	private void getAddress(int i) {
		try {
			// Connect to socket
			Socket socket = new Socket(host, 8000);

			// Send data to server
			dataToServer = new DataOutputStream(socket.getOutputStream());
			dataToServer.writeUTF("GET_INDEX");
			dataToServer.writeInt(i);
			System.out.println("Get index: " + i);
			dataToServer.flush();

			// Recieve object from server
			objectFromServer = new ObjectInputStream(socket.getInputStream());
			StudentAddress s = (StudentAddress)objectFromServer.readObject();
			
			setTextFields(s);

			// Recieve data from server
			dataFromServer = new DataInputStream(socket.getInputStream());
			index = dataFromServer.readInt(); // Get this address index
			size = dataFromServer.readInt(); // Get the number of addresses stored
			System.out.println("Address index: " + index);
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	/** Display the Last address */
	private void getLast() {
		try {
			// Connect to socket
			Socket socket = new Socket(host, 8000);

			// Send data to server
			dataToServer = new DataOutputStream(socket.getOutputStream());
			dataToServer.writeUTF("GET_LAST");
			dataToServer.flush();

			// Recieve object from server
			objectFromServer = new ObjectInputStream(socket.getInputStream());
			StudentAddress s = (StudentAddress)objectFromServer.readObject();
			
			setTextFields(s);

			// Recieve data from server
			dataFromServer = new DataInputStream(socket.getInputStream());
			index = dataFromServer.readInt(); // Get this address index
			size = dataFromServer.readInt(); // Get number of addresses stored
			System.out.println("Address index: " + index);
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	/** Set the text fields */
	private void setTextFields(StudentAddress s) {
		tfName.setText(s.getName());
		tfStreet.setText(s.getStreet());
		tfCity.setText(s.getCity());
		tfState.setText(s.getState());
		tfZip.setText(s.getZip());
	}
}
