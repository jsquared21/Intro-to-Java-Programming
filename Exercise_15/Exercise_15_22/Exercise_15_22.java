/***********************************************************************************
* (Auto resize cylinder) Rewrite Programming Exercise 14.10 so that the cylinder’s *
* width and height are automatically resized when the window is resized.           *
***********************************************************************************/
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

public class Exercise_15_22 extends Application {
	@Override // Override the start method in the Applicaton class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();

		// Create an ellipse and set its properties
		Ellipse ellipse = new Ellipse(100, 40, 50, 20);
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
		Scene scene = new Scene(pane, ellipse.getRadiusX() * 4, 
			ellipse.getRadiusY() * 10);
		primaryStage.setTitle("Exercise_15_22"); // Set the stage title
		primaryStage.setScene(scene); // Place the scenen in the stage
		primaryStage.show(); // Display the stage

		// Create listeners
		pane.widthProperty().addListener(ov ->
			ellipse.setRadiusX(pane.getWidth() / 4)
		);

		pane.widthProperty().addListener(ov ->
			arc1.setRadiusX(ellipse.getRadiusX())
		);

		pane.widthProperty().addListener(ov ->
			arc2.setRadiusX(ellipse.getRadiusX())
		);

		pane.widthProperty().addListener(ov ->
			ellipse.setCenterX(pane.getWidth() / 2)
		);

		pane.widthProperty().addListener(ov ->
			arc1.setCenterX(pane.getWidth() / 2)
		);

		pane.widthProperty().addListener(ov ->
			arc2.setCenterX(pane.getWidth() / 2)
		);

		pane.widthProperty().addListener(ov ->
			line1.setStartX(ellipse.getCenterX() - ellipse.getRadiusX())
		);

		pane.widthProperty().addListener(ov ->
			line2.setStartX((ellipse.getCenterX() - ellipse.getRadiusX()) + 
			ellipse.getRadiusX() * 2)
		);

		pane.widthProperty().addListener(ov ->
			line1.setEndX(ellipse.getCenterX() - ellipse.getRadiusX())
		);

		pane.widthProperty().addListener(ov ->
			line2.setEndX((ellipse.getCenterX() - ellipse.getRadiusX()) 
			+ ellipse.getRadiusX() * 2)
		);

		pane.heightProperty().addListener(ov ->
			ellipse.setRadiusY(pane.getHeight() / 10)
		);

		pane.heightProperty().addListener(ov ->
			arc1.setRadiusY(pane.getHeight() / 10)
		);

		pane.heightProperty().addListener(ov ->
			arc2.setRadiusY(pane.getHeight() / 10)
		);

		pane.heightProperty().addListener(ov ->
			ellipse.setCenterY(pane.getHeight() * .25)
		);

		pane.heightProperty().addListener(ov ->
			arc1.setCenterY(pane.getHeight() * .75)
		);

		pane.heightProperty().addListener(ov ->
			arc2.setCenterY(pane.getHeight() * .75)
		);
		
		pane.heightProperty().addListener(ov ->
			line1.setStartY(ellipse.getCenterY())
		);

		pane.heightProperty().addListener(ov ->
			line2.setStartY(ellipse.getCenterY())
		);

		pane.heightProperty().addListener(ov ->
			line1.setEndY(arc1.getCenterY())
		);

		pane.heightProperty().addListener(ov ->
			line2.setEndY(arc1.getCenterY())
		);
	}
}