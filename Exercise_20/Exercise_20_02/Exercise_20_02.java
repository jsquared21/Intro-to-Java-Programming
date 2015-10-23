/*********************************************************************************
* (Store numbers in a linked list) Write a program that lets the user enter      *
* numbers from a graphical user interface and displays them in a text area, as   *
* shown in Figure 20.17a. Use a linked list to store the numbers. Do not store   *
* duplicate numbers. Add the buttons Sort, Shuffle, and Reverse to sort, shuffle,* 
* and reverse the list.                                                          *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import java.util.*;

public class Exercise_20_02 extends Application {
	protected TextField textField = new TextField();
	protected TextArea textArea = new TextArea();
	protected LinkedList<Integer> list = new LinkedList<>();

	@Override // Override the start method in the Application class 
	public void start(Stage primaryStage) {
		// Create three buttons
		Button btSort = new Button("Sort");
		Button btShuffle = new Button("Shuffle");
		Button btReverse = new Button("Reverse");

		// Create a pane to hold the textfield
		HBox paneForTextField = new HBox(10);
		paneForTextField.getChildren().addAll(
			new Label("Enter a number:"), textField);
		paneForTextField.setAlignment(Pos.CENTER);

		// Create a pane to hold buttons
		HBox paneForButtons = new HBox(5);
		paneForButtons.getChildren().addAll(
			btSort, btShuffle, btReverse);
		paneForButtons.setAlignment(Pos.CENTER);

		// Set text area editable and text wrap properties
		textArea.setEditable(false);
		textArea.setWrapText(true);

		// Create a border pane and add nodes to it
		BorderPane pane = new BorderPane();
		pane.setTop(paneForTextField);
		pane.setCenter(textArea);
		pane.setBottom(paneForButtons);


		// Create and register handles
		textField.setOnAction(e -> add()); // add and integer

		// Sort the list
		btSort.setOnAction(e -> {
			Collections.sort(list);
			displayText();
		});

		// Shuffle the list
		btShuffle.setOnAction(e -> {
			Collections.shuffle(list);
			displayText();
		});

		// Reverse the list
		btReverse.setOnAction(e -> {
			Collections.sort(list, Collections.reverseOrder());
			displayText();
		});


		// Create a Scene and place it in the stage
		Scene scene = new Scene(pane, 400, 150);
		primaryStage.setTitle("Exercise_20_02"); // Set the stage title
		primaryStage.setScene(scene); // Place a scene in the stage
		primaryStage.show(); // Display the stage
	}

	/** Add an integer to the end of the list */
	private void add() {
		list.addLast(Integer.parseInt(textField.getText()));
		displayText();
	}

	/** Display elements in the list in the text area */
	private void displayText() {
		String output = "";
		for (Integer e: list)
			output += e + " ";

		textArea.setText(output);
		textField.setText("");
	}
}