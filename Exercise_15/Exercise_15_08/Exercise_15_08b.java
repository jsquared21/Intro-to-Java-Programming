/*********************************************************************************
* (Display the mouse position) Write two programs, such that one displays the    *
* mouse position when the mouse button is clicked (see Figure 15.26a) and the    *
* other displays the mouse position when the mouse button is pressed and ceases  *
* to display it when the mouse button is released.                               *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_15_08b extends Application {
	@Override // Override the start method on the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();

		// Create and register the handler
		pane.setOnMousePressed(e -> {
			pane.getChildren().add(new Text(e.getX(), e.getY(),
				"(" + e.getX() + ", " + e.getY() + ")"));
		});

		pane.setOnMouseReleased(e -> {
			pane.getChildren().clear();
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("Exercise_15_08b"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}