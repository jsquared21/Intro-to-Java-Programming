/*********************************************************************************
* (Use the ClockPane class) Write a program that displays two clocks. The hour,  *
* minute, and second values are 4, 20, 45 for the first clock and 22, 46, 15 for *
* the second clock, as shown in Figure 14.51c.                                   *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;

public class Exercise_14_26 extends Application {
	@Override // Override the start method in the application class
	public void start(Stage primaryStage) {
		// Create a vbox
		HBox pane = new HBox(10);
		pane.setPadding(new Insets(0, 20, 20, 0));

		// Create two clocks
		ClockPane clock1 = new ClockPane(4, 20, 45);
		ClockPane clock2 = new ClockPane(22, 46, 15);

		// Place clocks in pane
		pane.getChildren().addAll(clock1, clock2);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_14_26"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}