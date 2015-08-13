/*********************************************************************************
* (Color and font) Write a program that displays five texts vertically, as shown *
* in Figure 14.44a. Set a random color and opacity for each text and set the     *
* font of each text to Times Roman, bold, italic, and 22 pixels.                 *
*********************************************************************************/
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercise_14_04 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a HBox
		HBox hBox = new HBox(10);
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setAlignment(Pos.CENTER);

		// Add text to hBox
		for (int i = 0; i < 5; i++) {
			// Crate a Text and set its properties
			Text text = new Text("Java");
			text.setFont(Font.font("Times Roman", FontWeight.BOLD,
			FontPosture.ITALIC, 22));
			text.setRotate(90);

			// Set a random color and opacity
			text.setFill(new Color(Math.random(), Math.random(), 
				Math.random(), Math.random()));
			hBox.getChildren().add(text);
		}

		// Create a scene and place it in the stage
		Scene scene = new Scene(hBox, 300, 100);
		primaryStage.setTitle("Exercise_14_04"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}