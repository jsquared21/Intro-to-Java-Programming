/************************************************************************************
* (Combine files GUI) Rewrite Exercise 17.12 with a GUI, as shown in Figure 17.21b. *
************************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.io.*;

public class Exercise_17_13 extends Application {
	protected TextField tfFileName = new TextField();
	protected TextField tfNumberOfFiles = new TextField();	

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a label
		Label lblText = new Label(
			"If the base file is named temp.txt wth three pieces,\n" +
			"temp.txt.1, temp.txt.2, and temp.txt.3 are combined into temp.txt.");

		// Create a grid pane, place labels and text fields
		// into it and set its padding an horizontal gaps
		GridPane paneForFields = new GridPane();
		paneForFields.setHgap(5);
		paneForFields.add(new Label("Enter a file"), 0, 0);
		paneForFields.add(tfFileName, 1, 0);
		paneForFields.add(new Label("Specify the number of smaller files"), 0, 1);
		paneForFields.add(tfNumberOfFiles, 1, 1);
		paneForFields.setPadding(new Insets(5, 20, 5, 0));

		// Create a button
		Button btStart = new Button("Start");

		// Create a border pane and place node into it
		BorderPane pane = new BorderPane();
		pane.setTop(lblText);
		pane.setCenter(paneForFields);
		pane.setBottom(btStart);
		pane.setAlignment(btStart, Pos.CENTER);

		// Create and register handler
		btStart.setOnAction(e -> start());

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_17_13"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/* Combines the specified files */
	private void start() {
		// Get the number of smaller files
		int n = Integer.parseInt(tfNumberOfFiles.getText()); 

		// Create a array of random access files of length n
		RandomAccessFile[] source = new RandomAccessFile[n]; 

		try ( // Create a random access file
			RandomAccessFile target = 
				new RandomAccessFile(tfFileName.getText(), "rw");
		) {
			// Place the smaller files into the array
			for (int i = 0; i < source.length; i++) {
				source[i] = new RandomAccessFile(
					tfFileName.getText() + "." + (i + 1), "rw");
			}

			// Read the smaller files in accending order
			// and write each into the target file
			for (int i = 0; i < source.length; i++) {
				byte[] b = new byte[(int)source[i].length()];
				source[i].seek(0);
				source[i].read(b);
				target.seek(target.length());
				target.write(b);
			}
		}
		catch (IOException ex) {
			System.out.println("IO exception");
		}
	}
}