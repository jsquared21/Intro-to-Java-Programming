/*********************************************************************************
* (Display circles) Write a Java program that displays ovals, as shown in Figure *
* 18.12b. The circles are centered in the pane. The gap between two adjacent     *
* circles is 10 pixels, and the gap between the border of the pane and the       *
* largest circle is also 10.                                                     *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class Exercise_18_20 extends Application {
	protected static StackPane pane = new StackPane();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		int numberOfCircles = 16; // Number of ovals
		addCircles(numberOfCircles);
		pane.setPadding(new Insets(10, 10, 10, 10));

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_18_20"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/** Method adds n circles to pane recursively */
	public static void addCircles(int n) {
		if (n > 0) {
			Circle circle = new Circle(10 * n);
			circle.setFill(Color.WHITE);
			circle.setStroke(Color.BLACK);
			pane.getChildren().add(circle);
			addCircles(n - 1); // Recursive call
		}
	}
}