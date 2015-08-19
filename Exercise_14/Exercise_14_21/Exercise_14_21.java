/*********************************************************************************
* (Two circles and their distance) Write a program that draws two filled circles *
* with radius 15 pixels, centered at random locations, with a line connecting    *
* the two circles. The distance between the two centers is displayed on the      *
* line, as shown in Figure 14.49b.                                               *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Exercise_14_21 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();

		// Create two circles
		Circle circle1 = new Circle(Math.random() * 201, Math.random() * 201, 15);
		Circle circle2 = new Circle(Math.random() * 201, Math.random() * 201, 15);

		// Create a line
		Line line = new Line(circle1.getCenterX(), circle1.getCenterY(),
			circle2.getCenterX(), circle2.getCenterY());

		// Calculate distane between the two centers of the circles
		double distance = Math.sqrt(Math.pow(line.getEndX() - line.getStartX(), 2)
			+ Math.pow(line.getEndY() - line.getStartY(), 2));

		// Create a text
		double x = (line.getStartX() + line.getEndX()) / 2;
		double y = (line.getStartY() + line.getEndY()) / 2;
		Text text = new Text(x, y, String.valueOf(distance));
		
		// Add nodes to pane
		pane.getChildren().addAll(circle1, circle2, line, text);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_14_21"); // Set the stage title 
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}