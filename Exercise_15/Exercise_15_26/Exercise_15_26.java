/*********************************************************************************
* (Change opacity) Rewrite Programming Exercise 15.24 so that the ball’s opacity *
* is changed as it swings.                                                       *
*********************************************************************************/
import javafx.animation.PathTransition;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise_15_26 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();

		// Create a arc
		Arc arc = new Arc(100, 50, 75, 25, 0, -180);
		arc.setFill(Color.WHITE);
		arc.setStroke(Color.BLACK);

		// Create a circle
		Circle ball = new Circle(100, 75, 10);

		// Place nodes in pane
		pane.getChildren().addAll(arc, ball);

		// Create a path transition
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(arc);
		pt.setNode(ball);
		pt.setOrientation(
			PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play(); // Start animation

		// Create a fade transition to ball
		FadeTransition ft = 
			new FadeTransition(Duration.millis(4000), ball);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play(); // Start animation

		// Create and register the handle
		pane.setOnMousePressed(e -> {
			pt.pause();
			ft.pause();
		});

		pane.setOnMouseReleased(e -> {
			pt.play();
			ft.play();
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 200, 100);
		primaryStage.setTitle("Exercise_15_26"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}