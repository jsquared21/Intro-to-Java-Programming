/*********************************************************************************
* (Display three cards) Write a program that displays three cards randomly       *
* selected from a deck of 52, as shown in Figure 14.43c. The card image files    *
* are named 1.png, 2.png, …, 52.png and stored in the image/card directory. All  *
* three cards are distinct and selected randomly. Hint: You can select random    *
* cards by storing the numbers 1–52 to an array list, perform a random shuffle   *
* introduced in Section 11.12, and use the first three numbers in the array list *
* as the file names for the image.                                               *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import java.util.ArrayList;

public class Exercise_14_03 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a list of card numbers
		ArrayList<Integer> cards = getCards();
		// Create a HBox pane
		HBox pane = new HBox(5);
		pane.setPadding(new Insets(5, 5, 5, 5));

		// Add nodes to pane
		for (int i = 0; i < 3; i++) {
			pane.getChildren().add(new ImageView(new Image("image/card/" +
				cards.get(i) + ".png")));
		}

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_14_03"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/** Returns a list with numbers 1-52 stored in random order */
	private ArrayList<Integer> getCards() {
		ArrayList<Integer> cards = new ArrayList<>();
		for (int i = 0; i < 52; i++) {
			cards.add(i + 1);
		}
		java.util.Collections.shuffle(cards);
		return cards;
	}
}