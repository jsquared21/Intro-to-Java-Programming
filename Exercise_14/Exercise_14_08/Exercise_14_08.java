/*************************************************************************************
* (Display 54 cards) Expand Exercise 14.3 to display all 54 cards (including two     *
* jokers), nine per row. The image files are jokers and are named 53.jpg and 54.jpg. *
*************************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class Exercise_14_08 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a GridPane
		GridPane pane = new GridPane();

		// Create a list of Integers
		ArrayList<Integer> cards = getCards();

		// Place 54 nodes in the pane, nine per row
		int count = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 6; j++) {
				pane.add(new ImageView(new Image("image/card/" + 
					cards.get(count) + ".png")), i, j);
				count++;
			}
		}

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_14_08"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	// Return a shuffled list of Integers 1-54 
	private ArrayList<Integer> getCards() {
		ArrayList<Integer> c = new ArrayList<>();
		for (int i = 1; i <= 54; i++)
			c.add(i);
		java.util.Collections.shuffle(c);
		return c;
	}
}