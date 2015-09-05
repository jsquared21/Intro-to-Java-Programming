/*********************************************************************************
* (Animation: palindrome) Write a program that animates a palindrome swing as    *
* shown in Figure 15.31. Press/release the mouse to pause/resume the animation.  *
*********************************************************************************/
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise_15_24 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();

		// Create a arc
		Arc arc = new Arc(100, 50, 75, 25, 0, -180);
		arc.setFill(Color.WHITE);
		arc.setStroke(Color.BLACK);

		// Create a circle
		Circle circle = new Circle(100, 75, 5);

		// Place nodes in pane
		pane.getChildren().addAll(arc, circle);

		// Create a path transition
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(arc);
		pt.setNode(circle);
		pt.setOrientation(
			PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play(); // Start animation

		// Create and register the handle
		pane.setOnMousePressed(e -> {
			pt.pause();
		});

		pane.setOnMouseReleased(e -> {
			pt.play();
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 200, 100);
		primaryStage.setTitle("Exercise_15_24"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}