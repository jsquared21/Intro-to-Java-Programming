/*********************************************************************************
* (Game: display a checkerboard) Write a program that displays a checkerboard in *
* which each white and black cell is a Rectangle with a fill color black or      *
* white, as shown in Figure 14.44c.                                              *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class Exercise_14_06 extends Application {
	@Override // Override the start method in the application class
	public void start(Stage primaryStage) {
		// Create a GridPane
		GridPane pane = new GridPane();

		// Create 64 rectangles and add to pane
		int count = 0;
		double s = 100; // side of rectangle
		for (int i = 0; i < 8; i++) {
			count++;
			for (int j = 0; j < 8; j++) {
				Rectangle r = new Rectangle(s, s, s, s);
				if (count % 2 == 0)
					r.setFill(Color.WHITE);
				pane.add(r, j, i);
				count++;
			}
		}

		// Create a scene and place it in the stage
		Scene scene = new Scene (pane);
		primaryStage.setTitle("Exercise_14_06"); // Set the stage title
		primaryStage.setScene(scene); // Place in scene in the stage
		primaryStage.show(); // Display the stage;
	}
}