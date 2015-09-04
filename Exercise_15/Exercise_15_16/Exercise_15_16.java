/*********************************************************************************
* (Two movable vertices and their distances) Write a program that displays two   *
* circles with radius 10 at location (40, 40) and (120, 150) with a line         *
* connecting the two circles, as shown in Figure 15.28b. The distance between    *
* the circles is displayed along the line. The user can drag a circle. When that *
* happens, the circle and its line are moved and the distance between the        *
* circles is updated.                                                            *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Exercise_15_16 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();
	
		// Create two circles
		Circle circle1 = new Circle(40, 40, 10);
		setProperties(circle1);
		Circle circle2 = new Circle(120, 150, 10);
		setProperties(circle2);

		// Place nodes in pane
		pane.getChildren().addAll(getLine(circle1, circle2), circle1,
			circle2, getText(circle1, circle2));

		// Create and register the handle
		pane.setOnMouseDragged(e -> {
			if (circle1.contains(e.getX(), e.getY())) {
				pane.getChildren().clear();
				circle1.setCenterX(e.getX());
				circle1.setCenterY(e.getY());
				pane.getChildren().addAll(getLine(circle1, circle2), circle1,
					circle2, getText(circle1, circle2));
			}
			else if (circle2.contains(e.getX(), e.getY())) {
				pane.getChildren().clear();
				circle2.setCenterX(e.getX());
				circle2.setCenterY(e.getY());
				pane.getChildren().addAll(getLine(circle1, circle2), circle1,
					circle2, getText(circle1, circle2));
			}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("Exercise_15_16"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	// Return a text of the distance between two circles
	private Text getText(Circle circle1, Circle circle2) {
		return new Text((circle1.getCenterX() + circle2.getCenterX()) / 2, 
			(circle1.getCenterY() + circle2.getCenterY()) / 2, 
			distance(circle1, circle2));
	}

	// Return a line drawn between two circles
	private Line getLine(Circle circle1, Circle circle2) {
		return new Line(circle1.getCenterX(), circle1.getCenterY(),
			circle2.getCenterX(), circle2.getCenterY());
	}

	// Set specified properties in a circle
	private void setProperties(Circle c) {
		c.setFill(Color.WHITE);
		c.setStroke(Color.BLACK);
	}

	// Return distane between two circles
	private String distance(Circle c1, Circle c2) {
		double distance = Math.sqrt(Math.pow(c2.getCenterX() - c1.getCenterX(), 2)
			+ Math.pow(c2.getCenterY() - c1.getCenterY(), 2)) - 20;
		return String.format("%.0f", distance);
	}
}