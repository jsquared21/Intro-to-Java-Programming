/*********************************************************************************
* (Slide show) Twenty-five slides are stored as image files (slide0.jpg, . .     *
* slide24.jpg) in the image directory downloadable along with the source code in *
* the book. The size of each image is 800 * 600. Write a program that            *
* automatically displays the slides repeatedly. Each slide is shown for two      *
* seconds. The slides are displayed in order. When the last slide finishes, the  *
* first slide is redisplayed, and so on. Click to pause if the animation is      *
* currently playing. Click to resume if the animation is currently paused.       *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise_15_30 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		ImagePane pane = new ImagePane();

		// Create and register the handle
		

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_15_30"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		pane.requestFocus();
	}
}