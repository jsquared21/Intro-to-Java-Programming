/*********************************************************************************
* (Geometry: two rectangles intersect?) Write a program that enables the user to *
* rectangles specify the location and size of the rectangles and displays        *
* whether the two intersect, as shown in Figure 16.39b. Enable the user to point *
* the mouse inside a rectangle and drag it. As the rectangle is being dragged,   *
* the rectangle’s center coordinates in the text fields are updated.             *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

public class Exercise_16_09 extends Application {
	protected Rectangle rectangle = getRectangle();
	protected Pane paneForRectangles = new Pane(rectangle);
	protected TablePane table = new TablePane();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a table
		paneForRectangles.getChildren().addAll(
			table.getRectangle1(), table.getRectangle2());

		// Create a button
		Button btRedrawCircles = new Button("Redraw Rectangles");

		// Create a vbox
		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(intersect(), paneForRectangles,
			table, btRedrawCircles);

		// Create and register handlers
		btRedrawCircles.setOnAction(e -> {
			table.redraw();
			pane.getChildren().remove(0);
			pane.getChildren().add(0, intersect());
		});

		table.getRectangle1().setOnMouseDragged(e -> {
			if (table.getRectangle1().contains(e.getX(), e.getY())) {
				table.setRectangle1X(e.getX() - (table.getRectangle1Width() / 2));
				table.setRectangle1Y(e.getY() - (table.getRectangle1Height() / 2));
				table.setTfRectangle1X(String.valueOf(e.getX() 
					- (table.getRectangle1Width() / 2)));
				table.setTfRectangle1Y(String.valueOf(e.getY() 
					- (table.getRectangle1Height() / 2)));
			}
			pane.getChildren().remove(0);
			pane.getChildren().add(0, intersect());
		});

		table.getRectangle2().setOnMouseDragged(e -> {
			if (table.getRectangle2().contains(e.getX(), e.getY())) {
				table.setRectangle2X(e.getX() - (table.getRectangle2Width() / 2));
				table.setRectangle2Y(e.getY() - (table.getRectangle2Height() / 2));
				table.setTfRectangle2X(String.valueOf(e.getX() 
					- (table.getRectangle2Width() / 2)));
				table.setTfRectangle2Y(String.valueOf(e.getY() 
					- (table.getRectangle2Height() / 2)));
			}
			pane.getChildren().remove(0);
			pane.getChildren().add(0, intersect());
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_16_08"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/** Creates a text stating if circles intersect */
	private Text intersect() {
		return new Text("Two circles intersect? " +
			(isIntersect() ? "Yes" : "No"));
	}

	/** Returns true if circles inIntersect */
	private boolean isIntersect() {
		return 
			(getDistance(table.getRectangle2X(), table.getRectangle1X() + 
				table.getRectangle1Width()) < 
				table.getRectangle1Width() + table.getRectangle2Width() &&
		  	(getDistance(table.getRectangle2Y(), table.getRectangle1Y() + 
		  		table.getRectangle1Height()) < 
		  		table.getRectangle1Height() + table.getRectangle2Height())) &&
			(getDistance(table.getRectangle1X(), table.getRectangle2X() + 
				table.getRectangle2Width()) < 
				table.getRectangle1Width() + table.getRectangle2Width() &&
		  	(getDistance(table.getRectangle1Y(), table.getRectangle2Y() + 
		  		table.getRectangle2Height()) < 
		  		table.getRectangle1Height() + table.getRectangle2Height())); 
	}

	/** Return distance */
	private double getDistance(double p1, double p2) {
		return Math.sqrt(Math.pow(p2 - p1, 2));
	}

	/** Return a rectangle */
	private Rectangle getRectangle() {
		Rectangle r = new Rectangle(0, 0, 280, 110);
		r.setStroke(Color.WHITE);
		r.setFill(Color.WHITE);
		return r;
	}
}