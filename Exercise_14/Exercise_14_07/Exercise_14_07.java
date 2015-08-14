/***************************************************************************
* (Display random 0 or 1) Write a program that displays a 10-by-10 square  *
* matrix, as shown in Figure 14.45a. Each element in the matrix is 0 or 1, *
* randomly generated. Display each number centered in a text field. Use    *
* TextField’s setText method to set value 0 or 1 as a string.              *
***************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;

public class Exercise_14_07 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a GridPane and set its properties
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(5, 5, 5, 5));
		pane.setHgap(5);
		pane.setVgap(5);

		// Place text fields containing a centered, 
		// randomly generated string of 0 or 1 in the pane
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				TextField text = new TextField();
				text.setPrefColumnCount(1);
				text.setText(String.valueOf((int)(Math.random() * 2)));
				pane.add(text, i, j);
				pane.setHalignment(text, HPos.CENTER);
				pane.setValignment(text, VPos.CENTER);
			}
		}

		// Create a scene and plane it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_14_07"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}