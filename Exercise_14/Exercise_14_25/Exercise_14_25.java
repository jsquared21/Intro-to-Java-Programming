/*********************************************************************************
* (Random points on a circle) Modify Programming Exercise 4.6 to create five     *
* random points on a circle, form a polygon by connecting the points clockwise,  *
* and display the circle and the polygon, as shown in Figure 14.51b.             *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import java.util.ArrayList;

public class Exercise_14_25 extends Application {
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();
		pane.setPadding(new Insets(10, 10, 10, 10));

		// Create a circle
		Circle circle = new Circle(60, 60, 40);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		pane.getChildren().addAll(circle);

		// Create a polygon
		Polygon polygon = new Polygon();
		pane.getChildren().add(polygon);
		polygon.setFill(Color.WHITE);
		polygon.setStroke(Color.BLACK);
		ObservableList<Double> list = polygon.getPoints();

		// Generate random angles in radians between 0 and 2PI
		ArrayList<Double> angles = new ArrayList<>();
		for (int i = 0; angles.size() < 5; i++) {
			double angle = (Math.random() * (2 * Math.PI));
			if (!angles.contains(angle)) {
				angles.add(angle);
			}
		}

		// Sort angles clockwise
		java.util.Collections.sort(angles);

		// Get 5 points on the circle
		for (int i = 0; i < angles.size(); i++) {
			list.add(circle.getCenterX() + circle.getRadius() * 
				Math.cos(angles.get(i)));
			list.add(circle.getCenterY() - circle.getRadius() * 
				Math.sin(angles.get(i)));
		}

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_14_25"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage 
	}
}