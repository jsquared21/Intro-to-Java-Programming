/*********************************************************************************
* (Count-up stopWatch) Write a program that simulates a stopWatch, as shown in   *
* Figure 16.45a. When the user clicks the Start button, the button’s label is    *
* changed to Pause, as shown in Figure 16.45b. When the user clicks the Pause    *
* button, the button’s label is changed to Resume, as shown in Figure 16.45c.    *
* The Clear button resets the count to 0 and resets the button’s label to Start. *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class Exercise_16_20 extends Application {
	protected Button btStart = new Button("Start");
	protected Button btClear = new Button("Clear");

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a hbox for buttons
		HBox paneForButtons = new HBox(5);
		paneForButtons.setAlignment(Pos.CENTER);
		paneForButtons.getChildren().addAll(btStart, btClear);

		// Create a Stopwatch
		StopWatch stopWatch = new StopWatch();

		// Create a border pane
		BorderPane pane = new BorderPane();
		pane.setBottom(paneForButtons);
		pane.setCenter(stopWatch);

		// Create and register handlers
		btStart.setOnAction(e -> {
			if (btStart.getText().equals("Start") ||
				 btStart.getText().equals("Resume")) {
				stopWatch.play();
				btStart.setText("Pause");
			} else {
				stopWatch.pause();
				btStart.setText("Resume");
			}
		});

		btClear.setOnAction(e -> {
			stopWatch.clear();
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_16_20"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}