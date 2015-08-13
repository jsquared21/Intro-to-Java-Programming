/**********************************************************************************
* (Tic-tac-toe board) Write a program that displays a tic-tac-toe board, as shown *
* in Figure 14.43b. A cell may be X, O, or empty. What to display at each cell is *
* randomly decided. The X and O are images in the files x.gif and o.gif.          *
***********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Exercise_14_02 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		GridPane pane = new GridPane();

		// Add nodes to pane
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int n = (int)(Math.random() * 3);
				if (n == 0)
					pane.add(new ImageView(new Image("image/x.gif")), j, i);
				else if (n == 1)
					pane.add(new ImageView(new Image("image/o.gif")), j, i);
				else
					continue;
			}
		}

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 120, 130);
		primaryStage.setTitle("Exercise_14_02"); // Set title for stage
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}