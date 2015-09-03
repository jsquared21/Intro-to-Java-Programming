/*********************************************************************************
* (Geometry: inside a polygon?) Write a program that draws a fixed polygon with  *
* points at (40, 20), (70, 40), (60, 80), (45, 45), and (20, 60). Whenever the   *
* mouse is moved, display a message indicating whether the mouse point is inside *
* the polygon at the mouse point or outside of it, as shown in Figure 15.27c. To *
* detect whether a point is inside a polygon, use the contains method defined in *
* the Node class.                                                                *
*********************************************************************************/
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_15_14 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();

		// Create a polygon and set it properties
		Polygon polygon = new Polygon();
		pane.getChildren().add(polygon);
		ObservableList<Double> list = polygon.getPoints();
		list.addAll(40.0, 20.0, 70.0, 40.0, 60.0, 80.0, 45.0, 45.0, 20.0, 60.0);
		polygon.setFill(Color.WHITE);
		polygon.setStroke(Color.BLACK);

		// Create and register the handle
		pane.setOnMouseMoved(e -> {
			pane.getChildren().clear();
			Text text = new Text(e.getX(), e.getY(), "Mouse point is " +
				(polygon.contains(e.getX(), e.getY()) ? "inside " : "outside ") +
				"the polygon");
			pane.getChildren().addAll(polygon, text);
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 300, 150);
		primaryStage.setTitle("Exercise_15_14"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}