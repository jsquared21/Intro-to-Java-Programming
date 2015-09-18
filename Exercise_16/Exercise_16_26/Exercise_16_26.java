/*********************************************************************************
* (Simulation: raise flag and play anthem) Write a program that displays a flag  *
* rising up, as shown in Figure 15.14. As the national flag rises, play the      *
* national anthem. (You may use a flag image and anthem audio file from Listing  *
* 16.15.)                                                                        *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Exercise_16_26 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create an image
		ImageView image = new ImageView(new Image(
			"http://cs.armstrong.edu/liang/common/image/flag6.gif"));

		// Create a media player
		MediaPlayer audio = new MediaPlayer(new Media(
			"http://cs.armstrong.edu/liang/common/audio/anthem/anthem6.mp3"));
		audio.play();

		// Create a line
		Line line = new Line(250, 600, 250, -70);

		// Create a pane
		Pane pane = new Pane(image);

		// Create a path transition
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(70000));
		pt.setPath(line);
		pt.setNode(image);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.play();

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setTitle("Exercise_16_26"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}