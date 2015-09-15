/*********************************************************************************
* (Text viewer) Write a program that displays a text file in a text area, as     *
* shown in Figure 16.40a. The user enters a file name in a text field and clicks *
* the View button; the file is then displayed in a text area.                    *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import java.io.*;
import java.util.*;

public class Exercise_16_10 extends Application  {
	protected TextField tfFileName = new TextField();
	protected TextArea taTextFile = new TextArea();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) throws Exception {
		// Set text field properties
		tfFileName.setPrefColumnCount(23);

		// Create button
		Button btView = new Button("View");

		// Create pane for text field and button
		HBox paneForTextField = new HBox();
		paneForTextField.getChildren().addAll(new Label("Filename"), 
			tfFileName, btView);

		// Create text area and set it properties
		taTextFile.setEditable(false);
		taTextFile.setWrapText(true);

		// Create scroll pane
		ScrollPane scrollPane = new ScrollPane(taTextFile);

		// Create a vbox
		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(scrollPane, paneForTextField);

		// Create and register handler
		btView.setOnAction(e -> {
			try {
				getTextFile();
			}
			catch (FileNotFoundException ex) {
				taTextFile.setText("Error! File Not Found.");
			}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 200);
		primaryStage.setTitle("Exercise_16_10"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	// Reads text from file and displays it in a text area
	private void getTextFile() throws FileNotFoundException {
		// Check if source file exists
		File file = new File(tfFileName.getText());
		if (!file.exists()) {
			taTextFile.setText(tfFileName.getText() + " does not exist");
		}
		else {
			String text = "";
			try (
				// Create input file
				Scanner input = new Scanner(file);
			) {
				while (input.hasNext()) {
					text += input.nextLine();
					text += "\n";
				}
				taTextFile.setText(text);
			}
		}	
	}
}