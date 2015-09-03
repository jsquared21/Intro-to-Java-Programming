/*********************************************************************************
* (Geometry: inside a rectangle?) Write a program that draws a fixed rectangle   *
* centered at (100, 60) with width 100 and height 40. Whenever the mouse is      *
* moved, display a message indicating whether the mouse point is inside the      *
* rectangle at the mouse point or outside of it, as shown in Figure 15.27b. To   *
* detect whether a point is inside a polygon, use the contains method defined in *
* the Node class.                                                                *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_15_13 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();

		// Create a rectangle
		Rectangle rectangle = new Rectangle(100, 60, 100, 40);
		rectangle.setFill(Color.WHITE);
		rectangle.setStroke(Color.BLACK);

		// Place the rectangle in the pane
		pane.getChildren().add(rectangle);

		// Create and register the handle
		pane.setOnMouseMoved(e -> {
			pane.getChildren().clear();
			Text text = new Text(e.getX(), e.getY(), "Mouse point is " +
				(rectangle.contains(e.getX(), e.getY()) ? "inside " : "outside ") +
				"the rectangle");
			pane.getChildren().addAll(rectangle, text);
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 200);
		primaryStage.setTitle("Exercise_15_13"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}