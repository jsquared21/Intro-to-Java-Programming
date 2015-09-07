/*********************************************************************************
* (Racing car) Write a program that simulates car racing, as shown in Figure     *
* 15.34a. The car moves from left to right. When it hits the right end, it       *
* restarts from the left and continues the same process. You can use a timer to  *
* control animation. Redraw the car with a new base coordinates (x, y), as shown *
* in Figure 15.34b. Also let the user pause/resume the animation with a button   *
* press/release and increase/decrease the car speed by pressing the UP and       *
* DOWN arrow keys.                                                               *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class Exercise_15_29 extends Application {
	@Override // Override the start method on the Application class
	public void start(Stage primaryStage) {
		// Create a car
		CarPane pane = new CarPane();

		// Create and register handles
		pane.setOnMousePressed(e -> pane.pause());
		pane.setOnMouseReleased(e -> pane.play());

		pane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				pane.increaseSpeed();
			}
			else if (e.getCode() == KeyCode.DOWN) {
				pane.decreaseSpeed();
			}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 600, 100);
		primaryStage.setTitle("Exercise_15_29"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		pane.requestFocus(); // Request focus
	}
}