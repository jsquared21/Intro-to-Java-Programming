/*********************************************************************************
* (Connect two circles) Write a program that draws two circles with radius 15    *
* pixels, centered at random locations, with a line connecting the two circles.  *
* The line should not cross inside the circles, as shown in Figure 14.49c.       *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;

public class Exercise_14_22 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();

		// Create two circles
		Circle c1 = new Circle(20 + Math.random() * 201,
			20 + Math.random() * 201, 15);
		c1.setFill(Color.WHITE);
		c1.setStroke(Color.BLACK);
		
		Circle c2 = new Circle(20 + Math.random() * 201,
			20 + Math.random() * 201, 15);
		c2.setFill(Color.WHITE);
		c2.setStroke(Color.BLACK);

		// Create a line
		Line line = new Line(c1.getCenterX(), c1.getCenterY(),
			c2.getCenterX(), c2.getCenterY());

		// Add nodes to pane
		pane.getChildren().addAll(line, c1, c2, new Text(c1.getCenterX(), 
			c1.getCenterY(), "1"), new Text(c2.getCenterX(), c2.getCenterY(), "2"));

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_14_22"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}