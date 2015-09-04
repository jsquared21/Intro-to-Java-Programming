/*********************************************************************************
* (Move a rectangle using mouse) Write a program that displays a rectangle. You  *
* can point the mouse inside the rectangle and drag (i.e., move with mouse       *
* pressed) the rectangle wherever the mouse goes. The mouse point becomes the    *
* center of the rectangle.                                                       *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Exercise_15_18 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();

		// Create a rectangle
		Rectangle rectangle = new Rectangle(5, 5, 30, 20);
		pane.getChildren().add(rectangle);

		// Create and register the handle
		pane.setOnMouseDragged(e -> {
			if (rectangle.contains(e.getX(), e.getY())) {
				pane.getChildren().clear();
				rectangle.setX(e.getX() - rectangle.getWidth() * .5);
				rectangle.setY(e.getY() - rectangle.getHeight() * .5);
				pane.getChildren().add(rectangle);
			}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("Exercise_15_18"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}