/*********************************************************************************
* (Paint a smiley face) Write a program that paints a smiley face, as shown in   *
* Figure 14.46a.                                                                 *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;

public class Exercise_14_11 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a stack pane
		StackPane stackPane = new StackPane();
		StackPane stackPane2 = new StackPane();

		// Crate a pane
		Pane pane = new Pane();
		stackPane2.setPadding(new Insets(40, 40, 40, 40));

		// Create a circle and place it in a stack pane
		Circle circle = getCircle();
		stackPane.getChildren().add(circle);

		// Create a Polygon and place it in a stack pane
		Polygon polygon = getPolygon(circle);
		stackPane.getChildren().add(polygon);

		// Create two ellipse
		Ellipse ellipse1 = getEllipse(circle); 
		ellipse1.setCenterX(circle.getRadius() - circle.getRadius() / 2.5);
		Ellipse ellipse2 = getEllipse(circle); 
		ellipse2.setCenterX(circle.getRadius() + circle.getRadius() / 2.5);

		// Create two circles
		Circle circle2 = getCircle(ellipse1);
		Circle circle3 = getCircle(ellipse2);

		// Create an Arc
		Arc arc = getArc(circle);

		// Place nodes in a pane
		pane.getChildren().addAll(stackPane, ellipse1, 
			ellipse2, circle2, circle3, arc);

		// Place pane in a stack pane
		stackPane2.getChildren().add(pane);


		// Create a scene and place it in the stage
		Scene scene = new Scene(stackPane2);
		primaryStage.setTitle("Exercise_14_11"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/** Return a Arc of specified properties */
	private Arc getArc(Circle c) {
		Arc a = new Arc(c.getRadius(), c.getRadius() * 1.30, 
			c.getRadius() / 2, c.getRadius() / 4, 0, -180);
		a.setType(ArcType.OPEN);
		a.setFill(Color.WHITE);
		a.setStroke(Color.BLACK);
		return a;
	}

	/** Return a circle of specified properties */
	private Circle getCircle(Ellipse e) {
		Circle c = new Circle(e.getCenterX(), e.getCenterY(), 
			e.getRadiusY() - (e.getRadiusX() - e.getRadiusY()));
		return c;
	}

	/** Return an Ellipse of specified properties */
	private Ellipse getEllipse(Circle c) {
		Ellipse e = new Ellipse();
		e.setCenterY(c.getRadius() - c.getRadius() / 3);
		e.setRadiusX(c.getRadius() / 4);
		e.setRadiusY(c.getRadius() / 3 - 20);
		e.setStroke(Color.BLACK);
		e.setFill(Color.WHITE);
		return e; 
	}

	/** Return a Polygon of specified properties */
	private Polygon getPolygon(Circle c) {
		double length = c.getRadius() / 4;
		Polygon p = new Polygon(c.getCenterX(), c.getCenterY() - length,
			c.getCenterX() - length, c.getCenterY() + length, c.getCenterX() + length, 
			c.getCenterY() + length);
		p.setFill(Color.WHITE);
		p.setStroke(Color.BLACK);
		return p;
	}

	/** Returns a circle of specified properties */ 
	private Circle getCircle() {
		Circle c = new Circle();
		c.setRadius(150);
		c.setStroke(Color.BLACK);
		c.setFill(Color.WHITE);
		return c;
	}
}