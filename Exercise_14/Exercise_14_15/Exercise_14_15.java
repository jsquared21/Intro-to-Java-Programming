/*********************************************************************************
* (Display a STOP sign) Write a program that displays a STOP sign, as shown in   *
* Figure 14.47b. The octagon is in red and the sign is in white. (Hint: Place an *
* octagon and a text in a stack pane.)                                           *
*********************************************************************************/
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;

public class Exercise_14_15 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a stack pane
		StackPane stackPane = new StackPane();

		// Create a polygon and set its properties
		Polygon polygon = new Polygon();
		stackPane.getChildren().add(polygon);
		polygon.setFill(Color.RED);
		polygon.setRotate(20);
		ObservableList<Double> list = polygon.getPoints();

		final double WIDTH = 200, HEIGHT = 200;
		double centerX = WIDTH / 2, centerY = HEIGHT / 2;
		double radius = Math.min(WIDTH, HEIGHT) * 0.4;

		// Add points to polygon list
		for (int i = 0; i < 8; i++) {
		 	list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8));
		 	list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8));
		}

		// Create a text and set its properties
		Text text = new Text("STOP");
		text.setFont(Font.font("Times new Roman", FontWeight.BOLD, 40));
		text.setFill(Color.WHITE);
		stackPane.getChildren().add(text);

		// Create a scene and place it in the stage
		Scene scene = new Scene(stackPane, WIDTH, HEIGHT);
		primaryStage.setTitle("Exercise_14_15"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}