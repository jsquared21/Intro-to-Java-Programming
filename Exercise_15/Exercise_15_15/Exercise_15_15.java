/*********************************************************************************
* (Geometry: add and remove points) Write a program that lets the user click on  *
* a pane to dynamically create and remove points (see Figure 15.28a). When the   *
* user left-clicks the mouse (primary button), a point is created and displayed  *
* at the mouse point. The user can remove a point by pointing to it and right-   *
* clicking the mouse (secondary button).                                         *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.input.MouseButton;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercise_15_15 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();

		// Create and register the handle
		pane.setOnMouseClicked(e -> {
			// Create a circle
			Circle circle = new Circle(e.getX(), e.getY(), 5);
			circle.setFill(Color.WHITE);
			circle.setStroke(Color.BLACK);
			if (e.getButton() == MouseButton.PRIMARY) {
				pane.getChildren().add(circle);
			}
			else if (e.getButton() == MouseButton.SECONDARY) {
				ObservableList<Node> list = pane.getChildren();
				for (int i = 0; i < list.size(); i++) {
					Circle c = (Circle)list.get(i);
					if (circle.contains(c.getCenterX(), c.getCenterY())) {
						list.remove(i);
					}
				}
			}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_15_15"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}