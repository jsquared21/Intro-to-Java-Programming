/*********************************************************************************
* (Display a cylinder) Write a program that draws a cylinder, as shown in        *
* Figure 14.45b. You can use the following method to set the dashed stroke for   *
* an arc:                                                                        *
*                                                                                *
*     arc.getStrokeDashArray().addAll(6.0, 21.0);                                *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class Exercise_14_10 extends Application {
	@Override // Override the start method in the Applicaton class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();

		// Create an ellipse and set its properties
		Ellipse ellipse = new Ellipse(75, 40, 50, 20);
		ellipse.setStroke(Color.BLACK);
		ellipse.setFill(Color.WHITE);

		// Create two Arcs and set their properties
		Arc arc1 = new Arc(ellipse.getCenterX(), 150, ellipse.getRadiusX(), 
			ellipse.getRadiusY(), 0, -180);
		arc1.setType(ArcType.OPEN);
		arc1.setFill(Color.WHITE);
		arc1.setStroke(Color.BLACK);

		Arc arc2 = new Arc(ellipse.getCenterX(), arc1.getCenterY(), 
			ellipse.getRadiusX(), ellipse.getRadiusY(), 0, 180);
		arc2.setType(ArcType.OPEN);
		arc2.setFill(Color.WHITE);
		arc2.setStroke(Color.BLACK);
		arc2.getStrokeDashArray().addAll(6.0, 21.0);

		// Create two lines and set thier properties
		Line line1 = new Line(ellipse.getCenterX() - ellipse.getRadiusX(), 
			ellipse.getCenterY(), ellipse.getCenterX() - ellipse.getRadiusX(),
			arc1.getCenterY());
		Line line2 = new Line((ellipse.getCenterX() - ellipse.getRadiusX()) + 
			ellipse.getRadiusX() * 2, ellipse.getCenterY(), 
			(ellipse.getCenterX() - ellipse.getRadiusX()) 
			+ ellipse.getRadiusX() * 2, arc1.getCenterY());

		// Place nodes in pane
		pane.getChildren().addAll(ellipse, arc1, arc2, line1, line2);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 150, 200);
		primaryStage.setTitle("Exercise_14_10"); // Set the stage title
		primaryStage.setScene(scene); // Place the scenen in the stage
		primaryStage.show(); // Display the stage
	}
}
