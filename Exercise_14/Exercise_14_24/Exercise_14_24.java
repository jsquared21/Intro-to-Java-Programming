/**********************************************************************************
* (Geometry: Inside a polygon?) Write a program that prompts the user to enter    *
* the coordinates of five points from the command line. The first four points     *
* form a polygon, and the program displays the polygon and a text that indicates  *
* whether the fifth point is inside the polygon, as shown in Figure 14.51a. Hint: *
* Use the Node’s contains method to test whether a point is inside a node.        *
**********************************************************************************/
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.util.Scanner;

public class Exercise_14_24 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a scanner
		Scanner input = new Scanner(System.in);

		// Create a pane
		Pane pane = new Pane();

		// Create a polygon
		Polygon polygon = new Polygon();
		polygon.setFill(Color.WHITE);
		polygon.setStroke(Color.BLACK);
		pane.getChildren().add(polygon);
		ObservableList<Double> list = polygon.getPoints();

		// Prompt the user to enter the coordinates of five points
		System.out.print("Enter five points: ");
		for (int i = 0; i < 8; i++) {
			list.add(input.nextDouble());
		}
		double x = input.nextDouble();
		double y = input.nextDouble();

		// Create a circle
		Circle circle = new Circle(x, y, 5);
		pane.getChildren().add(circle);

		// Create a Text
		Text text = new Text("        The point is " + 
			(polygon.contains(x, y) ? "" : "not ") + "inside the polygon  ");

		// Create a vbox
		VBox vbox = new VBox(5);
		vbox.getChildren().addAll(pane, text);

		// Create a Scene and place it in the stage
		Scene scene = new Scene(vbox);
		primaryStage.setTitle("Exercise_14_24"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}