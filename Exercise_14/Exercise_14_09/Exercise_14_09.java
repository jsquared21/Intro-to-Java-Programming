/*********************************************************************************
* (Create four fans) Write a program that places four fans in a GridPane with    *
* two rows and two columns, as shown in Figure 14.45b.                           *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class Exercise_14_09 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a GridPane and set its properties
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		// Place nodes in the pane
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				// Create a stack pane
				StackPane stackPane = new StackPane();

				// Add circle to stack pane
				Circle circle = getCircle();
				stackPane.getChildren().add(circle);

				// Add Arcs to stack pane
				getArcs(stackPane);

				gridPane.add(stackPane, i, j);
			}
		}

		// Create a scene and place in in the stage
		Scene scene = new Scene(gridPane);
		primaryStage.setTitle("Exercise_14_09"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/** Add four arcs to a pane and place them in a stack pane */
	private void getArcs(StackPane stackPane) {
		double angle = 30; // Start angle
		for (int i = 0; i < 4; i++) {
			Pane pane = new Pane();
			Arc arc = new Arc(100, 100, 80, 80, angle + 90, 35);
			arc.setFill(Color.BLACK);
			arc.setType(ArcType.ROUND);
			pane.getChildren().add(arc);
			stackPane.getChildren().add(pane);
			angle += 90;
		}
	}

	/** Return a Circle */
	private Circle getCircle() {
		Circle c = new Circle();
		c.setRadius(100);
		c.setStroke(Color.BLACK);
		c.setFill(Color.WHITE);
		return c;
	}
}