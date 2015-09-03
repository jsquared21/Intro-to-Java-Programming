/*********************************************************************************
* (Geometry: inside a circle?) Write a program that draws a fixed circle         *
* centered at (100, 60) with radius 50. Whenever the mouse is moved, display a   *
* message indicating whether the mouse point is inside the circle at the mouse   *
* point or outside of it, as shown in Figure 15.27a.                             *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_15_12 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();

		// Create a circle and set its properties
		Circle circle = new Circle(100, 60, 50);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		pane.getChildren().add(circle);

		// Create and register the handle
		pane.setOnMouseMoved(e -> {
			pane.getChildren().clear();
			Text text = new Text(e.getX(), e.getY(), "Mouse point is " + 
				(circle.contains(e.getX(), e.getY()) ? "inside " : "outside ") +
				"the circle");
			pane.getChildren().addAll(circle, text);
		});

		// Create a Scene and place it in the stage
		Scene scene = new Scene(pane, 350, 150);
		primaryStage.setTitle("Exercise_15_12"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}